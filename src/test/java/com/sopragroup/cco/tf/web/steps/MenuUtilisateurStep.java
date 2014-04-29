package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.MenuUtilisateurInterf;
import com.sopragroup.cco.tf.web.pages.MenuUtilisateurSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuUtilisateurStep {


	private static Logger logger = Logger.getLogger(MenuUtilisateurStep.class.getName());

	private MenuUtilisateurInterf menuUtilisateur;

	public MenuUtilisateurStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut MenuUtilisateurStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		menuUtilisateur = new MenuUtilisateurSel(webDriver);
		logger.debug("Fin   MenuUtilisateurStep prepare @Before");
	}

    //************ MENU UTILISATEUR ******************
    
    @Then("La page du 'Menu utilisateur' s'affiche")
    public void surLeMenuUtilisateurLong() {
    	menuUtilisateur.verifyPage();
    }
    
    @Then("La page du 'MENUU01' s'affiche")
    public void surLeMenuUtilisateurCourt() {
    	menuUtilisateur.verifyPage();
    }

    @Given("Sur la page 'Menu utilisateur'")
    public void surLeMenuUtilisateur2Long() {
       	menuUtilisateur.verifyPage();
    }
    
    @Given("Sur la page 'MENUU01'")
    public void surLeMenuUtilisateur2Court() {
       	menuUtilisateur.verifyPage();
    }
    
    @When("MENUU01 Cliquer sur le lien 'Recherche document'")
    public void menuUtilisateurLienRechercheDoc() {
        menuUtilisateur.clickLienRecherche();
    }
    
    @When("MENUU01 Cliquer sur le lien 'Nouveau document'")
    public void menuUtilisateurLienNouveauDoc() {
        menuUtilisateur.clickLienNouveauDocument();
    }
    
    
    @When("MENUU01 Cliquer sur le lien 'Statistique sur la base et votre activité'")
    public void menuUtilisateurLienStatistique() {
        menuUtilisateur.clickLienStatistique();
    }
    
    @When("MENUU01 Cliquer sur le lien 'logout'")
    public void menuUtilisateurLienLogout() {
        menuUtilisateur.clickLienLogout();
    }

}
