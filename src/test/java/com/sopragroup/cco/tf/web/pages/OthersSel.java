package com.sopragroup.cco.tf.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.SeleniumUtils;

public class OthersSel implements OthersInterf {
	private static Logger logger = Logger.getLogger(OthersSel.class.getName());

	private WebDriver webDriver;
	
    public OthersSel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

	@Override
	public void appelDirect(String action, String noRef) {

		StringBuffer sUrl = new StringBuffer();
		if ("download".equalsIgnoreCase(action)) {
			// http://swinlr4.matt.fr.sopra:8080/gestdocqualif/downloadDocument?refDoc=574454
			sUrl.append("downloadDocument?refDoc=");
			sUrl.append(noRef);
		}

		
		if ("supprimer".equalsIgnoreCase(action)) {
			// http://swinlr4.matt.fr.sopra:8080/gestdocqualif/servletDelete?refDoc=574454
			sUrl.append("servletDelete?refDoc=");
			sUrl.append(noRef);
		}
		
		if ("modifier".equalsIgnoreCase(action)) {
			// http://swinlr4.matt.fr.sopra:8080/gestdocqualif/servletModifRefDoc?refDocIntId=574454
			sUrl.append("servletModifRefDoc?refDocIntId=");
			sUrl.append(noRef);
		}
		
		// test des fonctions d'administration
		if ("Création utilisateur".equalsIgnoreCase(action)) {
			// http://swinlr4.matt.fr.sopra:8080/gestdocqualif/servletCreateUtilisateur
			sUrl.append("servletCreateUtilisateur");
		}

		if ("Création groupe".equalsIgnoreCase(action)) {
			// http://swinlr4.matt.fr.sopra:8080/gestdocqualif/servletGroupe
			sUrl.append("servletGroupe");
		}

		String currentUrl = webDriver.getCurrentUrl();
		String currentUrlSite = "";
		int indexLastFlash = currentUrl.lastIndexOf("/");
		if (indexLastFlash > 0) {
			currentUrlSite = currentUrl.substring(0, indexLastFlash) ;
		}
		String sGo = currentUrlSite + "/"+ sUrl;
		logger.info("go =<" + sGo + ">");
		
    	SeleniumUtils.go(webDriver, sGo);
	}

}
