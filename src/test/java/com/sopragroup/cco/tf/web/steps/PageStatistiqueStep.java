package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.PageStatistiqueInterf;
import com.sopragroup.cco.tf.web.pages.PageStatistiqueSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PageStatistiqueStep {


	private static Logger logger = Logger.getLogger(PageStatistiqueStep.class.getName());

	private PageStatistiqueInterf pageStatistique;

	public PageStatistiqueStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut PageStatistiqueStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		pageStatistique = new PageStatistiqueSel(webDriver);
		logger.debug("Fin   PageStatistiqueStep prepare @Before");
	}

    //******** PAGE STATISTIQUE *********************
    @Then("La page 'Statistique de la base' s'affiche")
    public void surLaPageStatistique() {
    	pageStatistique.verifyPage();
    }
    
    @When("STATS01 Cliquer sur le lien 'Retour'")
    public void pageStatistiqueRetourMenu() {
    	pageStatistique.lienRetourMenu();
    }
}
