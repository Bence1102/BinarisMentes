package main;

import HVGUI.HarcosVarazsloGUI;
import Model.JatekModel;
import javax.swing.*;
import java.io.*;

public class Elinditas {
    public static void main(String[] args){
        HarcosVarazsloGUI gui = new HarcosVarazsloGUI();
        gui.setVisible(true);

       
        final JatekModel[] modelTomb = { new JatekModel() };

        
        gui.getjButton3().addActionListener(e -> {
            modelTomb[0].ujHarcos("Harcos");
            JOptionPane.showMessageDialog(gui, "Harcos létrehozva!");
        });

       
        gui.getjButton5().addActionListener(e -> {
            modelTomb[0].ujVarazslo("Varázsló");
            JOptionPane.showMessageDialog(gui, "Varázsló létrehozva!");
        });

       
        gui.getjButton10().addActionListener(e -> {
            String eredmeny = modelTomb[0].csata();
            gui.getjTextField1().setText(eredmeny);
        });

        
        gui.getjMenuItem2().addActionListener(e -> ment(modelTomb[0], "mentes.ser"));

       
        gui.getjMenuItem3().addActionListener(e -> {
            JatekModel betoltott = betolt("mentes.ser");
            if (betoltott != null) {
                modelTomb[0] = betoltott; 
                gui.getjTextField1().setText("Játék betöltve!");
            }
        });

        
        gui.getjMenuItem1().addActionListener(e -> System.exit(0));
    }

    private static void ment(JatekModel model, String fajl) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fajl))) {
            out.writeObject(model);
            JOptionPane.showMessageDialog(null, "Mentés sikeres!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static JatekModel betolt(String fajl) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fajl))) {
            return (JatekModel) in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Betöltés sikertelen!");
            return null;
        }
    }
}
