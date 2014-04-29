package com.sopragroup.cco.tf.web.steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.Constantes;
import com.sopragroup.cco.tf.web.pages.PagePrincipaleInterf;
import com.sopragroup.cco.tf.web.pages.PagePrincipaleSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PagePrincipalStep {


	private static Logger logger = Logger.getLogger(PagePrincipalStep.class.getName());

	private PagePrincipaleInterf PagePrincipaleInterf;

	public PagePrincipalStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut PagePrincipaleStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		PagePrincipaleInterf = new PagePrincipaleSel(webDriver);
		logger.debug("Fin   PagePrincipaleStep prepare @Before");
	}

	  //************ FORMULAIRE AUTORISATION ******************
	  //FAUTO1 = Creation et FAUT02 = Modification
	  //  mais les traitements sont les identiques
	      
	    @Then("PRIN01 Acceder au catalogue '(.*)'")
	    public void accescatalogue(String TypeCatalogue) {
	    	if (TypeCatalogue.equals("Poisson")) {
	    	PagePrincipaleInterf.BtImage("Fish");	
	    	PagePrincipaleInterf.verifyPage("Fish");
	    	}
	    }
	    
	    
/*	    @When("FAUT0[12] Cocher l'utilisateur de nom '(.*)' et de pr[ée]nom '(.*)'$")
	    public void formChoixAutorisationCocherSelonNomPrenom(String nom, String prenom) {
	    	PagePrincipaleInterf.cocherSelonNomPrenom(nom, prenom, Constantes.CASE_A_COCHER_COCHER);
	    }
	    
	    /**
	     * Les utilisateurs à cocher est indiqué dans un tableau
	   |nom   |prenom   |
	   |nom1  |prenom1  |
	   |nom5  |prenom5  |
	     */
	/*    @When("FAUT0[12] Dans le formulaire cocher les utilisateurs suivants :")
	    public void formChoixAutorisationCocherTableNomPrenom(List<NomPrenom> fields) throws Throwable { 
	        for (NomPrenom nomPrenom : fields) {
	        	String nom = nomPrenom.nom;
	        	String prenom = nomPrenom.prenom;
	        	
	        	// logger.info("nom = <" + nom + ">");
	        	// logger.info("prenom = <" + prenom + ">");
	        	
	        	PagePrincipaleInterf.cocherSelonNomPrenom(nom, prenom, Constantes.CASE_A_COCHER_COCHER);
	        }
	        
	    }
	    
	    /**
	     * Les utilisateurs à décocher (déselectionner) est indiqué dans un tableau
	   |nom   |prenom   |
	   |nom1  |prenom1  |
	   |nom5  |prenom5  |
	     */
  /*  @When("FAUT0[12] Dans le formulaire decocher les utilisateurs suivants :")
	    public void formChoixAutorisationDecocherTableNomPrenom(List<NomPrenom> fields) throws Throwable { 
	        for (NomPrenom nomPrenom : fields) {
	        	String nom = nomPrenom.nom;
	        	String prenom = nomPrenom.prenom;
	        	
	        	// logger.info("nom = <" + nom + ">");
	        	// logger.info("prenom = <" + prenom + ">");
	        	
	        	PagePrincipaleInterf.cocherSelonNomPrenom(nom, prenom, Constantes.CASE_A_COCHER_DECOCHER);
	        }
	        
	    }

	    @When("FAUT0[12] Cocher le groupe de nom '(.*)'$")
	    public void formChoixAutorisationCocherSelonNomGroupe(String nomGroupe) {
	    	PagePrincipaleInterf.cocherSelonNomGroupe(nomGroupe, Constantes.CASE_A_COCHER_COCHER);
	    }

	    /*
	   |nomGroupe        |
	   |groupe lib long1 |
	   |groupe lib long12|
	     */
/*	    @When("FAUT0[12] Dans le formulaire cocher les groupes suivants :")
	    public void formChoixAutorisationCocherTableGroupe(List<NomGroupe> fields) throws Throwable { 
	        for (NomGroupe nomGroupe : fields) {
	        	String sNomGroupe = nomGroupe.nomGroupe;
	        	// logger.info("nomGroupe = <" + sNomGroupe + ">");
	        	PagePrincipaleInterf.cocherSelonNomGroupe(sNomGroupe, Constantes.CASE_A_COCHER_COCHER);;
	        }
	        
	    }
	    
	    @When("FAUT0[12] Cliquer sur le bouton 'Valider'")
	    public void formChoixAutorisaitonBtValider() {
	    	PagePrincipaleInterf.cliquerBtValider();
	    }
	    
	    @When("FAUT0[12] Cliquer sur le bouton 'Annuler'")
	    public void formChoixAutorisaitonBtAnnuler() {
	    	PagePrincipaleInterf.cliquerBtAnnuler();
	    }
	    
	    /**
	     * Les classes suivantes sont utilisées pour récupérer les valeurs passer sous forme de tableau
	     * 
	     * @author vdaburon
	     *
	     */
	    
/*	    public static class NomPrenom{
	    	private String nom;
	    	private String prenom; 	
	    }
	    
	    public static class NomGroupe{
	    	private String nomGroupe;
	    }
*/
}
