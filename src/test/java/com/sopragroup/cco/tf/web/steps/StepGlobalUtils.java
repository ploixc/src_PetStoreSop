package com.sopragroup.cco.tf.web.steps;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;

/**
 * Le glue code, il fait la liaison entre la description Gherkin et l'appel au métier (ici le pilotage de Selenium)
 * @author vdaburon
 *
 */
public class StepGlobalUtils  {
    
	private static Logger logger = Logger.getLogger(StepGlobalUtils.class.getName());
	
	private static WebDriver webDriver = null;
	    
    // permet de sauvegarder des valeurs dans un contexte, ce contexte a utilisable a l'interieur d'un meme scenario
    
    public static Map <String, String> contextSave = new HashMap<String, String>();
  
    public StepGlobalUtils() {
    }
    
    /**
     * Avant chaque scenario
     */
    @Before
    public void prepare() {
    	logger.info("Debut StepGlobalUtils prepare @Before");
    	
    	webDriver = getWebDriver();
    	
        // a chaque scenario, on efface de contexte.
        contextSave.clear();
        
        logger.info("Fin   StepGlobalUtils prepare @Before");
    }
    
//    Apres chaque scenario
//    @After
//    public void cleanup() {
//    	webDriver.close();
//    }
    
    public static WebDriver getWebDriver() {
    	if (webDriver == null) {
    		//webDriver = WebDriverFactory.get("firefox");
        	//cpx webDriver = new SharedDriver();
    		webDriver = WebDriverFactory.get("ie");
    	}
    	return webDriver;
    }

    public static Map <String, String> getContext() {
    	return contextSave;
    }
    

    


}