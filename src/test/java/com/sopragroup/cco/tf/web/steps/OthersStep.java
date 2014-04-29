package com.sopragroup.cco.tf.web.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.web.pages.OthersInterf;
import com.sopragroup.cco.tf.web.pages.OthersSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class OthersStep {


	private static Logger logger = Logger.getLogger(OthersStep.class.getName());

	private OthersInterf others;

	public OthersStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut OthersStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		others = new OthersSel(webDriver);
		logger.debug("Fin   OthersStep prepare @Before");
	}


	  //******* APPEL DIRECT ******************* 
	  @When("Appel direct '(.*)' le document de numéro dans la variable '(.*)'") 
	  public void appelDirect(String action, String nomVariable) {
		  String numeroReference = StepGlobalUtils.getContext().get(nomVariable);
		  others.appelDirect(action, numeroReference);
	  }
	  
	  @When("Appel direct admin '(.*)'")
	  public void appelDirect(String action) {
		  others.appelDirect(action,"");
	  }
}
