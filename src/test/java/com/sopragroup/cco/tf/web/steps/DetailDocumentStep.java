package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.DetailDocumentInterf;
import com.sopragroup.cco.tf.web.pages.DetailDocumentSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DetailDocumentStep {


	private static Logger logger = Logger.getLogger(DetailDocumentStep.class.getName());

	private DetailDocumentInterf detailDocument;

	public DetailDocumentStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut DetailDocumentStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		detailDocument = new DetailDocumentSel(webDriver);
		logger.debug("Fin   DetailDocumentStep prepare @Before");
	}

	  //************ DETAIL DOCUMENT ******************
    @Then("La page 'D[ée]tail document' s'affiche")
    public void surLaPageDetailDocumentlong() {
    	detailDocument.verifyPage();
    }
    
    @Then("La page 'DETAIL01' s'affiche")
    public void surLaPageDetailDocumentCourt() {
    	detailDocument.verifyPage();
    }

    @When("DETAIL01 Cliquer sur le lien 'Suivant'")
    public void pageDetailDocumentLienSuite() {
    	detailDocument.clickLienSuivant();
    }
    
    @When("DETAIL01 Cliquer sur le lien 'Pr[ée]c[ée]dent'")
    public void pageDetailDocumentLienPrecedent() {
    	detailDocument.clickLienPrecedent();
    }
    
    @When("DETAIL01 Cliquer sur le lien 'Retour [àa] la liste'")
    public void pageDetailDocumentLienRetourListe() {
    	detailDocument.clickLienRetourListe();
    }
	 
    @When("DETAIL01 Cliquer sur le lien 'Download'")
    public void pageDetailDocumentLienDownload() {
    	detailDocument.clickLienDownload();
    }
    
    @When("DETAIL01 Cliquer sur le lien 'Modifier document'")
    public void pageDetailDocumentLienModifier() {
    	detailDocument.clickLienModifier();
    }
    
    @When("DETAIL01 Cliquer sur le lien 'Effacer document'")
    public void pageDetailDocumentLienSupprimer() {
    	detailDocument.clickLienSupprimer();
    }
    
}
