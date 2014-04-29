package com.sopragroup.cco.tf.web.pages;

public interface FormulaireRechercheDocumentInterf {
	void verifyPage();
	void verifyErrorMessage(String message);
	
	void saisirNumeroReference(String numeroReference);
	void saisirMotCle(String motCle);
	void cocherFullText(boolean cocher);
	void saisirVersion(String version);
	void choisirCreeModifiePar(String choix);
	void choisirImportance(String choix);
	void choisirEtat(String choix);
	void choisirCategorie(String choix);
	void choisirAxeProjet(String choix);
	void choisirAxeTechno(String choix);
	void choisirOrdreAffichage(String choix);
	
	
	void cliquerBtRechercher();
	
	void cliquerBtAnnuler();
	void cliquerBtReset();
	
}
