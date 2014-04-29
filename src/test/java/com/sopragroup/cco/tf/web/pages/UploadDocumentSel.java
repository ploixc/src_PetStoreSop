package com.sopragroup.cco.tf.web.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class UploadDocumentSel implements UploadDocumentInterf {
	private WebDriver webDriver;
	
    public UploadDocumentSel(WebDriver webDriver) {
    	this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="upload page";
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

	public void saisirCheminFichier(String fileName) {
		webDriver.findElement(By.name("file_to_upload")).sendKeys(fileName);		
	}

	public void cliquerEnvoyer() {
		webDriver.findElement(By.name("btEnvoyer")).click();
	}

	public void cliquerAnnuler() {
		webDriver.findElement(By.name("btAnnuler")).click();
	}
}