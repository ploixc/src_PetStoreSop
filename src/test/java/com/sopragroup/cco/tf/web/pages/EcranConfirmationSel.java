package com.sopragroup.cco.tf.web.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class EcranConfirmationSel implements EcranConfirmationInterf {
	static Logger logger = Logger.getLogger(EcranConfirmationSel.class.getName());
	
	private WebDriver webDriver;
	
    public EcranConfirmationSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="Ecran de confirmation";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    }
    
    public void clickBtOui() {
        	webDriver.findElement(By.name("btOui")).click();
    }
    
    public void clickBtNon() {
    	webDriver.findElement(By.name("btNon")).click();
    }
}