
package main;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class Karakter implements Serializable {
        private static final long serialVersionUID = 2L;
        
        
        
        private UUID id;
        private String nev;
        public String kard;
        private int szint;
        private List<Targy> felszerelesek;
        private String faj;

    public Karakter(String nev,String kard,String faj ,int szint) {
        this.id= UUID.randomUUID();
        this.nev=nev;
        this.kard = kard;
        this.szint = szint;
        this.faj = faj;
        felszerelesek = new ArrayList<>();
        felszerelesek.add(new Targy("kard"));
        felszerelesek.add(new Targy("1-es szintű"));
    }

    public UUID getId(){
        return id;
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
        String str = "Karakter:" + 
                     "\n ID:" + id +
                     "\n nev:" + nev + 
                     "\n kard=" + kard + 
                     "\n szint=" + szint + 
                     "\n felszerelesek=" + felszerelesek + 
                     "\n faj=" + faj + f;
        return str;
    }

    

    
}
    

