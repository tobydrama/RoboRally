# Robo Rally [![Build Status](https://travis-ci.com/inf112-v20/Fiasko.svg?branch=master)](https://travis-ci.com/inf112-v20/Fiasko) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/51d37dc99db44758944198a59f2d2a4b)](https://www.codacy.com/gh/inf112-v20/Fiasko?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=inf112-v20/Fiasko&amp;utm_campaign=Badge_Grade)
Dette prosjektet har som mål å lage en digital kopi av brettspillet Robo Rally.  Foreløbig er målet å implementere all 
nødvendig funksjonalitet for å kunne spille et "spill" Robo Rally over lan med opp til 8 spillere. Om tiden strekker til,
vil vi gå over til en fase der målet blir å implementere ting som er gøy, men ikke nødvendig.

Alle regler er hentet fra 2005 utgaven av spillguiden fra Wizards of the Coast, Inc.

## Spillstatus
Spillet er i hovedsak ferdig. Det er en del ekstra funksjoner og innhold som kan legges til, men all nødvendig 
funksjonalitet er implementert og fungerende i en akseptabel grad. Det kan fortsatt finnes bugs i koden, men spillet er 
trolig stabilt.

## Javadoc
Javadoc for hele prosjektet kan finnes [her](https://inf112-v20.github.io/Fiasko/javadoc/).

## Knapper og mus
Her er en liten oversikt over knapper og musefunksjonalitet. 
For mer informasjon gå til [wikien](https://github.com/inf112-v20/Fiasko/wiki/Brukergrensesnitt).
### Brettet
-   Q: Tilbakestiller kamera og kamerarotasjon på brettvisningsskjermen
-   R: Roterer kameraet på brettvisningsskjermen
-   TAB: Bytter mellom kortvelging og brettvisning når en holder på med å velge kort
-   Rullehjulet vil forstørre og forminske spillbrettet på brettvisningsskjermen
-   Spillbrettet kan flyttes ved å holde inne venstre musetast og bevege musen i en retning på brettvisningsskjermen
### Lobby
-   HOME: Denne knappen lar deg velge et brett spesifikt laget for debugging

-   T: Denne knappen lar deg starte spillet i en modus spesialisert for manuell testing. 
     Denne modusen støtter bare en spiller.

## Bygging og kjøring
Se relevant side på [wikien](https://github.com/inf112-v20/Fiasko/wiki/Bygging-og-kj%C3%B8ring).