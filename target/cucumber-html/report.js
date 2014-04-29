$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com\\sopragroup\\cco\\tf\\web\\steps\\login\\AccueilMinimum.feature");
formatter.feature({
  "id": "appel-page-d\u0027accueil-de-l\u0027application-par-différentes-façons-de-déclarer-la-première-url-en-dur-ou-par-une-variable-d\u0027environnement",
  "tags": [
    {
      "name": "@accueil",
      "line": 1
    }
  ],
  "description": "",
  "name": "Appel page d\u0027accueil de l\u0027application par différentes façons de déclarer la première URL en dur ou par une variable d\u0027environnement",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "appel-page-d\u0027accueil-de-l\u0027application-par-différentes-façons-de-déclarer-la-première-url-en-dur-ou-par-une-variable-d\u0027environnement;accueil-url-en-dur",
  "description": "",
  "name": "accueil url en dur",
  "keyword": "Scenario",
  "line": 4,
  "type": "scenario"
});
formatter.step({
  "name": "Sur la page \u0027Accueil\u0027 URL \u0027http://localhost:8080\u0027",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "ACCU01 Cliquer sur le bouton \u0027Continuer\u0027",
  "keyword": "When ",
  "line": 6
});
formatter.step({
  "name": "La page \u0027Menu Principale MP001\u0027 s\u0027affiche",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "arguments": [
    {
      "val": "http://localhost:8080",
      "offset": 27
    }
  ],
  "location": "AccueilStep.goAccueil(String)"
});
formatter.result({
  "duration": 297780998,
  "status": "passed"
});
formatter.match({
  "location": "AccueilStep.cliquerBtContinuer()"
});
formatter.result({
  "duration": 358525351,
  "status": "passed"
});
formatter.match({
  "location": "AccueilStep.AccueilAfficheCourt()"
});
formatter.result({
  "duration": 27841550,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.scenario({
  "id": "appel-page-d\u0027accueil-de-l\u0027application-par-différentes-façons-de-déclarer-la-première-url-en-dur-ou-par-une-variable-d\u0027environnement;accueil-avec-url-en-variable-d\u0027environnement",
  "description": "",
  "name": "accueil avec url en variable d\u0027environnement",
  "keyword": "Scenario",
  "line": 9,
  "type": "scenario"
});
formatter.step({
  "name": "Sur la page \u0027Accueil\u0027 URL \u0027ENV:URL_HOME\u0027",
  "keyword": "Given ",
  "line": 10
});
formatter.step({
  "name": "ACCU01 Cliquer sur le bouton \u0027Continuer\u0027",
  "keyword": "When ",
  "line": 11
});
formatter.step({
  "name": "La page \u0027Menu Principale MP001\u0027 s\u0027affiche",
  "keyword": "Then ",
  "line": 12
});
formatter.match({
  "arguments": [
    {
      "val": "ENV:URL_HOME",
      "offset": 27
    }
  ],
  "location": "AccueilStep.goAccueil(String)"
});
formatter.result({
  "duration": 217399025,
  "status": "passed"
});
formatter.match({
  "location": "AccueilStep.cliquerBtContinuer()"
});
formatter.result({
  "duration": 465995938,
  "status": "passed"
});
formatter.match({
  "location": "AccueilStep.AccueilAfficheCourt()"
});
formatter.result({
  "duration": 29873640,
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.scenario({
  "id": "appel-page-d\u0027accueil-de-l\u0027application-par-différentes-façons-de-déclarer-la-première-url-en-dur-ou-par-une-variable-d\u0027environnement;commander-un-koi",
  "description": "",
  "name": "Commander un Koi",
  "keyword": "Scenario",
  "line": 15,
  "type": "scenario"
});
formatter.step({
  "name": "Sur la page \u0027Accueil\u0027 URL \u0027ENV:URL_HOME\u0027",
  "keyword": "Given ",
  "line": 16
});
formatter.step({
  "name": "ACCU01 Cliquer sur le bouton \u0027Continuer\u0027",
  "keyword": "When ",
  "line": 17
});
formatter.step({
  "name": "La page \u0027Menu Principale MP001\u0027 s\u0027affiche",
  "keyword": "Then ",
  "line": 18
});
formatter.step({
  "name": "PRIN01 Acceder au catalogue \u0027Poisson\u0027",
  "keyword": "Then ",
  "line": 19
});
formatter.match({
  "arguments": [
    {
      "val": "ENV:URL_HOME",
      "offset": 27
    }
  ],
  "location": "AccueilStep.goAccueil(String)"
});
formatter.result({
  "duration": 217166396,
  "status": "passed"
});
formatter.match({
  "location": "AccueilStep.cliquerBtContinuer()"
});
formatter.result({
  "duration": 466300410,
  "status": "passed"
});
formatter.match({
  "location": "AccueilStep.AccueilAfficheCourt()"
});
formatter.result({
  "duration": 30222585,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Poisson",
      "offset": 29
    }
  ],
  "location": "PagePrincipalStep.accescatalogue(String)"
});
formatter.result({
  "duration": 331839,
  "status": "failed",
  "error_message": "java.lang.Error: Unresolved compilation problem: \n\tThe type PagePrincipaleSel must implement the inherited abstract method PagePrincipaleInterf.BtImage(String)\n\r\n\tat com.sopragroup.cco.tf.web.pages.PagePrincipaleSel.BtImage(PagePrincipaleSel.java:12)\r\n\tat com.sopragroup.cco.tf.web.steps.PagePrincipalStep.accescatalogue(PagePrincipalStep.java:44)\r\n\tat ✽.Then PRIN01 Acceder au catalogue \u0027Poisson\u0027(com\\sopragroup\\cco\\tf\\web\\steps\\login\\AccueilMinimum.feature:19)\r\n"
});
formatter.embedding("image/png", "embedded2.png");
});