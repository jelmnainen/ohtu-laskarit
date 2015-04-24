
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin täytyy olla vähintään 0!");
        }
        this.joukko = alustaJoukko(kapasiteetti);
        
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon täytyy olla vähintään 0!");
        }
        this.kasvatuskoko = kasvatuskoko;

    }

    private int[] alustaJoukko(int kapasiteetti) {
        int[] alustettava = new int[kapasiteetti];
        for (int i = 0; i < alustettava.length; i++) {
            alustettava[i] = 0;
        }
        alkioidenLkm = 0;
        return alustettava;
        
    }

    public boolean lisaa(int luku) {
        if (!alkioOnJoukossa(luku)) {
            lisaaAlkioTaulukkoon(luku);
        }
        return false;
    }

    private boolean lisaaAlkioTaulukkoon(int luku) {
        joukko[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % joukko.length == 0) {
            int[] vanhaTaulukko = joukko;
            kopioiTaulukko(joukko, vanhaTaulukko);
            joukko = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(vanhaTaulukko, joukko);
        }
        return true;
    }

    public boolean alkioOnJoukossa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int apu;
        int luvunPaikka = etsiLuvunPaikka(luku);
        if (luvunPaikka != -1) {
            joukko[luvunPaikka] = 0;
            siirraAlkioitaVasemmalle(luvunPaikka);
            return true;
        }
        return false;
    }

    private int etsiLuvunPaikka(int luku) {
        int luvunPaikka = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return i; 
            }
        }
        return luvunPaikka;
    }

    private void siirraAlkioitaVasemmalle(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = joukko[j];
            joukko[j] = joukko[j + 1];
            joukko[j + 1] = apu;
        }
        alkioidenLkm--;
    }
    
    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        String tulos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tulos += joukko[i];
            tulos += ", ";
        }
        tulos += joukko[alkioidenLkm - 1];
        tulos += "}";
        return tulos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        lisaaTaulukkoJoukkoon(aTaulu, x);
        lisaaTaulukkoJoukkoon(bTaulu, x);
        return x;
    }

    private static void lisaaTaulukkoJoukkoon(int[] taulu, IntJoukko x) {
        for (int i = 0; i < taulu.length; i++) {
            x.lisaa(taulu[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
 
        return z;
    }
        
}