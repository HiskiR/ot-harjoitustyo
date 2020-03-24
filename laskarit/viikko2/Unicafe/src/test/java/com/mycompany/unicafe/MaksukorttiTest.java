package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(5);
        assertEquals("saldo: 0.15", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinJosTarpeeksiRahaa() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosRahatRiittavat() {
        assertEquals(true, kortti.otaRahaa(10));
    }
    
    @Test
    public void otaRahaaPalauttaaFalseJosRahatEivatRiita() {
        assertEquals(false, kortti.otaRahaa(20));
    }
    
    @Test
    public void saldoPalauttaaOikein() {
        assertEquals(10, kortti.saldo());
    }
     
}
