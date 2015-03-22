/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

/**
 *
 * @author johannes
 */
public interface GeneerinenOstoskori {

    int hinta();

    void lisaa(Tuote t);

    void poista(Tuote t);
    
}
