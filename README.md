# rm-skills-9 - Template für ICT Regionalmeisterschaften 2024

Disclaimer: 
Da die Regionalmeisterschaften auf einer Windows Umgebung absolviert werden müssten, ist dieses Template für Windows konzipiert. 
Es sollte sich jedoch ziemlich einfach für Unix Umgebungen anpassen lassen.

## Anleitung für den Start der Applikation

```shell
# Datenbank initialisieren (es wird angenomment, dass der MySQL-Service läuft
./devops/scripts/init_db.bat
# Backend starten
./gradlew :backend:bootRun
# Frontend starten (falls vorhanden)
./gradlew :frontend:serveFrontend
```

Das Backend ist erreichbar auf `localhost:8080`.
Das Frontend wird geserved auf `localhost:4200`.

## Datenbank

### Setup

#### Lokale MySQL Installation (sollte in der Prüfungsumgebung vorhanden sein)

Angenommen es existiert eine lokale MySQL Installation und der MySQL-Service läuft (kann im Task-Manager unter Services geprüft/gestartet werden), 
kann die Datenbank durch Ausführen des Skripts `init_db.bat` initialisiert werden:
```shell
./devops/scripts/init_db.bat
```

#### Dockerisierte MySQL Datenbank

Über die Run-Konfiguration `start-docker-db` kann ein Docker-Container mit einer MySQL Datenbank gestartet werden.

### Daten-Handhabung

Das Template beinhaltet die Library `flyway` (https://flywaydb.org/). Damit kann die Datenbank über Gradle-Tasks mit den in `backend/db-model/src/main/resources/db/migration` abgelegten SQL-Skripts initialisiert werden.
Dazu folgenden Befehl ausführen:
```shell
./gradlew flywayMigrate
```
Über den folgenden Befehl kann die Datenbank wieder zurückgesetzt werden:
```shell
./gradlew flywayClean
```

## Backend

Das Template beinhaltet ein minimales SpringBoot-Backend (https://spring.io/projects/spring-boot).
Dieses kann über die Run-Konfig "BackendApplication" oder über
```shell
./gradlew :backend:bootRun
```
gestartet werden.

Das Backend verwendet die Library `jOOQ` (https://www.jooq.org/), um Java Code für den Zugriff auf die Datenbank zu generieren.
Der Code sollte automatisch beim build des Backends generiert werden,
wie folgt kann dies auch manuell gemacht werden:
```shell
./gradlew :backend:db-model:generateJooq
```

## Frontend

Das Template beinhaltet ein minimales Angular-Frontend (https://angular.io/).
Für die Entwicklung daran empfiehlt es sich NodeJS (v21.6.2) und npm (v10.2.4) zu installieren.
Damit die Angular-App auch ohne vorgängig installierten NodeJS laufen gelassen werden kann,
gibt es einen Gradle-Task, welcher NodeJS und npm direkt herunterlädt:
```shell
./gradlew :frontend:serveFrontend
```
