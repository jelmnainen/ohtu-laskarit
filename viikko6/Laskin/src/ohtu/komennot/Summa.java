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
public class Summa extends Komento {

    public Summa(JTextField syotekentta, JTextField tuloskentta) {
        super(syotekentta, tuloskentta);
    }

    @Override
    protected int laske(int wanhaArvo, int uusiArvo) {
        return wanhaArvo + uusiArvo;
    }

    
}
