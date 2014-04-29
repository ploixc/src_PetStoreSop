package com.sopragroup.cco.tf.web.steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.Constantes;
import com.sopragroup.cco.tf.web.pages.FormulaireChoixAutorisationInterf;
import com.sopragroup.cco.tf.web.pages.FormulaireChoixAutorisationSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormulaireChoixAutorisationStep {


	private static Logger logger = Logger.getLogger(FormulaireChoixAutorisationStep.class.getName());

	private FormulaireChoixAutorisationInterf formulaireChoixAutorisation;

	public FormulaireChoixAutorisationStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut FormulaireChoixAutorisationStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		formulaireChoixAutorisation = new FormulaireChoixAutorisationSel(webDriver);
		logger.debug("Fin   FormulaireChoixAutorisationStep prepare @Before");
	}

	  //************ FORMULAIRE AUTORISATION ******************
	  //FAUTO1 = Creation et FAUT02 = Modification
	  //  mais les traitements sont les identiques
	      
	    @Then("La page 'Formulaire Choix des autorisations' s'affiche")
	    public void surFormulaireChoixAutorisation() {
	    	formulaireChoixAutorisation.verifyPage();
	    }
	    
	    
	    @When("FAUT0[12] Cocher l'utilisateur de nom '(.*)' et de pr[ée]nom '(.*)'$")
	    public void formChoixAutorisationCocherSelonNomPrenom(String nom, String prenom) {
	    	formulaireChoixAutorisation.cocherSelonNomPrenom(nom, prenom, Constantes.CASE_A_COCHER_COCHER);
	    }
	    
	    /**
	     * Les utilisateurs à cocher est indiqué dans un tableau
	   |nom   |prenom   |
	   |nom1  |prenom1  |
	   |nom5  |prenom5  |
	     */
	    @When("FAUT0[12] Dans le formulaire cocher les utilisateurs suivants :")
	    public void formChoixAutorisationCocherTableNomPrenom(List<NomPrenom> fields) throws Throwable { 
	        for (NomPrenom nomPrenom : fields) {
	        	String nom = nomPrenom.nom;
	        	String prenom = nomPrenom.prenom;
	        	
	        	// logger.info("nom = <" + nom + ">");
	        	// logger.info("prenom = <" + prenom + ">");
	        	
	        	formulaireChoixAutorisation.cocherSelonNomPrenom(nom, prenom, Constantes.CASE_A_COCHER_COCHER);
	        }
	        
	    }
	    
	    /**
	     * Les utilisateurs à décocher (déselectionner) est indiqué dans un tableau
	   |nom   |prenom   |
	   |nom1  |prenom1  |
	   |nom5  |prenom5  |
	     */
	    @When("FAUT0[12] Dans le formulaire decocher les utilisateurs suivants :")
	    public void formChoixAutorisationDecocherTableNomPrenom(List<NomPrenom> fields) throws Throwable { 
	        for (NomPrenom nomPrenom : fields) {
	        	String nom = nomPrenom.nom;
	        	String prenom = nomPrenom.prenom;
	        	
	        	// logger.info("nom = <" + nom + ">");
	        	// logger.info("prenom = <" + prenom + ">");
	        	
	        	formulaireChoixAutorisation.cocherSelonNomPrenom(nom, prenom, Constantes.CASE_A_COCHER_DECOCHER);
	        }
	        
	    }

	    @When("FAUT0[12] Cocher le groupe de nom '(.*)'$")
	    public void formChoixAutorisationCocherSelonNomGroupe(String nomGroupe) {
	    	formulaireChoixAutorisation.cocherSelonNomGroupe(nomGroupe, Constantes.CASE_A_COCHER_COCHER);
	    }

	    /*
	   |nomGroupe        |
	   |groupe lib long1 |
	   |groupe lib long12|
	     */
	    @When("FAUT0[12] Dans le formulaire cocher les groupes suivants :")
	    public void formChoixAutorisationCocherTableGroupe(List<NomGroupe> fields) throws Throwable { 
	        for (NomGroupe nomGroupe : fields) {
	        	String sNomGroupe = nomGroupe.nomGroupe;
	        	// logger.info("nomGroupe = <" + sNomGroupe + ">");
	         	formulaireChoixAutorisation.cocherSelonNomGroupe(sNomGroupe, Constantes.CASE_A_COCHER_COCHER);;
	        }
	        
	    }
	    
	    @When("FAUT0[12] Cliquer sur le bouton 'Valider'")
	    public void formChoixAutorisaitonBtValider() {
	    	formulaireChoixAutorisation.cliquerBtValider();
	    }
	    
	    @When("FAUT0[12] Cliquer sur le bouton 'Annuler'")
	    public void formChoixAutorisaitonBtAnnuler() {
	    	formulaireChoixAutorisation.cliquerBtAnnuler();
	    }
	    
	    /**
	     * Les classes suivantes sont utilisées pour récupérer les valeurs passer sous forme de tableau
	     * 
	     * @author vdaburon
	     *
	     */
	    
	    public static class NomPrenom{
	    	private String nom;
	    	private String prenom; 	
	    }
	    
	    public static class NomGroupe{
	    	private String nomGroupe;
	    }
}
