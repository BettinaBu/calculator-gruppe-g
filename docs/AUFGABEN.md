# Aufgaben

Bearbeitet jeweils die im Unterricht freigegebenen Aufgaben. Die Mindestzahlen
unten beziehen sich auf **neue Tests für die jeweilige Aufgabe**. Vorhandene Tests
sollen weiterhin erfolgreich laufen.

Ein positiver Test prüft eine gültige Eingabe, ein negativer Test eine erwartete
Fehlerreaktion. „Positiv“ und „negativ“ beziehen sich dabei nicht auf das Vorzeichen
der verwendeten Zahlen.

Prüft normale Eingaben und gezielt die Randbereiche: etwa `0`, einen leeren Stapel
oder eine fehlende Zahl. Schreibt vor dem Test auf, welches Ergebnis ihr erwartet.

## Aufgabe 1: Modulo

Erweitert den Calculator um die Restwert-Operation `%`.

### Erwartetes Verhalten

- Neue Calculator-Operation: `mod`; XML-Schreibweise: `<operation value="%" />`.
- Zuerst `7`, dann `3` auf den Stapel legen: Ergebnis `1`.
- Zuerst `8`, dann `4`: Ergebnis `0`.
- Zuerst `-7`, dann `3`: Ergebnis `-1`, entsprechend dem Java-Restwertoperator.
- Ein Divisor von `0` führt zu einer `CalculatorException`.
- Wie bei den vorhandenen Rechenoperationen liefert die Methode das Ergebnis zurück.

Die Operation soll mit den `double`-Werten des Calculators arbeiten. Überlegt,
welche Eingabe ihr ausdrücklich prüfen müsst, damit der vereinbarte Fehlerfall eintritt.

### Aufteilung

| Bereich | Umsetzung | Review |
| --- | --- | --- |
| Calculator-Schnittstelle und Rechenlogik | Arbeitsteam 1 | Arbeitsteam 2 |
| Tests für die Rechenlogik | Arbeitsteam 2 | Arbeitsteam 1 |
| Parser: `%` erkennen | Arbeitsteam 2 | Arbeitsteam 1 |
| Tests für den Parser | Arbeitsteam 1 | Arbeitsteam 2 |

Die Arbeitsteams gehören zu derselben Moodle-Gruppe. Ihre Aufteilung und der
Rollenwechsel sind in [Zusammenarbeit](ZUSAMMENARBEIT.md) beschrieben.

Vereinbart die neue Operation gemeinsam, bevor ihr parallel beginnt.
Stimmt notwendige gemeinsame Änderungen ab, damit eure Branches zusammenpassen.

**Mindestumfang:** 2 positive und 1 negativer Unit-Test. Prüft sowohl die
Rechenlogik als auch die Zuordnung der Operation im Parser.

## Aufgabe 2: End-to-End-Tests

Prüft einen vollständigen Ablauf von der XML-Datei bis zum Rechenergebnis.

- Legt eine Testklasse an, deren Name auf `Test` endet, etwa `EndToEndTest`.
- Verwendet den echten `Parser` und einen echten `CalculatorImpl`, keine Mocks.
- Erstellt mindestens **2 neue XML-Dateien** unter `src/test/resources/`.
- Verwendet unterschiedliche Rechenoperationen und prüft jeweils das Ergebnis.
- Berechnet die erwarteten Ergebnisse zuerst selbst.

**Mindestumfang:** 2 E2E-Tests mit den neuen XML-Dateien. Verwendet für jeden Test
einen frischen Calculator, damit kein Zustand aus einem anderen Test übrig bleibt.

## Aufgabe 3: sin und cos

Erweitert Schnittstelle, Rechenlogik und Parser um `sin` und `cos`.
Die XML-Operationen heißen ebenfalls `sin` und `cos`.

- Die Operationen benötigen jeweils **eine** Zahl auf dem Stapel.
- Winkel werden im **Bogenmaß (Radiant)** angegeben.
- Beispiele: `sin(0) = 0`, `cos(0) = 1` und `sin(π/2) ≈ 1`.
- Vergleicht Ergebnisse von Gleitkommarechnungen mit einer passenden Toleranz,
  beispielsweise `1e-9`.
- Wechselt die Zuständigkeiten gegenüber Aufgabe 1: Wer bisher implementiert
  hat, übernimmt diesmal auch Tests bzw. einen anderen Projektteil.

**Mindestumfang:** insgesamt 2 Unit-Tests und 2 E2E-Tests. Deckt beide neuen
Operationen ab. Als zusätzlichen Randfall könnt ihr einen leeren Stapel prüfen.

## Aufgabe 4: Skalarprodukt

Erweitert Calculator und Parser um die Operation `dotproduct`.

Für zwei gleich lange Vektoren multipliziert ihr die zusammengehörigen Werte
und addiert die Produkte. Beispiel: `(1, 3) · (2, 4) = 1·2 + 3·4 = 14`.

Der Stapel erhält die Werte in dieser Reihenfolge:

1. Alle Werte des ersten Vektors: `1`, `3`.
2. Alle Werte des zweiten Vektors: `2`, `4`.
3. Die Anzahl der Werte **pro Vektor**: `2`.
4. Anschließend folgt die Operation `dotproduct`, Ergebnis `14`.

### Erwartetes Verhalten

- Die Anzahl ist eine positive ganze Zahl. Eine Länge von `1` ist gültig.
- `0`, negative Zahlen und Bruchteile wie `1.5` sind als Anzahl ungültig.
- Ungültige Anzahlen oder zu wenige Werte führen zu einer `CalculatorException`.
- Die Operation funktioniert für unterschiedliche Vektorlängen, nicht nur für
  das Beispiel mit zwei Elementen.

**Mindestumfang:** 2 positive und 1 negativer Test. Verwendet dafür Unit-Tests
für Calculator und Parser. Für die beiden positiven Fälle erlaubt die Detailfolie
alternativ 2 E2E-Tests mit echtem Parser und Calculator. Wählt beispielsweise die
Längen `1` und `2` sowie eine ungültige Anzahl als Fehlerfall.

## CI: Build und Tests auf GitHub

Das Ausgangsprojekt enthält bereits `.github/workflows/maven.yml`. Bearbeitet
diesen Teil im Unterrichtsblock zu Continuous Integration.

- Erklärt, wann der Workflow startet und welche Schritte er ausführt.
- Prüft Java 21, die Maven-Aufrufe und die Ausführung der Tests.
- Prüft den Workflow im eigenen Gruppen-Repository und passt ihn bei Bedarf an.
- Beobachtet in einem Aufgabenbranch einen fehlgeschlagenen Testlauf und danach
  den erfolgreichen Lauf nach der Korrektur. Verlinkt beide Läufe in der Abgabe.
- Vor der Abgabe müssen Build und Tests auf `main` erfolgreich laufen.

Die Unterstützung für CI liegt bereits bei. Bewertet wird, ob ihr den Workflow
versteht und er für euren Projektstand funktioniert.

## Spätere weitere Übung

Der Puzzleroom ist eine eigene Aufgabe mit einem separaten Ausgangsprojekt.
Sein Code gehört nicht in dieses Calculator-Repository. Die Lehrenden geben
die zugehörigen Aufgaben und das Repository im weiteren Kursverlauf bekannt.
