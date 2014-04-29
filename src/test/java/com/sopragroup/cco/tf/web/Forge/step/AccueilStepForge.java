package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.AccueilInterf;
import com.sopragroup.cco.tf.web.pages.AccueilForge;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccueilStepForge {


	private static Logger logger = Logger.getLogger(AccueilForge.class.getName());

	private AccueilForge accueil;

	public AccueilStepForge() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut AccueilForge prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		accueil = new AccueilForge(webDriver);
		logger.debug("Fin   AccueilForge prepare @Before");
	}

	 //************ PAGE D'ACCUEIL ******************
	        
    @Given("FORG01 Sur la page 'Accueil' URL '(.*)'")
    public void goAccueil(String url) {
    	accueil.go(url ); //+ "/Pages/default.aspx"
    	//accueil.verifyPage();
    }
    
    @Given("FORG02 Acces au lien Link '(.*)'")
    public void AccueilAfficheLong(String Link) {
    	accueil.clickSurLien(Link);
    }

    
    @When ("^ACFO01 Cliquer sur le bouton 'LE MANS'$")
    public void cliquerBtContinuer() {
    	//accueil.clickSurBtContinuer();
    }
    
 /*   @Then("La page 'Accueil' s'affiche")
    public void AccueilAfficheLong() {
    	accueil.verifyPage();
    }
*/
    @Then("La page ACFO01 affiche '(.*)'")
    public void AccueilAfficheCourt(String Texte) {
    	accueil.verifyPage01(Texte);
    }

}
