# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjien on mahdollista pitää kirjaa tuloistaan ja menoistaan. Sovelluksen käyttö vaatii rekisteröityneen käyttäjän, jolla on omat tulonsa ja menonsa.

## Käyttäjät

Alkuvaiheessa sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä. Myöhemmin sovellukseen saatetaan lisätä ylläpitäjä, jolla on enemmän oikeuksia.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

- [x] käyttäjä voi luoda käyttäjätunnuksen
  - käyttäjätunnuksen tulee olla uniikki ja pituudeltaan vähintään 3 merkkiä
- [x] käyttäjä voi kirjautua
  - kirjautuminen onnistuu syötettäessä kirjautumislomakkeeseen olemassaoleva käyttäjätunnus
  - jos käyttäjää ei olemassa, käyttäjä saa tästä ilmoituksen

### Kirjautumisen jälkeen

- [ ] käyttäjä näkee omat menonsa ja tulonsa
- [x] käyttäjä voi luoda uuden menon
  - menolle annetaan nimi ja rahamäärä
  - luotu meno näkyy ainoastaan sen luoneelle käyttäjälle (ei näy vielä kenellekään)
- [x] käyttäjä voi luoda uuden tulon
  - tulolle annetaan nimi ja rahamäärä
  - luotu tulo näkyy ainoastaan sen luoneelle käyttäjälle (ei näy vielä kenellekään)
- [ ] käyttäjä voi muokata tulojen ja menojen tietoja
- [x] käyttäjä voi kirjautua ulos

## Jatkokehitysideoita

Perustoiminnallisuuksien jälkeen ohjelmaan lisätään mm. seuraavia toiminnallisuuksia

- menojen ja tulojen tarkastelu haluamallaan aikavälillä
- graafinen esitys tuloille ja menoille
- kuukausikohtainen tieto onko kuukaudessa ollut rahamäärällisesti enemmän tuloja vai menoja
- ryhmät, joiden käyttäjät voivat yhdistää menonsa ja tulonsa
- käyttäjille salasanat, joita vaaditaan kirjautuessa
- käyttäjien ja niihin liittyvien tulojen ja menojen poisto
- menojen jako eri kategorioihin, kuten ruokaostokset
- säännölliset tulot ja menot jotka lisätään automaattisesti niille määriteltynä päivänä
