
package ohtu.kivipaperisakset.pelaajat;

import java.util.Scanner;

public class IhmisPelaaja implements Pelaaja {

    private static final Scanner scanner = new Scanner(System.in);
    private String name;
    
    public IhmisPelaaja(String name){
        this.name = name;
    }
    
    @Override
    public String annaSiirto() {
        System.out.print(this.getName() + " pelaajan siirto: ");
        return scanner.nextLine();
    }
    
    @Override
    public void asetaSiirto(String siirto) {
        //do nothing, bwahaha
    }

    @Override
    public String getName() {
        return this.name;
    }
    
}
