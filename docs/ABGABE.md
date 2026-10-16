# Abgabe und Bewertung

Abgegeben wird ein **gemeinsamer Projektstand pro Moodle-Gruppe**.
Welche Aufgaben zu welchem Termin fällig sind, geben die Lehrenden im Kurs bekannt.

## Vor der Abgabe

- [ ] Die fälligen Aufgaben sind auf `main` zusammengeführt.
- [ ] Offene Review-Rückmeldungen sind geklärt.
- [ ] `mvn --batch-mode clean verify` läuft mit Java 21 erfolgreich.
- [ ] Die geforderten neuen Tests sind vorhanden und prüfen die Erwartungen.
- [ ] Nach dem CI-Unterricht läuft der GitHub-Workflow für den Abgabe-Commit erfolgreich.
- [ ] [ABGABE.md](../ABGABE.md) enthält Gruppenmitglieder, Aufgabenstatus und Nachweise.
- [ ] Alle Gruppenmitglieder können die Lösung und die Tests erklären.

## 1. Abgabevorlage ausfüllen

Füllt die Datei [ABGABE.md](../ABGABE.md) aus und nehmt sie vor dem Release in
einen Commit auf. Verlinkt die zugehörigen Issues und Pull Requests und nennt
offene Probleme ehrlich.

Die spätere Commit-ID und der Link auf den neuen Release werden **nicht in diese
Datei geschrieben**. Sie kommen nach dem Erstellen des Releases in die Moodle-Abgabe.
So müsst ihr den Abgabestand nicht nachträglich verändern.

## 2. GitHub-Release erstellen

1. Prüft, dass der richtige Stand auf `main` liegt.
2. Erstellt über **Releases** einen neuen Release für diesen Stand.
3. Titel: beispielsweise `Release Gruppe A`, angepasst an eure Moodle-Gruppe.
4. Tag: beispielsweise `v1.0.0`. Für einen neuen Abgabestand verwendet ihr einen
   neuen Tag, zum Beispiel `v1.1.0`.
5. Nennt in der Beschreibung die Gruppe, die erledigten Aufgaben und offene Probleme.
6. Veröffentlicht den Release vor der angekündigten Abgabefrist.

Verändert einen abgegebenen Tag nicht nachträglich. Für eine Korrektur erstellt
ihr einen neuen Release und reicht ihn entsprechend den Kursregeln erneut ein.
Gemäß den Folien ist der letzte Release vor der jeweiligen Frist maßgeblich;
verlinkt genau diesen Release in Moodle.

## 3. In Moodle einreichen

Eine Person reicht für die Gruppe folgende Angaben im vorgesehenen Abgabebereich ein:

```text
Gruppe:
Alle Gruppenmitglieder:
Repository-Link:
Release-Link:
Release-Tag:
Vollständige Commit-ID des Releases:
Link zum erfolgreichen CI-Lauf, sobald CI Teil der Abgabe ist:
Offene Probleme oder Abweichungen:
```

Die vollständige Commit-ID erhaltet ihr auf GitHub beim Commit des Releases oder
lokal nach `git fetch --tags`, beispielsweise mit:

```sh
git rev-parse 'v1.0.0^{commit}'
```

Ersetzt `v1.0.0` durch euren tatsächlichen Abgabe-Tag. Alle Lehrenden müssen auf
das private Repository zugreifen können. Ein späterer Commit auf `main` gehört
nicht automatisch zur abgegebenen Version.

## Was wird betrachtet?

- **Funktionalität:** Sind die fälligen Aufgaben korrekt umgesetzt?
- **Tests:** Prüfen sie nachvollziehbare Erwartungen, Fehlerfälle und Randbereiche?
- **Code und Zusammenarbeit:** Sind Änderungen verständlich und Reviews nachvollziehbar?
- **Erklärung:** Könnt ihr den eigenen Beitrag, die Lösung und eure Tests erläutern?

Ein grüner Testlauf ist ein wichtiger Nachweis. Die Bewertung berücksichtigt
auch die Qualität der Tests und des Codes. Die Zahl der Commits allein ist kein
Bewertungsmaßstab für die Beteiligung beim Pair Programming.

Die Gewichtung der gesamten LV lautet:

| Bestandteil | Anteil an der Gesamtnote |
| --- | ---: |
| Abgaben | 20 % |
| Abgabegespräche | 15 % |
| Übungstag | 15 % |
| Klausur | 50 % |

Die ersten drei Bestandteile bilden zusammen die **50 % Projektergebnis**.
Klausur und Projektergebnis müssen jeweils positiv abgeschlossen werden.
Eine detaillierte Punkteverteilung für einzelne Aufgaben geben die Lehrenden
vor der Bearbeitung bekannt.
