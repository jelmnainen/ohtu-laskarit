/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author johannes
 */
public class KauppaTest {
    
    private Varasto varasto;
    private Pankki pankki;
    private Viitegeneraattori viite;
    private Kauppa kauppa;
    
    public KauppaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.varasto = mock(Varasto.class);
        this.pankki = mock(Pankki.class);
        this.viite = mock(Viitegeneraattori.class);
        this.kauppa = new Kauppa(this.varasto, this.pankki, this.viite);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of aloitaAsiointi method, of class Kauppa.
     */
    @Test
    public void tilimaksuKutsuuTilisiirtoaOikeillaParametreilla() {
        when(this.varasto.saldo(1)).thenReturn(10);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.tilimaksu("johannes", "12345");
        verify(this.pankki).tilisiirto(eq("johannes"), anyInt(), eq("12345"), anyString(), eq(5));
        
    }
    
    @Test
    public void tilimaksuKutsuuTilisiirtoaOikeillaParametreillaKunOstoskorissaKaksiTuotetta(){
        when(this.varasto.saldo(1)).thenReturn(10);
        when(this.varasto.saldo(2)).thenReturn(10);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(this.varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 2));
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.lisaaKoriin(2);
        this.kauppa.tilimaksu("johannes", "12345");
        
        verify(this.pankki).tilisiirto(eq("johannes"), anyInt(), eq("12345"), anyString(), eq(7));
    }
    
    @Test
    public void tilimaksuKutsuuTilisiirtoaOikeillaParametreillaKunOstoskorissaOnKaksiSamaaTuotetta(){
        when(this.varasto.saldo(1)).thenReturn(10);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.lisaaKoriin(1);
        this.kauppa.tilimaksu("johannes", "12345");
        
        verify(this.pankki).tilisiirto(eq("johannes"), anyInt(), eq("12345"), anyString(), eq(10));
    }
    
    @Test
    public void tilimaksuKUtsuuTilisiirtoaOikeillaParametreillaKunToistaOstoksistaEiOleTarpeeksi(){
        when(this.varasto.saldo(1)).thenReturn(10);
        when(this.varasto.saldo(2)).thenReturn(0);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(this.varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 2));
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.lisaaKoriin(2);
        this.kauppa.tilimaksu("johannes", "12345");
        
        verify(this.pankki).tilisiirto(eq("johannes"), anyInt(), eq("12345"), anyString(), eq(5));
    }
    
    @Test
    public void uudenAsioinninAloitusNollaaEdellisenOstoksen(){
        when(this.varasto.saldo(1)).thenReturn(10);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.lisaaKoriin(1);
        this.kauppa.tilimaksu("johannes", "12345");
        
        verify(this.pankki).tilisiirto(eq("johannes"), anyInt(), eq("12345"), anyString(), eq(10));
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.tilimaksu("johannes", "12345");
        
        verify(this.pankki).tilisiirto(eq("johannes"), anyInt(), eq("12345"), anyString(), eq(5));
        
    }
    
    @Test
    public void kauppaPyytaaUudenViitenumeronJokaiselleMaksutapahtumalle(){
        when(this.varasto.saldo(1)).thenReturn(10);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.lisaaKoriin(1);
        this.kauppa.tilimaksu("johannes", "12345");
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.tilimaksu("johannes", "12345");
        
        verify(this.viite, times(2)).uusi();
        
    }
    
    @Test
    public void poistaKoristaPoistaaOikeanTuotteen(){
        when(this.varasto.saldo(1)).thenReturn(10);
        Tuote t = new Tuote(1, "maito", 5);
        when(this.varasto.haeTuote(1)).thenReturn(t);
        
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.poistaKorista(1);

        verify(this.varasto).palautaVarastoon(eq(t));
    }

}
