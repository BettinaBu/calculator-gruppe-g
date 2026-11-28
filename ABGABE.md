# Abgabe der Gruppe G

## Mitglieder

| GitHub-Benutzername | Name | Arbeitsteam |
| --- | --- | --- |
| BettinaBu | Bettina Bulfone | 2 |
| Murphy57100 | Abigail Kleedorfer | 2 |
| dominik-stiegelbauer | Dominik Stiegelbauer | 1 |
| DaHof93 | David Hofer | 1 |
| Szilhub | Szilard Petzinger | 1 |

## Aufgaben und Nachweise

| Aufgabe | Status | Issues / Pull Requests | Neue Tests bzw. CI-Nachweis |
| --- | --- | --- | --- |
| 1: Modulo | erledigt | PR [#3](https://github.com/BettinaBu/calculator-gruppe-g/pull/3), [#6](https://github.com/BettinaBu/calculator-gruppe-g/pull/6), [#7](https://github.com/BettinaBu/calculator-gruppe-g/pull/7), [#21](https://github.com/BettinaBu/calculator-gruppe-g/pull/21) (Issue #20) | `CalculatorTest`: `testSimpleModOperation` (7 % 3 = 1), `testModOperationWithoutRemainder` (6 % 3 = 0), `testModuloWithNegativeDividend` (-7 % 3 = -1), `testModuloByZero` (Exception „Division by zero“); `ParserTest`: `testParserModuloXml` (`%` → `Operation.mod`, `test04.xml`) |
| 2: E2E-Tests | erledigt | PR [#9](https://github.com/BettinaBu/calculator-gruppe-g/pull/9) | `e2eTest`: `testParserTest05Xml` ((10 − 4) / 2 = 3, `test05_e2e.xml`), `testParserTest06Xml` ((3 · 5) % 4 = 3, `test06_e2e.xml`) |
| 3: sin/cos | erledigt | PR [#12](https://github.com/BettinaBu/calculator-gruppe-g/pull/12), [#17](https://github.com/BettinaBu/calculator-gruppe-g/pull/17) (Issue #11) | `CalculatorTest`: `testSinOperation` (sin(π/2) = 1), `testCosOperation` (cos(0) = 1); `e2eTest`: `testParserTest07SinXml` (`test07_e2e.xml`), `testParserTest08CosXml` (`test08_e2e.xml`), jeweils Toleranz 1e-9 |
| 4: Skalarprodukt | erledigt | PR [#16](https://github.com/BettinaBu/calculator-gruppe-g/pull/16) (Issue #14), [#18](https://github.com/BettinaBu/calculator-gruppe-g/pull/18) (Issue #15) | `CalculatorTest`: `testDotProductLength1` ((3)·(4) = 12), `testDotProductLength2` ((1,3)·(2,4) = 14), `testDotProductWithZeroLength`, `testDotProductWithNegativeLength`, `testDotProductWithFractionalLength`, `testDotProductWithNotEnoughValues` (jeweils `CalculatorException`); `ParserTest`: `testParserDotProductXml` (`test07_dotproduct.xml`) |
| CI | erledigt | PR [#22](https://github.com/BettinaBu/calculator-gruppe-g/pull/22) | Fehlgeschlagener Lauf: [Run 46148917334](https://github.com/BettinaBu/calculator-gruppe-g/actions/runs/46148917334) (Commit d88c1bb, `testSimpleMulOperation` erwartet 7, erhält 6)<br>Erfolgreicher Lauf nach Korrektur: [Run 46150474639](https://github.com/BettinaBu/calculator-gruppe-g/actions/runs/46150474639) (Branch `falscherRunCI`, Commit c5e6a69, PR #22)<br>Erfolgreicher Lauf vor dem Fehlschlag (Workflow-Update): [Run 46148022663](https://github.com/BettinaBu/calculator-gruppe-g/actions/runs/46148022663) (Commit 0f7243a) |

## Zusammenarbeit

| Aufgabe | Implementierung | Tests | Commits |
| --- | --- | --- | --- |
| 1: Modulo | Arbeitsteam 1 | Arbeitsteam 2 | [Implementation](https://github.com/BettinaBu/calculator-gruppe-g/pull/3/commits)<br>[Testcases](https://github.com/BettinaBu/calculator-gruppe-g/pull/6/commits) (erster Versuch [#4](https://github.com/BettinaBu/calculator-gruppe-g/pull/4) wurde mit [#5](https://github.com/BettinaBu/calculator-gruppe-g/pull/5) zurückgesetzt)<br>[Edgecase](https://github.com/BettinaBu/calculator-gruppe-g/pull/7/commits)<br>[Parser-Test](https://github.com/BettinaBu/calculator-gruppe-g/pull/21/commits) |
| 2: E2E-Tests | Arbeitsteam 1 | / | [Implementation](https://github.com/BettinaBu/calculator-gruppe-g/pull/9/commits) |
| 3: sin/cos | Arbeitsteam 2 | Arbeitsteam 1 | [Implementation](https://github.com/BettinaBu/calculator-gruppe-g/pull/12/commits)<br>[Testcases](https://github.com/BettinaBu/calculator-gruppe-g/pull/17/commits) |
| 4: Skalarprodukt | Arbeitsteam 2 | Arbeitsteam 1 | [Implementation](https://github.com/BettinaBu/calculator-gruppe-g/pull/16/commits)<br>[Testcases](https://github.com/BettinaBu/calculator-gruppe-g/pull/18/commits) |
| CI | Arbeitsteam 1 | Arbeitsteam 1 | [Workflow-Update (0f7243a)](https://github.com/BettinaBu/calculator-gruppe-g/commit/0f7243a)<br>[Fehlschlag und Korrektur](https://github.com/BettinaBu/calculator-gruppe-g/pull/22/commits) |

Aufteilung innerhalb der Teams:

| Aufgabe | Coder | Pairprogrammer                        | Review |
| --- | --- |---------------------------------------| --- |
| 1: Modulo Implementation | David | Szilard, Dominik                      | Bettina, Abigail |
| 1: Modulo Test | Bettina Grundtest<br>Abigail Edgecase | Abigail Grundtest<br>Bettina Edgecase | David, Szilard, Dominik |
| 1: Modulo Parser-Test | Dominik | David, Szilard                        | Bettina, Abigail |
| 2: E2E-Tests | David | Szilard, Dominik                      | Bettina, Abigail |
| 3: sin/cos Implementation | Bettina | Abigail                               | David, Szilard, Dominik |
| 3: sin/cos Test | David | Szilard, Dominik                      | Bettina, Abigail |
| 4: Skalarprodukt Implementation | Bettina | Abigail                               | David, Szilard, Dominik |
| 4: Skalarprodukt Test | Dominik | David, Szilard                        | Bettina, Abigail |
| CI | David | Szilard, Dominik, Bettina, Abigail    | Szilard, Dominik, Bettina, Abigail |

Ehrlich gesagt haben wir vieles als ganze Gruppe gemeinsam gemacht und dabei viel miteinander geredet. Die Zuständigkeiten der Arbeitsteams haben wir aber bewusst beibehalten und bei den Reviews sowie beim Mergen sowie eingehalten, wo es möglich war.

Die Abstimmung zwischen den Teams war nicht immer einfach. Pull Requests sind häufig länger liegen geblieben, bevor sie gemergt wurden. Das hat mehrmals zu Verzögerungen geführt. Beim nächsten Mal wollen wir deshalb vorher einen klaren Ablauf und klare Regeln festlegen sowie eine Person bestimmen, die den Überblick behält und im Zweifel Entscheidungen trifft.

## Offene Probleme

- Das Skalarprodukt heißt bei uns „dot” statt „dotproduct”.

- Den absichtlich falschen Test für den roten CI-Lauf haben wir versehentlich direkt auf „main” gepusht, statt ihn in einen eigenen Branch zu pushen. Deshalb war main kurz rot. Wir haben den Test dann im Branch falscherRunCI korrigiert und über PR #22 gemergt. Seitdem laufen alle Tests wieder grün, auch auf main.

- Sonst sind keine Probleme bekannt.
