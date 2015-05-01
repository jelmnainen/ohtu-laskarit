package ohtu.kivipaperisakset.peli;

import ohtu.kivipaperisakset.pelaajat.TekoalyHuono;
import ohtu.kivipaperisakset.pelaajat.TekoalyParannettu;
import ohtu.kivipaperisakset.pelaajat.IhmisPelaaja;

/**
 *
 * @author johannes
 */
public class KPSPeliFactory {

    public KPSPeli pelaajaVsPelaaja(String nimi1, String nimi2){
        IhmisPelaaja p1 = new IhmisPelaaja(nimi1);
        IhmisPelaaja p2 = new IhmisPelaaja(nimi2);
        return new KPSPeli(p1, p2);
    }
    
    public KPSPeli pelaajaVsPelaaja(){
        return this.pelaajaVsPelaaja("Pelaaja 1", "Pelaaja 2");
    }
    
    public KPSPeli pelaajaVsHuonoTekoaly(String nimi){
        IhmisPelaaja p1 = new IhmisPelaaja(nimi);
        TekoalyHuono p2 = new TekoalyHuono();
        return new KPSPeli(p1, p2);
    }
    
    public KPSPeli pelaajaVsHuonoTekoaly(){
        return this.pelaajaVsHuonoTekoaly("Pelaaja");
    }
    
    public KPSPeli pelaajaVsParannettuTekoaly(int muistinKoko, String nimi){
        IhmisPelaaja p1 = new IhmisPelaaja(nimi);
        TekoalyParannettu p2 = new TekoalyParannettu(muistinKoko);
        return new KPSPeli(p1, p2);
    }
    
    public KPSPeli pelaajaVsParannettuTekoaly(){
        return this.pelaajaVsParannettuTekoaly(20, "Pelaaja");
    }
}
