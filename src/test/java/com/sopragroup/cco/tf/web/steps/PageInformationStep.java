package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.PageInformationInterf;
import com.sopragroup.cco.tf.web.pages.PageInformationSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PageInformationStep {


	private static Logger logger = Logger.getLogger(PageInformationStep.class.getName());

	private PageInformationInterf pageInformation;

	public PageInformationStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut PageInformationStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		pageInformation = new PageInformationSel(webDriver);
		logger.debug("Fin   PageInformationStep prepare @Before");
	}

  //************ PAGE INFORMATION ******************
    
    @Then("La page 'Information' s'affiche")
    public void surLaPageInformationlong() {
    	pageInformation.verifyPage();
    }
    
    @Then("La page 'PINF01' s'affiche")
    public void surLaPageInformationCourt() {
    	pageInformation.verifyPage();
    }

    @When("PINF01 Cliquer sur le lien 'Suite'")
    public void pageInformationLienSuite() {
    	pageInformation.clickLienSuite();
    }
    
    /**
     * On peut memoriser les valeur d'un champ (nom du champ colonne 1) du tableau (valeur colonne 2) dans une variable de contexte qui sera utilisé plus tard dans le meme scenario
     * @param nomVarialble
     */
    @Then("PINF01 Sauver la valeur du champ 'Numéro de Référence' dans la variable '(.*)'")
    public void noterValeurNumeroReference(String nomVarialble) {
    	pageInformation.sauverValeurNumeroReference(StepGlobalUtils.getContext(), nomVarialble);
    }
    
    @Then("PINF01 le message s'affiche '(.*)'")
    public void verifyMessage(String message) {
    	pageInformation.verifMessage(message);
    }
    
}
