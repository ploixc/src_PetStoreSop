package com.sopragroup.cco.tf.web.pages;


import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class AffichageResultatRechercheSel implements AffichageResultatRechercheInterf {
	private static Logger logger = Logger.getLogger(AffichageResultatRechercheSel.class.getName());
	
	private WebDriver webDriver;
	
    public AffichageResultatRechercheSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="Affichage resultat recherche";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    
    }
		
	 public void clickLienDetail() {
		 webDriver.findElement(By.linkText("Detail")).click();
	 }
	 
	 /*
	  * Recherche le lien de numero indique, la premiere valeur = 1
	  * @see com.sopragroup.cco.tf.web.pages.AffichageResultatRechercheInterf#clienLienDetailNum(int)
	  */
	public void clienLienDetailNum(int no) {
		List<WebElement> elements = webDriver.findElements(By
				.linkText("Detail"));
		Assert.assertNotNull(elements);

		int taille = elements.size();
		if (taille >= no && no > 0) {
			logger.info("taille = " + taille + ", no = " + no);
			WebElement ele = elements.get(no - 1);
			ele.click();
		} else {
			throw new ComparisonFailure(
					"Le numero du lien detail est incorrect (> taille ou <= 0)",
					"Taille = " + taille, "no = " + no);
		}
	}

	public void clienLienDetailRandom() {
		List<WebElement> elements =  webDriver.findElements(By.linkText("Detail"));
		Assert.assertNotNull(elements);

		int taille = elements.size();
		int valeurAlea = new Random().nextInt(taille);

		logger.info("taille = " + taille + ", valeurAlea = " + valeurAlea);
		
		WebElement ele = elements.get(valeurAlea);
		ele.click();
	}


	 public void clickLienRetourMenu() {
		 webDriver.findElement(By.linkText("Retour menu")).click();
	 }

	 public void clickLienRetourCritereSelection() {
     	WebElement elt = webDriver.findElement(By.linkText("Retour aux critères de sélection"));
     	org.junit.Assert.assertNotNull(elt);
		elt.click();
	 }
	       
}