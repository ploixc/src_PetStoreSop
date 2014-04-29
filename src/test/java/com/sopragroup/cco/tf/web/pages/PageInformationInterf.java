package com.sopragroup.cco.tf.web.pages;

import java.util.Map;

public interface PageInformationInterf {
	 public void verifyPage();
	
	 public void verifMessage(String message);
	 
	 
	 public void clickLienSuite();

	 public void sauverValeurNumeroReference(Map<String, String> contextSave, String keyName);
    
}
