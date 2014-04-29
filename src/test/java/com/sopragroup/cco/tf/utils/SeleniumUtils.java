package com.sopragroup.cco.tf.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SeleniumUtils {
	//private
	public static final Logger LOG = Logger.getLogger(SeleniumUtils.class.getName());
	
	public static final int PAS_ATTENTE = 1;
	public static final int ATTENTE_1_SEC = 1000;
	public static final int ATTENTE_2_SEC = 2000;
	
	public static String getTitle1(WebDriver webDriver, int attente) {
		String titrePage = webDriver.getTitle();
		if (Utilitaires.estVide(titrePage) && attente != PAS_ATTENTE) {
			try {
				Thread.sleep(attente);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String title = webDriver.getTitle();
		//LOG.info("title =<" + title +">");
		return title;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getTitle(final WebDriver webDriver, int attente) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
			       .withTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
			       .pollingEvery(1, java.util.concurrent.TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
		
		wait.until(new ExpectedCondition() {
			public Boolean apply(Object webDriver) {
				String titleTmp = ((WebDriver)webDriver).getTitle();
				return new Boolean(Utilitaires.estNonVide(titleTmp));
			}
		}
		);
		
		/*
		(new WebDriverWait(webDriver, attente)).until(
			new ExpectedCondition() {
				public Boolean apply(Object webDriver) {
					String titleTmp = ((WebDriver)webDriver).getTitle();
					return new Boolean(Utilitaires.estNonVide(titleTmp));
				}
			}
			);
		*/
		String title = webDriver.getTitle();
		LOG.info("title = " + title);
		return title;
		
	}
	
	public static String waitAndGetTitle(final WebDriver webDriver, final int attente, final String stringToWait) {
		
		final long debut = System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
			       .withTimeout(attente, java.util.concurrent.TimeUnit.SECONDS)
			       .pollingEvery(500, java.util.concurrent.TimeUnit.MILLISECONDS); //.ignoring(NoSuchElementException.class);
		
		wait.until(new ExpectedCondition() {
			public Boolean apply(Object webDriver) {
				String titleTmp = ((WebDriver)webDriver).getTitle();
				long fin = System.currentTimeMillis();
				// LOG.info("fin - debut =" + (fin - debut));
				if ((fin - debut) >= (attente)) {
					// LOG.info("Return Boolean.TRUE");
					return Boolean.TRUE;
				}
				return new Boolean(Utilitaires.containsTrimIgnoreCase(titleTmp,stringToWait));
			}
		}
		);
			
		/*
		(new WebDriverWait(webDriver, attente)).until(
			new ExpectedCondition() {
				public Boolean apply(Object webDriver) {
					String titleTmp = ((WebDriver)webDriver).getTitle();
					return new Boolean(Utilitaires.containsTrimIgnoreCase(titleTmp,stringToWait));
				}
			}
			);
		*/
		String title = webDriver.getTitle();
		// LOG.info("title = " + title);
		return title;
		
	}
	
	public static String GetBody(final WebDriver webDriver, final int attente, final String stringToWait) {
		
		final long debut = System.currentTimeMillis();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
			       .withTimeout(attente, java.util.concurrent.TimeUnit.SECONDS)
			       .pollingEvery(500, java.util.concurrent.TimeUnit.MILLISECONDS); //.ignoring(NoSuchElementException.class);
		
		wait.until(new ExpectedCondition() {
			public Boolean apply(Object webDriver) {
				String titleTmp = ((WebDriver)webDriver).getTitle();
				long fin = System.currentTimeMillis();
				// LOG.info("fin - debut =" + (fin - debut));
				if ((fin - debut) >= (attente)) {
					// LOG.info("Return Boolean.TRUE");
					return Boolean.TRUE;
				}
				return new Boolean(Utilitaires.containsTrimIgnoreCase(titleTmp,stringToWait));
			}
		}
		);
			
		String title = webDriver.getPageSource();
		 LOG.info("Page = " + title);
		return title;
		
	}
	
	public static void go(WebDriver webDriver, String url) {
    	if (url.startsWith("http") || url.startsWith("HTTP")) {
    		LOG.info("url indiquee dans le step (commence par http)");
    		webDriver.get(url);
    	}
    	else if (url.startsWith("env:") || url.startsWith("ENV:")){
    		LOG.info("recherche de l'url par variable d'environnement (ENV:PARAM)");
    		// like env:HOME_SITE or ENV:ACCUEIL_HOME
    		String sParam = url.substring(4);
    		
    		LOG.info("sParam = " + sParam);
    		String urlEnv = Utilitaires.getConfigurationProperty(sParam,sParam,"localhost");

    		org.junit.Assert.assertNotNull(urlEnv);
    		LOG.info("urlEnv = " + urlEnv);
    		webDriver.get(urlEnv);
    	}
    	else {
    		org.junit.Assert.fail("l'url n'est pas de type http ou ENV:URL_HOME avec la variable apres le env: declare en variable d'environnement avec mv -DURL_HOME=http://site_integ/page ");
    	}
	}
	
	
}