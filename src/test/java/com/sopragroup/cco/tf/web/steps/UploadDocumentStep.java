package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.UploadDocumentInterf;
import com.sopragroup.cco.tf.web.pages.UploadDocumentSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UploadDocumentStep {


	private static Logger logger = Logger.getLogger(UploadDocumentStep.class.getName());

	private UploadDocumentInterf uploadDocument;

	public UploadDocumentStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut UploadDocumentStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		uploadDocument = new UploadDocumentSel(webDriver);
		logger.debug("Fin   UploadDocumentStep prepare @Before");
	}

  //************ UPLOAD DOCUMENT ******************
    
    @Then("La page 'upload page' s'affiche")
    public void surUploadDocumentLong() {
    	uploadDocument.verifyPage();
    }
    
    @Then("La page 'FUPL0[12]' s'affiche")
    public void surUploadDocumentCourt() {
    	uploadDocument.verifyPage();
    }

    @When("FUPL0[12] Dans le champ 'Fichier [àa] uploader' saisir '(.*)'$")
    public void uploadDocumentSaisirFileName(String fileName) {
    	uploadDocument.saisirCheminFichier(fileName);
    }
    
    @When("FUPL0[12] Cliquer sur le bouton 'Envoyer'")
    public void uploadDocumentCliquerBtEnvoyer() {
    	uploadDocument.cliquerEnvoyer();
    }
}
