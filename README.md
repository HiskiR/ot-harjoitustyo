# MeTuSe
Helsingin Yliopiston ohjelmistotekniikka-kurssin harjoitustyö.
Sovelluksen avulla käyttäjät voivat seurata tulojaan ja menojaan.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

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

### Checkstyle

Checkstyle suoritetaan komentoriviltä komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Checkstyle-raporttia voi tarksatella avaamalla selaimella tiedosto _target/site/checkstyle.html_
