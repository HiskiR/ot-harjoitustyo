# Arkkitehtuurikuvaus

### Rakenne

Ohjelman rakenne on kolmikerroksinen. Kerrokser ovat ui, domain ja dao:

<img src="https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Rakenne.png">

metuse.ui pakkauksessa on JavaFX:llä tehty käyttöliittymä, metuse.domain pakkaus sisältää sovelluslogiikan ja metuse.dao pakkauksessa on tietokannan käsittelystä vastaava koodi.

### Käyttölittymä

Käyttöliittymässä on viisi erillistä näkymää:

- Käyttäjän luominen
- Sisäänkirjautuminen
- Päänäkymä, joka sisältää mm. tulot ja menot
- Menon luominen
- Tulon luominen

Nämä ovat toteutettu käyttäen erillisä Scene-olioita. Näistä yksi on kerrallaan sijoitettuna sovelluksen stageen, jolloin kyseinen näkymä näkyy käyttäjälle.
Käyttöliittymästä vastaava koodi sijaitsee luokassa metuse.ui.MetuseUi.

### Sovelluslogiikka

Ohjelman osien suhdettu kuvaa seuraava pakkauskaavio:

<img src="https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokka:pakkauskaavio.png">


### Toiminnallisuuksia
#### Kirjautuminen

Kun käyttäjä on kirjoittanut käyttäjätunnuksensa ja painanut login-painiketta kirjautumisnäkymässä sovelluksen sisäiset toiminnot etenevät seuraavasti:

<img src="https://github.com/HiskiR/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/login_sequence_diagram.png">

Login-painikkeen tepahtumankäsittelijä kutsuu metuseServicen metodia login ja antaa sille parametriksi käyttäjän syöttämän käyttäjätunnuksen. MetuseService vahvistaa userDao:n avulla, etää käyttäjätunnus on olemassa. Jos käyttäjä on olemassa käyttöliittymä näyttää käyttäjälle mainScenen.
