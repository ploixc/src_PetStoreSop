package com.sopragroup.cco.tf.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sopragroup.cco.tf.utils.SeleniumUtils;

public class AppelDirectSel implements AppelDirectInterf {
	private WebDriver webDriver;
	
	public AppelDirectSel(WebDriver webDriver) {
    	this.webDriver = webDriver;
    }

	/** Les appels directs sans les droits retournent des messages d'avertissement
	http://localhost:8080/gestdoc/downloadDocument?refDoc=506702
  	Pas le droit de downloader le document
  
	http://localhost:8080/gestdoc/servletDelete?refDoc=506702
	Pas le droit de supprimer le document
  
	http://localhost:8080/gestdoc/servletModifRefDoc?refDocIntId=506702
  	Pas le droit de modifier le document
	 */

	public void appelDirectAction(String action, String noRef) {
		webDriver.getCurrentUrl();
		if ("modifier".equalsIgnoreCase(action)) {
			
		}
		
		if ("download".equalsIgnoreCase(action)) {
			
		}
		
		if ("supprimer".equalsIgnoreCase(action)) {
			
		}
    }
}
	
