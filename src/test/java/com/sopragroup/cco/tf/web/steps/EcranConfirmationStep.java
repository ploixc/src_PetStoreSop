package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.EcranConfirmationInterf;
import com.sopragroup.cco.tf.web.pages.EcranConfirmationSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EcranConfirmationStep {


	private static Logger logger = Logger.getLogger(EcranConfirmationStep.class.getName());

	private EcranConfirmationInterf ecranConfirmation;

	public EcranConfirmationStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut EcranConfirmationStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		ecranConfirmation = new EcranConfirmationSel(webDriver);
		logger.debug("Fin   EcranConfirmationStep prepare @Before");
	}

	   //******* ECRAN DE CONFIRMATION
    @Then("La page 'Ecran de confirmation' s'affiche")
    	public void surEcranConfirmationLong() {
    		ecranConfirmation.verifyPage();
    }

    @Then("La page 'ECONF01' s'affiche")
    public void surEcranConfirmationCourt() {
    	ecranConfirmation.verifyPage();
    }
    
    @When("ECONF01 Cliquer sur le buton 'Oui'")
    public void ecranConfirmationBtOui() {
    	ecranConfirmation.clickBtOui();
    }
    
    @When("ECONF01 Cliquer sur le buton 'Non'")
    public void ecranConfirmationBtNon() {
    	ecranConfirmation.clickBtNon();
    }
}
