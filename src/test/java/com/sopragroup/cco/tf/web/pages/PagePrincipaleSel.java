package com.sopragroup.cco.tf.web.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sopragroup.cco.tf.utils.Constantes;
import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class PagePrincipaleSel implements PagePrincipaleInterf {

	private WebDriver webDriver;
	
    public PagePrincipaleSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifyPage(String stringToFind) {
    	String ContenuPage = SeleniumUtils.GetBody(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(ContenuPage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    }
    
    public BtImage(String Choix) {
    	String Item = "";
    	if Choix.equals("Fish") {
    		Item = "//tr[2]/td/a/img";
    	}
    	WebElement elt = webDriver.findElement(By.xpath(Item));
    	org.junit.Assert.assertNotNull(elt);
    	elt.click();
	}
    void BtTexte(String Choix) {
	String Item = "";
	if Choix.equals("Fish") {
		Item = "//tr[2]/td/a/img";
	}
	WebElement elt = webDriver.findElement(By.xpath(Item));
	org.junit.Assert.assertNotNull(elt);
	elt.click();
    }
	void LienText(String Choix) {
		String Item = "";
		if Choix.equals("Fish") {
			Item = "//tr[2]/td/a/img";
		}
		WebElement elt = webDriver.findElement(By.xpath(Item));
		org.junit.Assert.assertNotNull(elt);
		elt.click();
	}
	    
    
    public void cocherSelonNomPrenom(String nom, String prenom, int etatCocher) {
    	try {
    		int valueCheckUtil = FindCheckAutorisation.valueCheckByNomPrenom(webDriver, nom, prenom);
    		if (valueCheckUtil >= 0) {
    			if (etatCocher == Constantes.CASE_A_COCHER_INVERSER) {
    				webDriver.findElement(By.xpath("(//input[@value='"+valueCheckUtil +"' and @name='chkUtilisateurIntId'])")).click();
    			}
    			
    			if (etatCocher == Constantes.CASE_A_COCHER_COCHER) {
    				WebElement elt = webDriver.findElement(By.xpath("(//input[@value='"+valueCheckUtil +"' and @name='chkUtilisateurIntId'])"));
    				if (!elt.isSelected()) {
    					elt.click();
    				}
    			}
    			
    			if (etatCocher == Constantes.CASE_A_COCHER_DECOCHER) {
    				WebElement elt = webDriver.findElement(By.xpath("(//input[@value='"+valueCheckUtil +"' and @name='chkUtilisateurIntId'])"));
    				if (elt.isSelected()) {
    					elt.click();
    				}
    			}
			}
			else {
				org.junit.Assert.fail("valueCheckUtil < 0 => pas trouve correspondance, nom = " + nom + ", prenom=" + prenom);
			}
    		
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    		Assert.fail("Exception " + ex.toString() + ", pas trouve correspondance, nom = " + nom + ", prenom=" + prenom);
    	}
    }
        
    public void cocherSelonNomGroupe(String nomGroupe, int etatCocher) {
    	try {
    		
    		int valueCheckGroupe = FindCheckAutorisation.valueCheckByNomGroupe(webDriver, nomGroupe);
    		if (valueCheckGroupe >= 0) {
    			if (etatCocher == Constantes.CASE_A_COCHER_INVERSER) {
    				webDriver.findElement(By.xpath("(//input[@value='"+valueCheckGroupe +"' and @name='chkGroupeIntId'])")).click();
    			}
    			
    			if (etatCocher == Constantes.CASE_A_COCHER_COCHER) {
    				WebElement elt = webDriver.findElement(By.xpath("(//input[@value='"+valueCheckGroupe +"' and @name='chkGroupeIntId'])"));
    				if (!elt.isSelected()) {
    					elt.click();
    				}
    			}
    			
    			if (etatCocher == Constantes.CASE_A_COCHER_DECOCHER) {
    				WebElement elt = webDriver.findElement(By.xpath("(//input[@value='"+valueCheckGroupe +"' and @name='chkGroupeIntId'])"));
    				if (elt.isSelected()) {
    					elt.click();
    				}
    			}

			}
			else {
				Assert.fail("valueCheckGroupe < 0 => pas trouve correspondance, nomGroupe = " + nomGroupe);
			}
    		
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    		Assert.fail("Exception " + ex.toString() + ", pas trouve correspondance, nomGroupe = " + nomGroupe);
    	}
    }
	public void cliquerBtValider() {
		webDriver.findElement(By.name("btValider")).click();
		
	}

	public void cliquerBtAnnuler() {
		webDriver.findElement(By.name("btCancel")).click();
		
	}


}