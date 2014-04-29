package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.FormulaireChoixModificationInterf;
import com.sopragroup.cco.tf.web.pages.FormulaireChoixModificationSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormulaireChoixModificationStep {


	private static Logger logger = Logger.getLogger(FormulaireChoixModificationStep.class.getName());

	private FormulaireChoixModificationInterf formulaireChoixModification;

	public FormulaireChoixModificationStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut FormulaireChoixModificationStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		formulaireChoixModification = new FormulaireChoixModificationSel(webDriver);
		logger.debug("Fin   FormulaireChoixModificationStep prepare @Before");
	}

    //******* CHOIX MODIFICATION *******************
    @Then("La page 'Choix modification' s'affiche")
    public void surLaPageChoixModificationLong() {
    	formulaireChoixModification.verifyPage();
    }
    
    @Then("La page 'CHXMOD01' s'affiche")
    public void surLaPageChoixModificationCourt() {
    	formulaireChoixModification.verifyPage();
    }
    
    @When("CHXMOD01 Cliquer sur le bouton 'Modifier caracteristiques et autorisations'")
    public void  choixModificationBtModif() {
    	formulaireChoixModification.cliquerBtModifierCaracteristique();
    }
    
    @When("CHXMOD01 Cliquer sur le bouton 'Nouvelle version du document'")
    public void choixModificationBtNouvVerison() {
    	formulaireChoixModification.cliquerBtNouvelleVersion();
    }
    
    @When("CHXMOD01 Cliquer sur le bouton 'Annuler'")
    public void choixModificationBtAnnuler() {
    	formulaireChoixModification.cliquerBtAnnuler();
    }
}
