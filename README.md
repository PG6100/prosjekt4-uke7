prosjekt4-uke7, Message Driven Beans
==============

I denne øvingen skal vi bygge en enkel applikasjon som ligner på det vi har gjort på forrige øving. Klienten sender melding til en destinasjon (``jms/Queue``) på serverside og dere skal lage en Message Driven Bean som skal kjøres ved mottak av meldingen. 

* Import prosjektet. Prosjektet må opprettes med JDK 7. Start Intellij, velg import project, og naviger til ``pom.xml`` (evt ``build.graddle``). I neste steg, må du velge "Import maven projects automatically".

* Start derby databasen:


    cd $GLASSFISH_HOME/javadb/bin
    ./NetworkServerControl start

* Start glassfish4:


    cd $GLASSFISH_HOME/bin
    ./asadmin start-domain
    
*  Implementer koden. Sender kan være basert på forrige forelesningens JMS sender. Sørg for at MDB skriver ut noe ved meldingsmottak (System.out.println()) slik at det er mulig å verifisere at den er kjørt. Her kan du gjenbruke samme destinasjon som på forrige forelesning. Hvis du ikke har destinasjon, så må du opprette i admin console.

* Bygg prosjektet (``mvn clean package``, ``gradle clean jar``).

* Deploy MDB til glassfish.``$GLASSFISH_HOME/bin/asadmin deploy --force=true target/prosjekt4-uke7-0.1.jar``. Må kjøres fra prosjektets mappa.

* Kjør din meldingssender, ``mvn exec:java -Dexec.mainClass="no.nith.pg6100.ClientSender"``, gradle: ``gradle run -DmainClassName="no.nith.pg6100.ClientSender"``


Gjerne eksperimenter med ``@PostConstruct`` og ``@PreDestroy``. Ting som printes i ``System.out`` blir skrevet i ``$GLASSFISH_HOME/glassfish/domains/domain1/logs/server.log``

Ekstra tillegsoppgave: lag en EJB som blir kallt fra MDB. Kast exception fra EJB-en for å så sjekke om transaksjonen ble vellykket.