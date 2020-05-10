# MeTuSe
Helsingin Yliopiston ohjelmistotekniikka-kurssin harjoitustyö.
Sovelluksen avulla käyttäjät voivat seurata tulojaan ja menojaan.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Kayttöohje](https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Työaikakirjanpito](https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Releaset
[Viikko 5](https://github.com/HiskiR/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/HiskiR/ot-harjoitustyo/releases/tag/Viikko6)

[Loppupalautus](https://github.com/HiskiR/ot-harjoitustyo/releases/tag/viikko7)
## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

### Ohjelman suorittaminen
Ohjelma voidaan suorittaa terminaalissa komennolla 

```
mvn compile exec:java -Dexec.mainClass=metuse.ui.Main
```

### Suoritettavan jarin generointi
Komento

```
mvn package
```

luo hakemistoon _target_ suoritettavan jar-tiedoston _MeTuSe-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc saadaan generoitua komennolla

```
mvn javadoc:javadoc
```
jonka jälkeen sitä voi tarkastella avaamalla tiedoston _target/site/apidocs/index.html_

### Checkstyle

Checkstyle suoritetaan komentoriviltä komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Checkstyle-raporttia voi tarksatella avaamalla selaimella tiedosto _target/site/checkstyle.html_
