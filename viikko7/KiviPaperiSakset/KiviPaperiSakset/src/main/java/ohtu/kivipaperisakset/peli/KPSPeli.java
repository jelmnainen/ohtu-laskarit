package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.pelaajat.Pelaaja;
import java.util.Scanner;

public class KPSPeli {

    private static final Scanner scanner = new Scanner(System.in);
    private Pelaaja p1;
    private Pelaaja p2;
    
    public KPSPeli(Pelaaja p1, Pelaaja p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        
        String ekanSiirto = p1.annaSiirto();
        String tokanSiirto = p2.annaSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = p1.annaSiirto();
            tokanSiirto = p2.annaSiirto();
            
            p1.asetaSiirto(tokanSiirto);
            p2.asetaSiirto(ekanSiirto);

        }

        this.lopetaPeli(tuomari);
    }

    private void lopetaPeli(Tuomari tuomari) {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
