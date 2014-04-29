package com.sopragroup.cco.tf.web.pages;



import com.thoughtworks.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class AccueilForge implements AccueilInterf {
	private WebDriver webDriver;
	
    public AccueilForge(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    
    public void go(String url) {
    	SeleniumUtils.go(webDriver, url);
    }

    public void verifyPage01(String stringToFind) {
    	String stringToSearch ="//a[contains(text(),'"+stringToFind+"')]";
    	webDriver.findElement(By.xpath(stringToSearch)).click();
    	//SeleniumUtils.LOG.info(example.getElementName());
    			//System.out.println(example.getElementName());
    	//boolean bDansLaPageAttendue=selenium.isTextPresent("String stringToFind");
    	//String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	/*boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	if (bDansLaPageAttendue)
    		SeleniumUtils.LOG.info("verifyPage01 - Return Boolean.TRUE");
    	else 
    		SeleniumUtils.LOG.info("verifyPage01 -Return Boolean.FALSE");*/
    	//org.junit.Assert.assertTrue(bDansLaPageAttendue);
    }

    public void verifyPage() {
    	String stringToFind ="LE MANS";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    }
 
    
    public void clickSurLien(String Link) {
    	//WebElement elt = 
    			webDriver.findElement(By.linkText(Link)).click();
    	//org.junit.Assert.assertNotNull(elt);
    }
    
    public void clickSurBtContinuer() {
        	WebElement elt = webDriver.findElement(By.name("login"));
        	org.junit.Assert.assertNotNull(elt);
        	webDriver.findElement(By.name("login")).click();
    }
    
}
