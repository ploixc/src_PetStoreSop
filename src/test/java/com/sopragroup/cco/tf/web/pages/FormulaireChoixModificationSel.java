package com.sopragroup.cco.tf.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class FormulaireChoixModificationSel implements FormulaireChoixModificationInterf {
	private WebDriver webDriver;
	
    public FormulaireChoixModificationSel(WebDriver webDriver) {
    	this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="Choix Modification";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    }
    	
	public void cliquerBtModifierCaracteristique() {
		webDriver.findElement(By.name("btModifCaract")).click();
	}
	
	public void cliquerBtNouvelleVersion() {
		webDriver.findElement(By.name("btNouvVersion")).click();
	}
	
	public void cliquerBtAnnuler() {
		webDriver.findElement(By.name("btCancel")).click();
	}

}