package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.FormulaireRechercheDocumentInterf;
import com.sopragroup.cco.tf.web.pages.FormulaireRechercheDocumentSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormulaireRechercheDocumentStep {


	private static Logger logger = Logger.getLogger(FormulaireRechercheDocumentStep.class.getName());

	private FormulaireRechercheDocumentInterf formulaireRechercheDocument;

	public FormulaireRechercheDocumentStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut FormulaireRechercheDocumentStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		formulaireRechercheDocument = new FormulaireRechercheDocumentSel(webDriver);
		logger.debug("Fin   FormulaireRechercheDocumentStep prepare @Before");
	}

 //************ FORMULAIRE RECHERCHE DOCUMENTS ******************
    
    @Then("La page 'Formulaire recherche des documents' s'affiche")
    public void formRechercheAfficheLong() {
    	formulaireRechercheDocument.verifyPage();
    }
    
    @Then("La page 'FRECH01' s'affiche")
    public void formRechercheAfficheCourt() {
    	formulaireRechercheDocument.verifyPage();
    }
    
    @Then("FRECH01 Le message '(.*)' s'affiche")
    public void formRechercheVerifMessage(String message) {
    	formulaireRechercheDocument.verifyErrorMessage(message);
    }
    
    @When("FRECH01 Cliquer sur le bouton 'Rechercher'")
    public void formRechercheLanceRecherche() {
    	formulaireRechercheDocument.cliquerBtRechercher();
    }
    
    @When("FRECH01 Cliquer sur le bouton 'Annuler'")
    public void formRechercheBtAnnuler() {
    	formulaireRechercheDocument.cliquerBtAnnuler();
    }
    
    @When("FRECH01 Cliquer sur le bouton 'Reset'")
    public void formRechercheBtRest() {
    	formulaireRechercheDocument.cliquerBtReset();
    }
    
    @When("FRECH01 Dans le champ 'No de r[ée]f[ée]rence' saisir '([0-9].*)'$")
    public void formRechercheSaisirNoRef(String numeroReference) {
    	formulaireRechercheDocument.saisirNumeroReference(numeroReference);
    }
    
    @When("FRECH01 Dans le champ 'No de référence' saisir la variable '(.*)'")
    public void formRechercheSaisirNoRefParVariable(String nomVariable) {
    	String numeroReference = StepGlobalUtils.getContext().get(nomVariable);
    	formulaireRechercheDocument.saisirNumeroReference(numeroReference);
    }
    
    @When("FRECH01 Dans la liste de choix 'Crée ou Modifié Par' choisir '(.*)'$")
    public void formRechercheChoisirCreeModifiePar(String choix) {
    	formulaireRechercheDocument.choisirCreeModifiePar(choix);
    }
  
    @When("FRECH01 Dans le champ 'Mots cl[ée]s' saisir '(.*)'$")
    public void formRechercheSaisirMotCle(String motCle) {
    	formulaireRechercheDocument.saisirMotCle(motCle);
    }
    
    @When("FRECH01 Cocher 'Recherche textuelle'")
    public void formRechercheCocherRechercheTextuelle() {
    	formulaireRechercheDocument.equals(true);
    }
    
    @When("FRECH01 Dans le champ 'Version' saisir '(.*)'$")
    public void formRechercheSaisirVersion(String version) {
    	formulaireRechercheDocument.saisirVersion(version);
    }
    
    @When("FRECH01 Dans la liste de choix 'Importance' choisir '(.*)'$")
    public void formRechercheChoisirImportance(String choix) {
    	formulaireRechercheDocument.choisirImportance(choix);
    }
        
    @When("FRECH01 Dans la liste de choix 'Etat' choisir '(.*)'$")
    public void formRechercheChoisirEtat(String choix) {
    	formulaireRechercheDocument.choisirEtat(choix);
    }
    
    @When("FRECH01 Dans la liste de choix 'Cat[ée]gorie' choisir '(.*)'")
    public void formRechercheChoisirCategorie(String choix) {
    	formulaireRechercheDocument.choisirCategorie(choix);
    }
    
    @When("FRECH01 Dans la liste de choix 'R[ée]pertoires virtuels Axe Projet' choisir '(.*)'$")
    public void formRechercheChoisirAxeProjet(String choix) {
    	formulaireRechercheDocument.choisirAxeProjet(choix);
    }
    
    @When("FRECH01 Dans la liste de choix 'R[ée]pertoires virtuels Axe Techno' choisir '(.*)'$")
    public void formRechercheChoisirAxeTechno(String choix) {
    	formulaireRechercheDocument.choisirAxeTechno(choix);
    }
    
    @When("FRECH01 Dans la liste de choix 'Ordre d'affichage' choisir '(.*)'")
    public void formRechercheChoisirOrdreAffichage(String choix) {
    	formulaireRechercheDocument.choisirOrdreAffichage(choix);
    }
}
