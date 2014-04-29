package com.sopragroup.cco.tf.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class PageStatistiqueSel implements PageStatistiqueInterf {

	static Logger logger = Logger.getLogger(AccueilSel.class.getName());
	
	private WebDriver webDriver;
	
    public PageStatistiqueSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
	
	public void lienRetourMenu() {
		webDriver.findElement(By.linkText("Retour")).click();

	}

	
	public void verifyPage() {
		String stringToFind ="Affichage statistique";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    }

}
