package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.FormulaireLoginInterf;
import com.sopragroup.cco.tf.web.pages.FormulaireLoginSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormulaireLoginStep {


	private static Logger logger = Logger.getLogger(FormulaireLoginStep.class.getName());

	private FormulaireLoginInterf formulaireLogin;

	public FormulaireLoginStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut FormulaireLoginStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		formulaireLogin = new FormulaireLoginSel(webDriver);
		logger.debug("Fin   FormulaireLoginStep prepare @Before");
	}

	//************ FORMULAIRE DE LOGIN ******************

	@Then("^La page 'Formulaire de login' s'affiche$")
	public void verifFormulaireLoginLong() {
		formulaireLogin.verifyPage();
	}

	@Then("^La page 'FLOG01' s'affiche$")
	public void verifFormulaireLoginCourt() {
		formulaireLogin.verifyPage();
	}

	@Given("^Sur la page 'Formulaire de login'$")
	public void surLeFormulaireLoginLong() {
		formulaireLogin.verifyPage();
	}

	@Given("^Sur la page 'FLOG01'$")
	public void surLeFormulaireLoginCourt() {
		formulaireLogin.verifyPage();
	}

	@When("FLOG01 Dans le champ 'login' saisir '(.*)'$")
	public void formLoginSaisirLogin(String loginP) {
		formulaireLogin.saisirLogin(loginP);
	}

	@When("FLOG01 Dans le champ 'Mot de passe' saisir '(.*)'")
	public void formulaireLoginSaisirPassword(String password) {
		formulaireLogin.saisirPassword(password);
	}


	@When("FLOG01 Cliquer sur le bouton 'Connexion'")
	public void formulaireLogin() {
		formulaireLogin.cliquerConnexion();
	}

	@Then("FLOG01 Le message '(.*)' s'affiche")
	public void verifMessageErreurLoginCourt(String message) {
		formulaireLogin.verifyErrorMessage(message);
	}
}
