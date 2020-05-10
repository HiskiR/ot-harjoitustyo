# Testausdokumentti

Ohjelmaa on testattu automatisoiduilla JUnit-testeillä sekä manuaalisilla testeillä.

## JUnit-testit

### sovelluslogiikka

Testit painottuvat sovelluslogiikkaa testaaviin integraatiotesteihin, MetuseServiceExpenseTest, MetuseServiceIncomeTest ja  MetuseServiceUserTest.
Näiden testien tapaukset simuloivat sovelluslogiikan, eli MetuseServicen suorittamia toiminnallisuuksia. Integraatiotesteissä tiedot tallennetaan käyttämättä tietokantaa FakeDaoilla, jotka toteuttaat DAO-luokkien rajapinnat.

### DAO-luokat

Kaikki DAO-luokat on testattu luomalla testien alussa testitietokanta joihin tallennetut tiedot poistetaan testien päätteeksi.

### Testikattavuus

Kun käyttöliittymää ei huomioida sovelluksen rivikattavuus on 95% ja haarautumakattavuus on 84%

<img src="https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Testauskattavuus.png" width="800">

## Manuaaliset testit

Järjestelmätestaus on tehty manuaalisesti.

### Järjestelmätestit

### Asennus ja kofigurointi

Sovellusta on testattu sekä OSX- että Linux-ympäsirtössä käyttöohjeiden mukaisesti sekä niin että tietokanta on ollut jo luotuna, että niin että ohjelma on luonut sen käynnistyessään.

### Toiminnallisuudet

Kaikki määrittelydokumentissa ilmioitetut toiminnallisuudet on käyty läpi antaen ohjelmalle myös vääriä syötteitä.



