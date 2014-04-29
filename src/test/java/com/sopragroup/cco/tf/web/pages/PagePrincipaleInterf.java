package com.sopragroup.cco.tf.web.pages;

public interface PagePrincipaleInterf {
	void  verifyPage(String stringToFind);
	void BtImage(String Choix);
	void BtTexte(String Choix);
	void LienText(String Choix);
	void cocherSelonNomPrenom(String nom, String prenom, int etatCocher);
	
	void cocherSelonNomGroupe(String nomGroupe, int etatCocher);
	
	void cliquerBtValider();
	
	void cliquerBtAnnuler();


}
