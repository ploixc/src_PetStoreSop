package com.sopragroup.cco.tf.web.steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sopragroup.cco.tf.utils.Utilitaires;
import com.sopragroup.cco.tf.web.pages.FormulaireCreationDocumentInterf;
import com.sopragroup.cco.tf.web.pages.FormulaireCreationDocumentSel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormulaireCreationDocumentStep {


	private static Logger logger = Logger.getLogger(FormulaireCreationDocumentStep.class.getName());

	private FormulaireCreationDocumentInterf formulaireCreationDocument;

	public FormulaireCreationDocumentStep() {
	}

	/**
	 * Avant chaque scenario
	 */
	@Before
	public void prepare() {
		logger.debug("Debut FormulaireLoginStep prepare @Before");
		WebDriver webDriver = StepGlobalUtils.getWebDriver();
		formulaireCreationDocument = new FormulaireCreationDocumentSel(webDriver);
		logger.debug("Fin   FormulaireLoginStep prepare @Before");
	}

    //************ FORMULAIRE CREATION NOUVEAU DOCUMENT ******************

    @Then("La page 'Formulaire Cr[ée]ation d'un nouveau document' s'affiche")
    public void surLeFormulaireCreationDocumentLong() {
    	formulaireCreationDocument.verifyPage();
    }

    @Then("La page 'FCRE01' s'affiche")
    public void surLeFormulaireCreationDocumentCourt() {
    	formulaireCreationDocument.verifyPage();
    }
    @When("FCRE01 Dans le champ 'Titre' saisir '(.*)'$")
    public void formCreerDocumentSaisirTitre(String titre) {
    	formulaireCreationDocument.saisirTitre(titre);
    }
  
    @When("FCRE01 Dans le champ 'Mots cl[ée]s' saisir '(.*)'$")
    public void formCreerDocumentSaisirMotCle(String motCle) {
    	formulaireCreationDocument.saisirMotCle(motCle);
    }

    @When("FCRE01 Dans le champ 'R[ée]sum[ée]' saisir '(.*)'$")

    public void formCreerDocumentSaisirResume(String resume) {
    	formulaireCreationDocument.saisirResume(resume);
    }

    @When("FCRE01 Dans le champ 'Version' saisir '(.*)'$")

    public void formCreerDocumentSaisirVersion(String version) {
    	formulaireCreationDocument.saisirVersion(version);
    }
    
    @When("FCRE01 Dans le champ 'Remarque' saisir '(.*)'$")
    public void formCreerDocumentSaisirRemarque(String remarque) {
    	formulaireCreationDocument.saisirRemarque(remarque);
    }

    
    @When("FCRE01 Dans le champ 'R[ée]f[ée]rence autre document' saisir '(.*)'$")
    public void formCreerDocumentSaisirReference(String ref) {
    	formulaireCreationDocument.saisirRefAutreDoc(ref);
    }
    
    @When("FCRE01 Dans la liste de choix 'Importance' choisir '(.*)'$")
    public void formCreerDocumentChoisirImportance(String choix) {
    	formulaireCreationDocument.choisirImportance(choix);
    }
    
    @When("FCRE01 Dans la liste de choix 'Etat' choisir '(.*)'$")
    public void formCreerDocumentChoisirEtat(String choix) {
    	formulaireCreationDocument.choisirEtat(choix);
    }
    
    @When("FCRE01 Dans la liste de choix 'Cat[ée]gorie' choisir '(.*)'")
    public void formCreerDocumentChoisirCategorie(String choix) {
    	formulaireCreationDocument.choisirCategorie(choix);
    }
    
    @When("FCRE01 Dans la liste de choix 'R[ée]pertoires virtuels Axe Projet' choisir '(.*)'$")
    public void formCreerDocumentChoisirAxeProjet(String choix) {
    	formulaireCreationDocument.choisirAxeProjet(choix);
    }
    
    @When("FCRE01 Dans la liste de choix 'R[ée]pertoires virtuels Axe Techno' choisir '(.*)'$")
    public void formCreerDocumentChoisirAxeTechno(String choix) {
    	formulaireCreationDocument.choisirAxeTechno(choix);
    }
    
    @When("FCRE01 Dans le champ 'Nouvel Axe Techno' saisir '(.*)'$")
    public void formCreerDocumentSaisirNouvelAxeTechno(String axe) {
    	formulaireCreationDocument.saisirNouvelAxeTechno(axe);
    }
  
    @When("FCRE01 Dans le champ 'Nouvel Axe Projet' saisir '(.*)'$")
    public void formCreerDocumentSaisirNouvelAxeProjet(String axe) {
    	formulaireCreationDocument.saisirNouvelAxeProjet(axe);
    }
    
    /**
     * La saisie des champs du formulaire se fait aussi par un tableau avec le nom du champ et la valeur
     * Renseigner un champ avec la valeur vide implique effacer le champ
	   |fieldName|value                                         |
	   |Titre    |Titre du document par cucumber-jvm et Selenium|
	   |Mots clés|des mots cles                                 |
	   |Version  |une version                                   |
	   |Référence|une reference                                 |
*/
    @When("FCRE01 Dans le formulaire saisir les champs suivants :") 
    public void formCreerDocumentTableFields(List<FieldNameValue> fields) throws Throwable {
        for (FieldNameValue fieldNameValue : fields) {
        	String name = fieldNameValue.fieldName;
        	String value = fieldNameValue.value;
        	
        	// logger.info("name = <" + name + ">");
        	// logger.info("value = <" + value + ">");
        	name = Utilitaires.noFrenchAccent(name);
        	
        	if (name.equalsIgnoreCase("Titre")) {
        		formulaireCreationDocument.saisirTitre(value);
        	}
        	if (name.equalsIgnoreCase("Mots cles")) {
        		formulaireCreationDocument.saisirMotCle(value);
        	}
        	if (name.equalsIgnoreCase("Resume")) {
        		formulaireCreationDocument.saisirResume(value);
        	}
        	if (name.equalsIgnoreCase("Version")) {
        		formulaireCreationDocument.saisirVersion(value);
        	}
        	if (name.equalsIgnoreCase("Remarque")) {
        		formulaireCreationDocument.saisirRemarque(value);
        	}
        	if (name.equalsIgnoreCase("Reference autre document")) {
        		formulaireCreationDocument.saisirRefAutreDoc(value);
        	}
        	if (name.equalsIgnoreCase("Importance")) {
        		formulaireCreationDocument.choisirImportance(value);
        	}
        	if (name.equalsIgnoreCase("Etat")) {
        		formulaireCreationDocument.choisirEtat(value);
        	}
        	if (name.equalsIgnoreCase("Categorie")) {
        		formulaireCreationDocument.choisirCategorie(value);
        	}
        	if (name.equalsIgnoreCase("Repertoires virtuels Axe Projet")) {
        		formulaireCreationDocument.choisirAxeProjet(value);
        	}
        	if (name.equalsIgnoreCase("Repertoires virtuels Axe Techno")) {
        		formulaireCreationDocument.choisirAxeTechno(value);
        	}
        	if (name.equalsIgnoreCase("Nouvel Axe Techno")) {
        		formulaireCreationDocument.saisirNouvelAxeTechno(value);
        	}
        	if (name.equalsIgnoreCase("Nouvel Axe Projet")) {
        		formulaireCreationDocument.saisirNouvelAxeProjet(value);
        	}
        }
    }
    
    
    @When("FCRE01 Cliquer sur le bouton 'Cr[ée]er'")
    public void formCreerDocumentCliquerBtCreer() {
    	formulaireCreationDocument.cliquerBtCreer();
    }
    @When("FCRE01 Cliquer sur le bouton 'Annuler'")
    public void formCreerDocumentCliquerBtAnnuler() {
    	formulaireCreationDocument.cliquerBtAnnuler();
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
