package com.sopragroup.cco.tf.web.pages;

public interface FormulaireLoginInterf {
	void  verifyPage();
	
	void saisirLogin(String login);
	
	void saisirPassword(String password);
	
	void cliquerConnexion();
	
	void verifyErrorMessage(String message);

}
