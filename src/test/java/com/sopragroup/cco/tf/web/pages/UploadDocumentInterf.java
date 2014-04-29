package com.sopragroup.cco.tf.web.pages;

public interface UploadDocumentInterf {
	void  verifyPage();
	
	void saisirCheminFichier(String fileName);
	
	void cliquerEnvoyer();
	
	void cliquerAnnuler();
	
	void verifyErrorMessage(String message);

}
