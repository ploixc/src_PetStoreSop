@accueil
Feature: Appel page d'accueil de l'application par différentes façons de déclarer la première URL en dur ou par une variable d'environnement

  Scenario: accueil url en dur
    Given Sur la page 'Accueil' URL 'http://localhost:8080'
    When ACCU01 Cliquer sur le bouton 'Continuer'
    Then La page 'Menu Principale MP001' s'affiche

  Scenario: accueil avec url en variable d'environnement
    Given Sur la page 'Accueil' URL 'ENV:URL_HOME'
    When ACCU01 Cliquer sur le bouton 'Continuer'
    Then La page 'Menu Principale MP001' s'affiche

    
  Scenario: Commander un Koi
    Given Sur la page 'Accueil' URL 'ENV:URL_HOME'
    When ACCU01 Cliquer sur le bouton 'Continuer'
    Then La page 'Menu Principale MP001' s'affiche
    Then PRIN01 Acceder au catalogue 'Poisson'
  