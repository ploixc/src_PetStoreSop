package com.sopragroup.cco.tf.web.steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.Utilitaires;
import com.sopragroup.cco.tf.web.pages.FormulaireModificationDocumentInterf;
import com.sopragroup.cco.tf.web.pages.FormulaireModificationDocumentSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormulaireModificationDocumentStep {


	private static Logger logger = Logger.getLogger(FormulaireModificationDocumentStep.class.getName());

	private FormulaireModificationDocumentInterf formulaireModificationDocument;

	public FormulaireModificationDocumentStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut FormulaireModificationDocumentStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		formulaireModificationDocument = new FormulaireModificationDocumentSel(webDriver);
		logger.debug("Fin   FormulaireModificationDocumentStep prepare @Before");
	}

	   //******* FORMULAIRE MODIFICATION *******************
    @Then("La page 'Formulaire de modification d'un document' s'affiche'")
    	public void surLaPageFormulaireModificationLong() {
    		formulaireModificationDocument.verifyPage();
    }

    @Then("La page 'FMOD01' s'affiche")
    public void surLaPageFormulaireModificationCourt() {
		formulaireModificationDocument.verifyPage();
    }
        
    /**
     * La saisie des champs du formulaire se fait par un tableau avec le nom du champ et la valeur
     * Renseigner un champ avec la valeur vide implique effacer le champ
	   |fieldName|value                                         |
	   |Titre    |Titre du document par cucumber-jvm et Selenium|
	   |Mots clés|des mots cles                                 |
	   |Version  |une version                                   |
	   |Référence|une reference                                 |
*/
    @When("FMOD01 Dans le formulaire saisir les champs suivants :") 
    public void formModifDocumentTableFields(List<FieldNameValue> fields) throws Throwable {
        for (FieldNameValue fieldNameValue : fields) {
        	String name = fieldNameValue.fieldName;
        	String value = fieldNameValue.value;
        	
        	// logger.info("name = <" + name + ">");
        	// logger.info("value = <" + value + ">");
        	name = Utilitaires.noFrenchAccent(name);
        	
        	if (name.equalsIgnoreCase("Titre")) {
        		formulaireModificationDocument.saisirTitre(value);
        	}
        	if (name.equalsIgnoreCase("Mots cles")) {
        		formulaireModificationDocument.saisirMotCle(value);
        	}
        	if (name.equalsIgnoreCase("Resume")) {
        		formulaireModificationDocument.saisirResume(value);
        	}
        	if (name.equalsIgnoreCase("Version")) {
        		formulaireModificationDocument.saisirVersion(value);
        	}
        	if (name.equalsIgnoreCase("Remarque")) {
        		formulaireModificationDocument.saisirRemarque(value);
        	}
        	if (name.equalsIgnoreCase("Reference autre document")) {
        		formulaireModificationDocument.saisirRefAutreDoc(value);
        	}
        	if (name.equalsIgnoreCase("Importance")) {
        		formulaireModificationDocument.choisirImportance(value);
        	}
        	if (name.equalsIgnoreCase("Etat")) {
        		formulaireModificationDocument.choisirEtat(value);
        	}
        	if (name.equalsIgnoreCase("Categorie")) {
        		formulaireModificationDocument.choisirCategorie(value);
        	}
        	if (name.equalsIgnoreCase("Repertoires virtuels Axe Projet")) {
        		formulaireModificationDocument.choisirAxeProjet(value);
        	}
        	if (name.equalsIgnoreCase("Repertoires virtuels Axe Techno")) {
        		formulaireModificationDocument.choisirAxeTechno(value);
        	}
        	if (name.equalsIgnoreCase("Nouvel Axe Techno")) {
        		formulaireModificationDocument.saisirNouvelAxeTechno(value);
        	}
        	if (name.equalsIgnoreCase("Nouvel Axe Projet")) {
        		formulaireModificationDocument.saisirNouvelAxeProjet(value);
        	}
        }
    }
    
    
    @When("FMOD01 Cliquer sur le bouton 'Modifier'")
    public void formModificationDocumentCliquerBtModifier() {
    	formulaireModificationDocument.cliquerBtModifier();
    }
    @When("FMOD01 Cliquer sur le bouton 'Annuler'")
    public void formModificationDocumentCliquerBtAnnuler() {
    	formulaireModificationDocument.cliquerBtAnnuler();
    }
    
    /**
     * Les classes suivantes sont utilisées pour récupérer les valeurs passer sous forme de tableau
     * 
     * @author vdaburon
     *
     */
    
    
 // When converting tables to a List of objects it's usually better to
    // use classes that are only used in test (not in production). This
    // reduces coupling between scenarios and domain and gives you more control.
    public static class FieldNameValue{
        private String fieldName;
        private String value;
    }
}
