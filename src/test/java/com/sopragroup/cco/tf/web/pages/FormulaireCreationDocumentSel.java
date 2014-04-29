package com.sopragroup.cco.tf.web.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class FormulaireCreationDocumentSel implements FormulaireCreationDocumentInterf {

private WebDriver webDriver;
	

    public FormulaireCreationDocumentSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="Formulaire Creation d'un nouveau document";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);    
    }
    	
	public void verifyErrorMessage(String message) {
		WebElement elt = webDriver.findElement(By.className("error"));
		Assert.assertNotNull(elt);
		String value = elt.getText();
		Assert.assertEquals(message, value);
	}

	public void saisirTitre(String titre) {
		webDriver.findElement(By.name("tfdTitre")).clear();
		webDriver.findElement(By.name("tfdTitre")).sendKeys(titre);		
		
	}

	public void cliquerBtCreer() {
		webDriver.findElement(By.name("btCreate")).click();
		
		
	}

	public void cliquerBtAnnuler() {
		webDriver.findElement(By.name("btCancel")).click();
		
	}

	public void saisirMotCle(String motCle) {
		webDriver.findElement(By.name("tfdMotCle")).clear();
		webDriver.findElement(By.name("tfdMotCle")).sendKeys(motCle);		
	}
	
	public void saisirResume(String resume) {
		webDriver.findElement(By.name("tfdResume")).clear();
		webDriver.findElement(By.name("tfdResume")).sendKeys(resume);		
	}
	
	
	public void saisirVersion(String version) {
		webDriver.findElement(By.name("tfdVersion")).clear();
		webDriver.findElement(By.name("tfdVersion")).sendKeys(version);				
	}

	public void saisirRemarque(String remarque) {
		webDriver.findElement(By.name("tfdRemarque")).clear();
		webDriver.findElement(By.name("tfdRemarque")).sendKeys(remarque);				
	}

	public void saisirRefAutreDoc(String ref) {
		webDriver.findElement(By.name("tfdRefAutreDoc")).clear();
		webDriver.findElement(By.name("tfdRefAutreDoc")).sendKeys(ref);				
	}

	/*
	new Select(driver.findElement(By.name("importance"))).selectByVisibleText("HAUTE IMPORTANCE, DOCUMENT DE REFERENCE");
	new Select(driver.findElement(By.name("etat"))).selectByVisibleText("DOCUMENT VALIDE ET DIFFUSE");
	new Select(driver.findElement(By.name("categorie"))).selectByVisibleText("DOSSIER D'ARCHITECTURE");
	new Select(driver.findElement(By.name("listRepVirtClassementProjet"))).selectByVisibleText("/CLIENTS/SOCGE/");
	new Select(driver.findElement(By.name("listRepVirtClassementTechno"))).selectByVisibleText("/EDITEURS/ORACLE/WEBLOGIC/");
	new Select(driver.findElement(By.name("ordreDateAff"))).selectByVisibleText("PLUS ANCIEN");
*/

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


	public void saisirNouvelAxeProjet(String projet) {
		webDriver.findElement(By.name("tfdRepVirtClassementProjet")).clear();
		webDriver.findElement(By.name("tfdRepVirtClassementProjet")).sendKeys(projet);		
	}

	public void saisirNouvelAxeTechno(String techno) {
		webDriver.findElement(By.name("tfdRepVirtClassementTechno")).clear();
		webDriver.findElement(By.name("tfdRepVirtClassementTechno")).sendKeys(techno);		
	}

}