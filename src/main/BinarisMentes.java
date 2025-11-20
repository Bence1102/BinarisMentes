
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BinarisMentes {
    
    private Karakter karakter;
    private final String fn="karakter_1.bin";
    
    public static void main(String[] args){
        BinarisMentes prg = new BinarisMentes();
        prg.letrehozas();
        prg.mentes();
        prg.bettoltes();
        
    }

    private void letrehozas() {
        karakter = new Karakter("Varokh","Lézercsáp","Drakorian", 1);
        karakter.felvesz(new Targy("Lézerkard"));
    }
    
    public void mentes(){
        try (FileOutputStream fajlKi = new FileOutputStream(fn);
            ObjectOutputStream objKi = new ObjectOutputStream(fajlKi);){
            objKi.writeObject(karakter);
            
            //ha AutoCloseable,akkor nem kel explicit close()
            //objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinarisMentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BinarisMentes.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            /*mindig lefut*/
            System.out.println("mentés utén:");
            System.out.println(karakter);
        }
    }
    
    
    public void bettoltes(){
        try (FileInputStream fajlBe = new FileInputStream(fn);
            ObjectInputStream objBe = new ObjectInputStream(fajlBe);){
            karakter = (Karakter) objBe.readObject();
            System.out.println(karakter);
            
            
            System.out.println("betöltés után");
            
            //ha AutoCloseable,akkor nem kel explicit close()
            //objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinarisMentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BinarisMentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BinarisMentes.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            /*mindig lefut*/
            System.out.println("mentés utén:");
            System.out.println(karakter);
        }
    }
}
