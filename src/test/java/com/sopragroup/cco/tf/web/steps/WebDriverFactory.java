package com.sopragroup.cco.tf.web.steps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sopragroup.cco.tf.utils.Constantes;
import com.sopragroup.cco.tf.utils.Utilitaires;

public class WebDriverFactory {

	private static Logger logger = Logger.getLogger(StepGlobalUtils.class.getName());


	public static final String FIREFOX = "firefox";
	public static final String CHROME = "chrome";
	public static final String HTML_UNIT = "htmlunit";
	public static final String IE = "ie";

	public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String WEBDRIVER_IE_DRIVER = "webdriver.ie.driver";
	
	public static final String DEFAULT_DRIVER = FIREFOX;
	//public static final String DEFAULT_DRIVER = IE;



	public static WebDriver get(){
		WebDriver webDriver = null;
		String browserToUse=null;

		// on recherche la variable d'environnement ou system qui s'appel browser ex : -Dbrowser=firefox
		String browserKey = "browser"; // Ex: -Dbrowser=firefox
		
		browserToUse= Utilitaires.getConfigurationProperty(browserKey, browserKey,Constantes.browser);

		if (browserToUse == null) {
			logger.warn("Aucun navigateur a ete renseigne, on prend la valeur par defaut : " + DEFAULT_DRIVER);
			browserToUse = DEFAULT_DRIVER;
			
		}
		Constantes.browser = browserToUse;
		webDriver = get(browserToUse);

		return webDriver;
	}

	public static WebDriver get(String browserToUse){
		
		WebDriver webDriver = null;

		DesiredCapabilities capabilities = null;
		
		if ("chrome".equalsIgnoreCase(browserToUse)) {
			logger.info("Driver chrome");
			
			LoggingPreferences logs = new LoggingPreferences();
			logs.enable(LogType.DRIVER, Level.SEVERE);
			
			capabilities = DesiredCapabilities.chrome();
		    capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
		    capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
	        HashMap<String, String> chromePreferences = new HashMap<String, String>();
	        chromePreferences.put("profile.password_manager_enabled", "false");
	        capabilities.setCapability("chrome.prefs", chromePreferences);
	        
	        String pathWebdriver = Utilitaires.getConfigurationProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER, Constantes.webdriver_chrome_driver);
			System.setProperty(WEBDRIVER_CHROME_DRIVER, pathWebdriver);
			webDriver = new ChromeDriver(capabilities);
		}

		if ("firefox".equalsIgnoreCase(browserToUse)) {
			logger.info("Driver firefox");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.private.browsing.autostart", true);
			profile.setAcceptUntrustedCertificates(true);
			webDriver = new FirefoxDriver(profile);
		}

		if ("htmlunit".equalsIgnoreCase(browserToUse)) {
			logger.info("Driver htmlunit");
			capabilities = DesiredCapabilities.htmlUnit();
	        capabilities.setCapability("javascriptEnabled", "true");
			webDriver = new HtmlUnitDriver(capabilities);
		}

		if ("ie".equalsIgnoreCase(browserToUse)) {
			logger.info("Driver ie");
			//System.setProperty("webdriver.ie.driver", "D:\\software\\IEDriverServer\\IEDriverServer.exe");
			capabilities = DesiredCapabilities.internetExplorer();
	        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
	        capabilities.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
	        capabilities.setCapability("requireWindowFocus", true);
	        
	        String pathWebdriver = Utilitaires.getConfigurationProperty(WEBDRIVER_IE_DRIVER, WEBDRIVER_IE_DRIVER, Constantes.webdriver_ie_driver);
			System.setProperty(WEBDRIVER_IE_DRIVER, pathWebdriver);
			webDriver = new InternetExplorerDriver(capabilities);
			//webDriver = new InternetExplorerDriver();
		}

		if (webDriver == null) {
			logger.error("Le browser n'est pas correctement initialise avec " + browserToUse + " (valeurs possibles : chrome, firefox, htmlunit, ie)");
		}
		return webDriver;
	}

}
