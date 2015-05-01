package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.peli.KPSPeli;
import ohtu.kivipaperisakset.peli.KPSPeliFactory;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        KPSPeliFactory pelifactory = new KPSPeliFactory();
        KPSPeli peli;
        
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            
            
            if (vastaus.endsWith("a")) {
                peli = pelifactory.pelaajaVsPelaaja();
            } else if (vastaus.endsWith("b")) {
                peli = pelifactory.pelaajaVsHuonoTekoaly();
            } else if (vastaus.endsWith("c")) {
                peli = pelifactory.pelaajaVsParannettuTekoaly();
            } else {
                break;
            }
            
            peli.pelaa();

        }

    }
}
