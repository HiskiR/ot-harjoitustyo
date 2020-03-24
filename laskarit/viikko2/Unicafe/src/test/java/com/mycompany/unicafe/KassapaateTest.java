package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void kassassaRahaaAluksi() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void maukkaitaMyyty() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullisiaMyyty() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void josMaukkaanOstoOnnistuuKassanRahatKasvaaOikein() {
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void josMaukkaanOstoOnnistuuVaihtorahaOnOikein() {
        assertEquals(100, kassa.syoMaukkaasti(500));
    }

    @Test
    public void josMaukkaanOstoOnnistuuMyytyjenMaukkaudenMaaraKasvaa() {
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void josMaukkaanOstoEiOnnistuKaikkiRahatPalautetaan() {
        assertEquals(300, kassa.syoMaukkaasti(300));
    }

    @Test
    public void josMaukkaanOstoEiOnnistuMyytyjenMaukkaidenMaaraEiMuutu() {
        kassa.syoMaukkaasti(300);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void josMaukkaanKorttiostoOnnistuuSummaVeloitetaanJaPalautetaanTrue() {
        kortti = new Maksukortti(400);
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(0, kortti.saldo());
    }

    @Test
    public void josMaukkaanKorttiostoOnnistuuMyytyjenMaukkaidenMaaraKasvaa() {
        kortti = new Maksukortti(400);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void josMaukkaanKorttiostoEiOnnistuMyytyjenMaukkaidenMaaraEiMuutu() {
        kortti = new Maksukortti(300);
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void josMaukkaanKorttiostoEiOnnistuKortinSaldoEiMuutuJaPalautetaanFalse() {
        kortti = new Maksukortti(300);
        assertTrue(!kassa.syoMaukkaasti(kortti));
        assertEquals(300, kortti.saldo());
    }

    @Test
    public void josMaukkaanKorttiostoOnnistuuKassanRahamaaraEiKasva() {
        kortti = new Maksukortti(400);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void josEdullisenOstoOnnistuuKassanRahatKasvaaOikein() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void josEdullisenOstoOnnistuuVaihtorahaOnOikein() {
        assertEquals(100, kassa.syoEdullisesti(340));
    }

    @Test
    public void josEdullisenOstoOnnistuuMyytyjenEdullistenMaaraKasvaa() {
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void josEdullisenOstoEiOnnistuKaikkiRahatPalautetaan() {
        assertEquals(100, kassa.syoEdullisesti(100));
    }

    @Test
    public void josEdullisenOstoEiOnnistuMyytyjeEdullistenMaaraEiMuutu() {
        kassa.syoEdullisesti(100);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void josEdullisenKorttiostoOnnistuuSummaVeloitetaanJaPalautetaanTrue() {
        kortti = new Maksukortti(240);
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(0, kortti.saldo());
    }

    @Test
    public void josEdullisenKorttiostoOnnistuuMyytyjenEdullistenMaaraKasvaa() {
        kortti = new Maksukortti(240);
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void josEdullisenKorttiostoEiOnnistuMyytyjenEdullistenMaaraEiMuutu() {
        kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void josEdullisenKorttiostoEiOnnistuKortinSaldoEiMuutuJaPalautetaanFalse() {
        kortti = new Maksukortti(100);
        assertTrue(!kassa.syoEdullisesti(kortti));
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void josEdullisenKorttiostoOnnistuuKassanRahamaaraEiKasva() {
        kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void korttiaLadattaessaKassassanRahamaaraKasvaaOikein() {
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiaLadattaessaKortinSaldoMuuttuuOikein() {
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void korttiaLadattaessaNegatiivisellaMaarallaKassassanRahamaaraEiKasva() {
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiaLadattaessaNegatiivisellaMaarallaKortinSaldoEiMuutu() {
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(0, kortti.saldo());
    }

}
