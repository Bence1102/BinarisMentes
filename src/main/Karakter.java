
package main;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Karakter implements Serializable {
        private static final long serialVersionUID = -6849794470754667710L;
    
        private String nev;
        public String kard;
        private int szint;
        private List<Targy> felszerelesek;
        private String faj;

    public Karakter(String nev,String kard,String faj ,int szint) {
        this.nev=nev;
        this.kard = kard;
        this.szint = szint;
        this.faj = faj;
        felszerelesek = new ArrayList<>();
        felszerelesek.add(new Targy("kard"));
        felszerelesek.add(new Targy("1-es szintű"));
    }

    public void felvesz(Targy targy) {
        felszerelesek.add(targy);
    }

    @Override
    public String toString() {
        String f= "";
        for  (Targy targy : felszerelesek) {
            f+=targy.getLeiras() +"\n";
        }
        
        return "Karakter{" + "nev=" + nev + ", kard=" + kard + ", szint=" + szint + ", felszerelesek=" + felszerelesek + ", faj=" + faj + f +'}';
    }

    

    
}
    

