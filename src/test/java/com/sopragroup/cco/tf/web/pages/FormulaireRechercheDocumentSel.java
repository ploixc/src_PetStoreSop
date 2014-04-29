package com.sopragroup.cco.tf.web.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class FormulaireRechercheDocumentSel implements FormulaireRechercheDocumentInterf {

	private WebDriver webDriver;
	
    public FormulaireRechercheDocumentSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="Formulaire recherche";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	Assert.assertTrue(bDansLaPageAttendue);    
    }
    	
	public void verifyErrorMessage(String message) {
		WebElement elt = webDriver.findElement(By.className("error"));
		Assert.assertNotNull(elt);
		String value = elt.getText();
		Assert.assertEquals(message, value);
	}
	
	public void cliquerBtRechercher() {
		webDriver.findElement(By.name("btRecherche")).click();
		
	}

	public void cliquerBtAnnuler() {
		webDriver.findElement(By.name("btCancel")).click();
		
	}

	public void saisirNumeroReference(String numeroReference) {
		webDriver.findElement(By.name("tfdRefDocIntId")).clear();
		webDriver.findElement(By.name("tfdRefDocIntId")).sendKeys(numeroReference);		
	}


	public void saisirMotCle(String motCle) {
		webDriver.findElement(By.name("tfdMotCle")).clear();
		webDriver.findElement(By.name("tfdMotCle")).sendKeys(motCle);		
	}

	public void cocherFullText(boolean cocher) {
		webDriver.findElement(By.name("chkAvecFullText")).click();
	}
	
	
	public void saisirVersion(String version) {
		webDriver.findElement(By.name("tfdVersion")).clear();
		webDriver.findElement(By.name("tfdVersion")).sendKeys(version);				
	}

/*
	new Select(driver.findElement(By.name("importance"))).selectByVisibleText("HAUTE IMPORTANCE, DOCUMENT DE REFERENCE");
	new Select(driver.findElement(By.name("etat"))).selectByVisibleText("DOCUMENT VALIDE ET DIFFUSE");
	new Select(driver.findElement(By.name("categorie"))).selectByVisibleText("DOSSIER D'ARCHITECTURE");
	new Select(driver.findElement(By.name("listRepVirtClassementProjet"))).selectByVisibleText("/CLIENTS/SOCGE/");
	new Select(driver.findElement(By.name("listRepVirtClassementTechno"))).selectByVisibleText("/EDITEURS/ORACLE/WEBLOGIC/");
	new Select(driver.findElement(By.name("ordreDateAff"))).selectByVisibleText("PLUS ANCIEN");
*/
	public void choisirCreeModifiePar(String choix) {
		new Select(webDriver.findElement(By.name("lcPersonne"))).selectByVisibleText(choix);
	}

	public void choisirImportance(String choix) {
		new Select(webDriver.findElement(By.name("importance"))).selectByVisibleText(choix);
		
	}
	
	public void choisirEtat(String choix) {
		new Select(webDriver.findElement(By.name("etat"))).selectByVisibleText(choix);
		
	}

	public void choisirCategorie(String choix) {
		new Select(webDriver.findElement(By.name("categorie"))).selectByVisibleText(choix);
		
	}

	public void choisirAxeProjet(String choix) {
		new Select(webDriver.findElement(By.name("listRepVirtClassementProjet"))).selectByVisibleText(choix);
		
	}

	
	public void choisirAxeTechno(String choix) {
		new Select(webDriver.findElement(By.name("listRepVirtClassementTechno"))).selectByVisibleText(choix);	
	}

	public void choisirOrdreAffichage(String choix) {
		new Select(webDriver.findElement(By.name("ordreDateAff"))).selectByVisibleText(choix);
		
	}

	public void cliquerBtReset() {
		webDriver.findElement(By.name("btReset")).click();
	
	}

}