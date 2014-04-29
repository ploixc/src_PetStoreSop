package com.sopragroup.cco.tf.web.pages;

public interface FormulaireModificationDocumentInterf {
	void verifyPage();
	void verifyErrorMessage(String message);
	
	void saisirTitre(String titre);
	void saisirMotCle(String motCle);
	void saisirResume(String resume);
	void saisirVersion(String version);
	void saisirRemarque(String remarque);
	void saisirRefAutreDoc(String ref);

	void choisirImportance(String choix);
	void choisirEtat(String choix);
	void choisirCategorie(String choix);
	
	void saisirNouvelAxeProjet(String axe);
	
	void choisirAxeProjet(String choix);
	
	void saisirNouvelAxeTechno(String axe);
	void choisirAxeTechno(String choix);
	
	void cliquerBtModifier();
	
	void cliquerBtAnnuler();
	
	
}
