package com.sopragroup.cco.tf.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class FormulaireLoginSel implements FormulaireLoginInterf {
	private WebDriver webDriver;
	
    public FormulaireLoginSel(WebDriver webDriver) {
    	this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="Formulaire de login";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    }
    
	public void saisirLogin(String login) {
		webDriver.findElement(By.name("tfdLogin")).clear();
		webDriver.findElement(By.name("tfdLogin")).sendKeys(login);
	}

	
	public void saisirPassword(String password) {
		webDriver.findElement(By.name("tfdPassword")).clear();
		webDriver.findElement(By.name("tfdPassword")).sendKeys(password);
	}

	
	public void cliquerConnexion() {
		webDriver.findElement(By.name("btValider")).click();
	}

	public void verifyErrorMessage(String message) {
		WebElement elt = webDriver.findElement(By.className("error"));
		org.junit.Assert.assertNotNull(elt);
		String value = elt.getText();
		org.junit.Assert.assertEquals(message, value.replace('\n', ' '));
	}

}