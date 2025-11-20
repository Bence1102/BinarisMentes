
package main;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class Karakter implements Serializable {
        private static final long serialVersionUID = 3L;
        private transient int pont;
        
        
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
        setId();
        this.pont=78;
    }

    public String getId(){
        return id.toString();
    }
    
    public void felvesz(Targy targy) {
        felszerelesek.add(targy);
    }

    @Override
    public String toString() {
        String f= "\nFelszerelés:\n";
        for  (Targy targy : felszerelesek) {
            f+=targy.getLeiras() +"\n";
        }
        String str = "Karakter:" + id.toString().substring(0, 8) + "," +
                     "\nnev:" + nev + 
                     "\nkard:" + kard + 
                     "\nszint:" + szint + 
                     "\nfelszerelesek:" + felszerelesek + 
                     "\nfaj:" + faj + f +
                     "\npont:" + pont +
                     "\nID:" + id;
        return str;
    }

    void setId() {
        this.id=UUID.randomUUID();
    } 
}
    

