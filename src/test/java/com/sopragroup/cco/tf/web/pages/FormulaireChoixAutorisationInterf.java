package com.sopragroup.cco.tf.web.pages;

public interface FormulaireChoixAutorisationInterf {
	void  verifyPage();
	
	void cocherSelonNomPrenom(String nom, String prenom, int etatCocher);
	
	void cocherSelonNomGroupe(String nomGroupe, int etatCocher);
	
	void cliquerBtValider();
	
	void cliquerBtAnnuler();


}
