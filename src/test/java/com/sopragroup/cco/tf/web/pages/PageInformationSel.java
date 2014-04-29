package com.sopragroup.cco.tf.web.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class PageInformationSel implements PageInformationInterf {
	private static Logger logger = Logger.getLogger(PageInformationSel.class.getName());


	private WebDriver webDriver;

	public PageInformationSel(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void verifyPage() {
		String stringToFind ="Information";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
		Assert.assertTrue(bDansLaPageAttendue);

	}

	public void verifMessage(String message) {
		WebElement elt = webDriver.findElement(By.className("forumlinkbig"));
		org.junit.Assert.assertNotNull(elt);
		String value = elt.getText();
		org.junit.Assert.assertEquals(message, value.replace('\n', ' '));

	}

	public void clickLienSuite() {
		webDriver.findElement(By.linkText("Suite")).click();
	}

	public void sauverValeurNumeroReference(Map<String, String> contextSave,
			String keyName) {
		String valeurTrouve = rechercheValeurDuTableauNomParam("Numéro de référence");
		contextSave.put(keyName, valeurTrouve);
	}

	String rechercheValeurDuTableauNomParam(String nomParam) {

		String sToFind = nomParam;
		List<WebElement> elts = webDriver.findElements(By.className("gen"));

		boolean encore = true;
		boolean prochain = false;

		String sRetour = "";

		Iterator<WebElement> iter = elts.iterator();
		while (iter.hasNext() && encore) {
			WebElement elt = iter.next();
			String texte = elt.getText();
			logger.debug("texte = " + texte);

			if (prochain == true) {
				sRetour = texte;
				encore = false;
			}
			if (sToFind.equalsIgnoreCase(texte)) {
				prochain = true;
			}
		}

		logger.debug("sRetour = " + sRetour);
		return sRetour;

	}

}