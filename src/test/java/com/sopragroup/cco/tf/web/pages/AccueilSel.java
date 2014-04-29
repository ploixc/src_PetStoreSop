package com.sopragroup.cco.tf.web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class AccueilSel implements AccueilInterf {
	private WebDriver webDriver;
	
    public AccueilSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    
    public void go(String url) {
    	SeleniumUtils.go(webDriver, url);
    }

    public void verifyPage() {
    	String stringToFind ="PetStore";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    
    }
    
    public void clickSurBtContinuer() {
        	WebElement elt = webDriver.findElement(By.linkText("Enter the Store"));
        	org.junit.Assert.assertNotNull(elt);
        	webDriver.findElement(By.linkText("Enter the Store")).click();
    }
    
}