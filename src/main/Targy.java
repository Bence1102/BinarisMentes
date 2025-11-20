
package main;

import java.io.Serializable;

public class Targy implements Serializable {
    private String leiras;
    
    public Targy(String leiras){
        this.leiras=leiras;
    }

    public String getLeiras() {
        return leiras;
    }
    
     @Override
    public String toString() {
        return leiras; 
    }
}
