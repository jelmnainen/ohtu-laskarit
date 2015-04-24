/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komennot;

import javax.swing.JTextField;

/**
 *
 * @author johannes
 */
public abstract class Komento {
    
    private JTextField syotekentta;
    private final JTextField tuloskentta;
    private int wanhaArvo;
    public Komento(JTextField tuloskentta, JTextField syotekentta){
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        
    }
    
    public void suorita(){
        this.wanhaArvo = this.haeKentanArvo(this.tuloskentta);
        int syote = this.haeKentanArvo(this.syotekentta);
        
        System.out.println("Wnha: " + wanhaArvo + "\n");
        System.out.println("Syöte :" + syote);
        
        int arvo = this.laske(wanhaArvo, syote);
        
        this.paivita(arvo);
        
    }
    
    public void peru() {
        this.paivita(this.wanhaArvo);
    }
    
    public int haeKentanArvo(JTextField kentta){
        int res = 0;
        try{
            res = Integer.parseInt(kentta.getText());
        } catch (Exception e){
            
        }
        return res;
    }

    protected abstract int laske(int wanhaArvo, int uusiArvo);

    
    private void paivita(int arvo) {
        this.tuloskentta.setText("" + arvo);
        this.syotekentta.setText("");
        
        if(arvo == 0){
            
        }
    }

    
}
