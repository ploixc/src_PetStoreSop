package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.AccueilInterf;
import com.sopragroup.cco.tf.web.pages.AccueilSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccueilStep {


	private static Logger logger = Logger.getLogger(AccueilStep.class.getName());

	private AccueilInterf accueil;

	public AccueilStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut AccueilStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		accueil = new AccueilSel(webDriver);
		logger.debug("Fin   AccueilStep prepare @Before");
	}

	 //************ PAGE D'ACCUEIL ******************
    @Given("Sur la page 'Accueil' URL '(.*)'")
    public void goAccueil(String url) {
    	accueil.go(url );
    	//accueil.verifyPage();
    }
    
    
    @When ("^ACCU01 Cliquer sur le bouton 'Continuer'$")
    public void cliquerBtContinuer() {
    	accueil.clickSurBtContinuer();
    }
    
    @Then("La page 'Accueil' s'affiche")
    public void AccueilAfficheLong() {
    	accueil.verifyPage();
    }

    @Then("La page 'Menu Principale MP001' s'affiche")
    public void AccueilAfficheCourt() {
    	accueil.verifyPage();
    }

}
