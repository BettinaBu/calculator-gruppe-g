# Zusammenarbeit in der Gruppe

Eure Moodle-Gruppe arbeitet in **einem gemeinsamen Repository**.
Die Moodle-Gruppen heißen A, B, C und G. Innerhalb jeder Gruppe bildet ihr
**Arbeitsteam 1 und Arbeitsteam 2**. Diese entsprechen „Team A“ und „Team B“
in den Folien; gemeint sind die Arbeitsteams innerhalb einer Moodle-Gruppe.

- **Gruppen A, B und C:** je vier Personen, aufgeteilt in zwei Zweierteams.
- **Gruppe G:** fünf Personen, aufgeteilt in ein Zweierteam und ein Dreierteam.

Tragt alle Namen, GitHub-Benutzernamen und eure anfängliche Teamaufteilung in
[ABGABE.md](../ABGABE.md) ein. Alle arbeiten am selben Aufgabenumfang.

## Pair Programming innerhalb eines Zweierteams

- **Driver:** schreibt den Code und erklärt den nächsten kleinen Schritt.
- **Navigator:** denkt mit, prüft Annahmen und schlägt Testfälle vor.
- Wechselt nach einem Testfall oder etwa 10 Minuten die Rollen.
- Beide Personen können anschließend den Code und die Tests erklären.

Im **Dreierteam** übernimmt die dritte Person die Testperspektive: Sie überlegt
konkrete Beispiele und Randfälle und prüft die erwarteten Ergebnisse. Nach einem
Testfall oder etwa 10 Minuten wechseln alle drei die Rollen. Niemand bleibt
dauerhaft Beobachter. Wechselt zwischen den Aufgaben auch die Zusammensetzung
von Zweier- und Dreierteam, damit alle beide Arbeitsweisen kennenlernen.

Jede Person verwendet ihr eigenes GitHub-Konto. Im Pull Request nennt ihr alle
beteiligten Personen. Die Zahl der Commits allein beschreibt nicht den Beitrag
einer Person.

## Ablauf für eine Aufgabe

1. **Issue anlegen:** Beschreibt die Aufgabe und die erwarteten Ergebnisse.
   Nutzt dafür die Vorlage „Aufgabe“ und nennt alle beteiligten Personen im Text.
   Weist eine Person als Ansprechperson zu; weitere Beteiligte stehen im Text.
2. **Aktuellen Stand holen:** Wechselt auf `main` und holt die Änderungen der Gruppe.
3. **Aufgabenbranch erstellen:** beispielsweise `feature/modulo-calculator`.
4. **Im Arbeitsteam arbeiten:** Code und Tests ergänzen, Änderungen lokal prüfen.
5. **Commit erstellen und pushen:** Prüft vor dem Commit, welche Dateien dazugehören.
6. **Pull Request nach `main` öffnen:** Nennt das Issue, alle Beteiligten und eure Tests.
7. **Anderes Arbeitsteam um Review bitten:** Arbeitsteam 1 prüft Änderungen von
   Arbeitsteam 2 und umgekehrt. Mindestens eine Person des anderen Teams gibt das Review ab.
8. **Rückmeldungen einarbeiten:** Offene Fragen klären und Tests erneut ausführen.
9. **Nach Freigabe mergen:** Build und Tests müssen erfolgreich sein. Alle holen
   danach den neuen Stand von `main`.

Beispiel für den lokalen Beginn:

```sh
git switch main
git pull --ff-only
git switch -c feature/modulo-calculator
```

Beispiel vor dem Commit:

```sh
mvn --batch-mode clean verify
git status
git add src/main/java/at/campus02/swe/Calculator.java
git add src/main/java/at/campus02/swe/logic/CalculatorImpl.java
git diff --staged
git commit -m "Add modulo operation"
git push -u origin feature/modulo-calculator
```

Wählt die Dateien und den Branch passend zu eurer tatsächlichen Aufgabe. Wenn ihr
Tests ergänzt, nehmt die betreffenden Testdateien ebenfalls in den Commit auf.

## Was gehört zu einem Review?

- Erfüllt der Code die vereinbarte Aufgabe?
- Sind die erwarteten Ergebnisse der Tests nachvollziehbar?
- Gibt es Tests für normale Eingaben sowie passende Fehler- und Randfälle?
- Sind Namen und Änderungen verständlich?

Ein hilfreicher Kommentar nennt eine konkrete Beobachtung, etwa:
„Bei Divisor 0 erwarte ich eine Exception. Welcher Test prüft das?“
Bei einem passenden Ergebnis gebt ihr den Pull Request frei. Eine formale Freigabe
ersetzt das tatsächliche Lesen des Codes nicht.

## Gemeinsam arbeiten

Haltet Änderungen klein und stimmt euch ab, wenn ihr dieselbe Datei ändern müsst.
In Aufgabe 1 vereinbart ihr insbesondere den Namen der neuen Operation gemeinsam.
Die Aufgabe gehört der gesamten Moodle-Gruppe, auch wenn ihr die Arbeit aufteilt.
