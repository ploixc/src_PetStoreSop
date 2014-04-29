package com.sopragroup.cco.tf.web.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.SeleniumUtils;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class DetailDocumentSel implements DetailDocumentInterf {
	private WebDriver webDriver;
	
    public DetailDocumentSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void verifyPage() {
    	String stringToFind ="Detail d'un document";
    	String titrePage = SeleniumUtils.waitAndGetTitle(webDriver, SeleniumUtils.ATTENTE_2_SEC, stringToFind);
    	boolean bDansLaPageAttendue = Utilitaires.containsTrimIgnoreCase(titrePage,stringToFind);
    	org.junit.Assert.assertTrue(bDansLaPageAttendue);
    
    }
		
			
	 public void clickLienSuivant() {
		 webDriver.findElement(By.linkText("Suivant")).click();
	 }

	 public void clickLienPrecedent() {
		 webDriver.findElement(By.linkText("Précédent")).click();
	 }
	 
	 public void clickLienRetourListe() {
		 webDriver.findElement(By.linkText("Retour à la liste")).click();
	 }

	 public void clickLienDownload() {
		 webDriver.findElement(By.linkText("Downloader document")).click();
	 }
	 
	 public void clickLienModifier() {
		 webDriver.findElement(By.linkText("Modifier document")).click();
	 }
	 
	 public void clickLienSupprimer() {
		 webDriver.findElement(By.linkText("Effacer document")).click();
	 }
	 
	 public boolean existeLienSuivant() {
		 boolean bExiste = false;
		 webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		 
		 try {
			 webDriver.findElement(By.linkText("Suivant"));
		    bExiste = true;
		 } catch (NoSuchElementException e) {
			 bExiste = false;
		 }
		 webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 return bExiste;
	 }
	 
	 public boolean existeLienPrecedent() {
		 boolean bExiste = false;
		 webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		 
		 try {
			 webDriver.findElement(By.linkText("Précédent"));
		    bExiste = true;
		 } catch (NoSuchElementException e) {
			 bExiste = false;
		 }
		 webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 System.out.println("Le lien existe ? = " + bExiste);
		 return bExiste;
	 }
} 