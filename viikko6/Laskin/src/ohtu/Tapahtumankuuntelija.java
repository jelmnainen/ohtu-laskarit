package ohtu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;
import ohtu.komennot.*;
 
public class Tapahtumankuuntelija implements ActionListener {
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JButton undo;
    private JTextField tuloskentta;
    private Sovelluslogiikka sovellus;
    private Map<JButton, Komento> komennot;
    private Komento edellinen;
    
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.undo = undo;
        this.nollaa = nollaa;
        this.tuloskentta = tuloskentta;
        this.komennot = new HashMap();
        komennot.put(plus, new Summa(tuloskentta, syotekentta));
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta));

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Komento komento = komennot.get(ae.getSource());
        if(komento != null){
            komento.suorita();
            this.edellinen = komento;
            this.nollaa.enable();
        } else {
            this.edellinen.peru();
            this.edellinen = null;
            this.nollaa.disable();
        }
        
        if ( this.tuloskentta.getText().equals("0")) {
            nollaa.setEnabled(false);
        } else {
            nollaa.setEnabled(true);
        }
        undo.setEnabled(true);
    }
    
//        @Override
//    public void actionPerformed(ActionEvent ae) {
//        int arvo = 0;
// 
//        try {
//            arvo = Integer.parseInt(syotekentta.getText());
//        } catch (Exception e) {
//        }
// 
//        if (ae.getSource() == plus) {
//            sovellus.plus(arvo);
//        } else if (ae.getSource() == miinus) {
//            sovellus.miinus(arvo);
//        } else if (ae.getSource() == nollaa) {
//            sovellus.nollaa();
//        } else {
//            System.out.println("undo pressed");
//        }
//        
//        int laskunTulos = sovellus.tulos();
//         
//        syotekentta.setText("");
//        tuloskentta.setText("" + laskunTulos);
//        if ( laskunTulos==0) {
//            nollaa.setEnabled(false);
//        } else {
//            nollaa.setEnabled(true);
//        }
//        undo.setEnabled(true);
//    }
 
}