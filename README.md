# OAuth-JWT-Testing-Library

OAuth-JWT-Testing-Library è una libreria di test che fornisce strumenti per testare flussi OAuth 2.0 e la gestione di token JWT in applicazioni Java. Include test automatizzati per login, scadenza token, revoca token e accesso condizionale basato sui ruoli.

## Requisiti
- Java 11+
- Maven

## Dipendenze
Le principali dipendenze utilizzate in questo progetto includono:
- **JUnit 5**: per i test unitari.
- **Rest Assured**: per inviare richieste HTTP e automatizzare i test delle API.
- **JWT (jjwt)**: per la gestione dei token JWT.

## Esecuzione dei Test
1. Clona il repository:
   ```bash
   git clone https://github.com/nerlin/OAuth-JWT-Testing-Library.git

## Naviga nella cartella del progetto:
cd OAuth-JWT-Testing-Library

## Esegui i test:
mvn test
