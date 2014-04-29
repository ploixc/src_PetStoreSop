package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.AffichageResultatRechercheInterf;
import com.sopragroup.cco.tf.web.pages.AffichageResultatRechercheSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AffichageResultatRechercheStep {


	private static Logger logger = Logger.getLogger(AffichageResultatRechercheStep.class.getName());

	private AffichageResultatRechercheInterf affichageResultatRecherche;

	public AffichageResultatRechercheStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut AffichageResultatRechercheStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		affichageResultatRecherche = new AffichageResultatRechercheSel(webDriver);
		logger.debug("Fin   AffichageResultatRechercheStep prepare @Before");
	}

	  //************* AFFICHAGE RESULTAT *****************************
    
    @Then("La page 'Affichage r[ée]sultat recherche' s'affiche")
    public void affichageResultatAfficheLong() {
    	affichageResultatRecherche.verifyPage();
    }
    
    @Then("La page 'AFFRES01' s'affiche")
    public void affichageResultatAfficheCourt() {
    	affichageResultatRecherche.verifyPage();
    }
    
    @When("AFFRES01 Cliquer sur le lien 'D[ée]tail'")
    public void affichageResultatRechercheLienDetail() {
    	affichageResultatRecherche.clickLienDetail();
    }
    
    @When("AFFRES01 Cliquer sur le lien 'D[ée]tail' numero ([0-9]+)")
    public void affichageResultatRechercheLienDetailNumero(int no) {
    	affichageResultatRecherche.clienLienDetailNum(no);
    }

    @When("AFFRES01 Cliquer sur le lien 'D[ée]tail' aleatoirement")
    public void affichageResultatRechercheLienDetailRandom() {
    	affichageResultatRecherche.clienLienDetailRandom();
    }
    
    @When("AFFRES01 Cliquer sur le lien 'Retour aux crit[èe]res de s[ée]lection'")
    public void affichageResultatRechercheRetourFormulaireRecherche() {
    	affichageResultatRecherche.clickLienRetourCritereSelection();
    }

    @When("AFFRES01 Cliquer sur le lien 'Retour menu'")
    public void affichageResultatRechercheRetourMenu() {
    	affichageResultatRecherche.clickLienRetourMenu();
    }
    
}
