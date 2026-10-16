# Stack Calculator – Softwareentwicklungsmodelle

In diesem Projekt erweitert ihr einen kleinen Taschenrechner. Ihr übt Git,
automatisierte Tests und die Zusammenarbeit in eurer Moodle-Gruppe.

## Einstieg

1. Klont das Repository eurer **Moodle-Gruppe**, sobald ihr den Link erhalten habt.
2. Öffnet die `pom.xml` als Maven-Projekt in eurer IDE.
3. Prüft eure Java- und Maven-Version und führt die vorhandenen Tests aus.

```sh
java -version
mvn -version
mvn --batch-mode clean verify
```

Voraussetzungen: **JDK 21**, Maven 3.9 oder neuer und Git. Auch die Ausgabe von
`mvn -version` muss Java 21 anzeigen. Stellt in der IDE sowohl das Projekt-JDK
als auch das JDK des Maven-Runners auf 21 ein.

Der Ausgangsstand enthält **8 Tests**. Ein erfolgreicher Lauf endet mit
`BUILD SUCCESS`. Das Projekt wird über die Tests ausgeführt; es enthält keine
Kommandozeilenanwendung mit einer `main`-Methode.

## Anleitungen

| Dokument | Inhalt |
| --- | --- |
| [Aufgaben](docs/AUFGABEN.md) | Modulo, E2E-Tests, sin/cos, Skalarprodukt und CI |
| [Zusammenarbeit](docs/ZUSAMMENARBEIT.md) | Arbeitsteams, Pair Programming und Reviews |
| [Abgabe](docs/ABGABE.md) | Checkliste, GitHub-Release und Einreichung in Moodle |
| [Abgabevorlage](ABGABE.md) | Gruppenmitglieder, erledigte Aufgaben und Nachweise |

Die Moodle-Gruppen A, B und C arbeiten mit je vier Personen in zwei Zweierteams.
Gruppe G bleibt mit fünf Personen zusammen und bildet ein Zweierteam und ein
Dreierteam mit wechselnden Rollen. Jede Gruppe arbeitet in ihrem eigenen Repository.

**Beginn:** Projekt starten, dann nach Freigabe der Lehrperson Aufgaben 1 und 2
bearbeiten. Weitere Aufgaben und verbindliche Abgabetermine kündigen die
Lehrenden im Kurs an. Es gibt in dieser Vorlage keine vorgegebenen Fristen.

## Aufbau des Projekts

| Datei bzw. Verzeichnis | Aufgabe |
| --- | --- |
| `src/main/java/at/campus02/swe/Calculator.java` | Schnittstelle und bekannte Operationen |
| `src/main/java/at/campus02/swe/logic/CalculatorImpl.java` | Stapel und Rechenlogik |
| `src/main/java/at/campus02/swe/parser/Parser.java` | XML einlesen und an den Calculator weitergeben |
| `src/test/java/` | Vorhandene und neue JUnit-Tests |
| `src/test/resources/` | XML-Dateien für Tests |
| `.github/workflows/maven.yml` | Vorhandener Build- und Testworkflow für GitHub |

Das Projekt verwendet **JUnit 4.13.1** und Mockito. Verwendet für neue Tests die
JUnit-4-Imports, beispielsweise `org.junit.Test`. Die optionalen Jupiter-Beispiele
aus den Folien benötigen andere Abhängigkeiten und gehören nicht zum Einstieg.

## Wie der Calculator rechnet

`push` legt eine Zahl oben auf den Stapel, `pop` entfernt die oberste Zahl.
Bei einer Rechnung mit zwei Zahlen wird zuerst die zuletzt abgelegte Zahl
entnommen. Legt ihr zuerst `6`, dann `2` ab, ergibt die Division `6 / 2 = 3`.

Eine Operation liefert ihr Ergebnis zurück. Sie legt es **nicht automatisch**
wieder auf den Stapel. In XML könnt ihr das zuletzt berechnete Ergebnis mit
`<push value="Result" />` erneut verwenden.

```xml
<calculation>
    <push value="6" />
    <push value="2" />
    <operation value="/" />
</calculation>
```

Diese Rechnung ergibt `3`. Weitere Ausgangsbeispiele findet ihr in
`src/test/resources/`.

## Ausgangspunkt

Grundlage ist [Valerionn/fh-campus02-swe-2025](https://github.com/Valerionn/fh-campus02-swe-2025),
Stand `4197487625b84ad7a3bb86e1aece2327752279b3`.
Die vorhandene Implementierung und ihre Tests bilden den Ausgangspunkt für die Übungen.
