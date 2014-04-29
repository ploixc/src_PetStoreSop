package com.sopragroup.cco.tf.web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;


public class MenuUtilisateurSel implements MenuUtilisateurInterf {

	private WebDriver webDriver;
	
    public MenuUtilisateurSel(WebDriver webDriver) {
    	this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="Menu";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    }

	public void clickLienNouveauDocument() {
		webDriver.findElement(By.linkText("Nouveau document")).click();
	}


	public void clickLienRecherche() {
		webDriver.findElement(By.linkText("Recherche document")).click();
	}
    
	public void clickLienStatistique() {
		
		webDriver.findElement(By.linkText("Statistique sur la base et votre activité")).click();
	} 
    
	public void clickLienLogout() {
		webDriver.findElement(By.linkText("Logout")).click();
	}
}