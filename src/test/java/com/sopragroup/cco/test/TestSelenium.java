package com.sopragroup.cco.test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sopragroup.cco.tf.utils.Constantes;
import com.sopragroup.cco.tf.utils.Utilitaires;
import com.sopragroup.cco.tf.web.pages.FindCheckAutorisation;
import com.sopragroup.cco.tf.web.pages.ParseCheckAutorisation;
import com.sopragroup.cco.tf.web.steps.WebDriverFactory;

public class TestSelenium {
	private static Logger LOG = Logger.getLogger(TestSelenium.class.getName());

	public static void main(String[] args) throws MalformedPatternException {
		Constantes.initialiseEnv();
		System.out.println("Après Constantes.initialiseEnv");
		BasicConfigurator.configure();
		//PropertyConfigurator.configure("properties/log4j.properties");
		LOG.getRootLogger().setLevel(Level.ERROR);
		
		Logger logTmp = Logger.getLogger("com.sopragroup");
		logTmp.setLevel(Level.INFO);
		logTmp.setAdditivity(true);

		try {
			// testPageInfo();
			// testPageAutorisationXpath();
			testPageAutorisationXpathBbyLib();
			// testPageAutorisation();
			// testRegEx();
			// testGetRawSourceHtml();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void testGetRawSourceHtml() {
/*		WebDriver webDriver;
		
        webDriver = WebDriverFactory.get("htmlunit"); 
		String url;

//		url = "file://D:/usr/vdaburon/dev/workspace3.7/gestdoctf/tmp/Formulaire Choix des autorisations.htm";
//		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		webDriver.get(url);
		
		//webDriver.executeScript("var f = document.createElement('div').appendChild(arguments[0].cloneNode(true)); return f.parentNode.innerHTML", element);
//		LOG.info("Recherche du code source de la page par javascript (par le DOM => pas le code brut retourné par le serveur)");
//		String sRawSource = (String) ((JavascriptExecutor)webDriver).executeScript("var f = document.forms[0].outerHTML; return f");
		//LOG.info("sRawSource = " + sRawSource);
		
		// la meme chose avec la methode du driver mais qui donne la vue a partir du DOM qui change selon le navigateur
		// Ex avec Chrome  : <input type="CHECKBOX" name="chkUtilisateurIntId" value="1103">
		// Ex avec Firefox : <input name="chkUtilisateurIntId" value="1103" type="CHECKBOX">
		
		sRawSource = webDriver.getPageSource();
		webDriver.quit();
*/	}
	

	public static void testPageInfo() {
/*
		WebDriver webDriver;
		webDriver = new FirefoxDriver();
		String url;
		String sToFind = "Numéro de Référence";

		url = "file://D:/usr/vdaburon/dev/workspace3.7/gestdoctf/tmp/uploadDocument.htm";
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.get(url);

		List <WebElement> elts = webDriver.findElements(By.className("gen"));

		boolean encore = true;
		boolean prochain = false;
		String sRetour = "";

		Iterator<WebElement> iter = elts.iterator();
		while (iter.hasNext() && encore) {
			WebElement elt = iter.next();
			String texte = elt.getText();
			System.out.println("texte = " + texte);

			if (prochain == true) {
				sRetour = texte;
				encore = false;
			}
			if (sToFind.equalsIgnoreCase(texte)) {
				prochain = true;
			}
		}

		System.out.println("sRetour = " + sRetour);
		webDriver.quit();
*/	}

	public static void testPageAutorisationXpath() throws MalformedPatternException, IOException {
/*
		WebDriver webDriver;
		webDriver = WebDriverFactory.get("firefox");

		String url;
		String url2;

		url2 = "file://D:/usr/vdaburon/dev/workspace3.7/gestdoctf/tmp/Formulaire Choix des autorisations.htm";
		//url = "http://localhost:8080/Formulaire%20Choix%20des%20autorisations.htm";
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//webDriver.get(url);

		webDriver.get(url2);
		String nom = "nom16";
		String prenom = "prenom16";
		
		// http://stackoverflow.com/questions/6198947/how-to-get-text-from-each-cell-of-an-html-table
		
		// http://stackoverflow.com/questions/8187772/selenium-checkbox-attribute-checked
		
		// /html/body/table/tbody/tr/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table
		
		int noTableUtilisateur = 3;
		
		WebElement tableElement = webDriver.findElement(By.xpath("(//table[@class='forumline'])["+noTableUtilisateur+"]"));
		
        // WebElement tableElement = webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table"));
        //List<WebElement> tr_collection= webDriver.findElements(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/table/tbody/tr"));
        List<WebElement> trCollection=tableElement.findElements(By.xpath("tbody/tr"));

        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+trCollection.size());
        int row_num,col_num;
        row_num=1;
        int valueCheckUtilisateur = -1;
        String sValueCheckUtilisateur = null;
        Iterator<WebElement> trIter =  trCollection.iterator();
        boolean encore = true;
        while (trIter.hasNext() && encore) {
        	// on saute les 2 premieres lignes qui ne contiennent pas de case a coacher
        	if (row_num <= 2) {
        		WebElement trElement = trIter.next();
        		row_num++;
        		continue;
        	}
        	WebElement trElement = trIter.next();
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            //System.out.println("NUMBER OF COLUMNS="+td_collection.size());
            col_num=1;
            String nomTmp = null;
        	String prenomTmp = null;
            for(WebElement tdElement : td_collection)
            {
            	
            	WebElement eInputCheck = null;
            	
            	if (col_num==1) {
            		System.out.println("tdElement.getTagName() = " + tdElement.getTagName());
            		// recherche la value du chkUtilisateurIntId, ici 1008
            		// <tr>
            		// <td class="row1" align="center"><input name="chkUtilisateurIntId" value="1008" type="CHECKBOX"></td>
            		// <td class="row1"><span class="gen">nom8</span></td><td class="row1"><span class="gen">prenom8</span></td>
                    // </tr>
            		eInputCheck = tdElement.findElement(By.xpath("input[@name='chkUtilisateurIntId']"));
            		sValueCheckUtilisateur = eInputCheck.getAttribute("value");
            		if (eInputCheck != null) {
            			System.out.println("sValueCheckUtilisateur = " + sValueCheckUtilisateur);
            		}
            	}
            	
            	if (col_num==2) {
            		nomTmp = tdElement.getText().trim();
            	}
            	
            	if (col_num==3) {
            		prenomTmp = tdElement.getText().trim();
            	            	
            		if (nom.equalsIgnoreCase(nomTmp) && prenom.equalsIgnoreCase(prenomTmp)) {
            			valueCheckUtilisateur = Integer.parseInt(sValueCheckUtilisateur);
            			encore = false;
            		}
            		else {
            			nomTmp = null;
            			prenomTmp = null;
            		}
            	}
            	col_num++;
            }
            row_num++;
        }

    
        if (!encore) {
        	System.out.println("Trouvé, valueCheckUtilisateur = " + valueCheckUtilisateur); 
        }
        else {
        	System.out.println("PAS Trouvé");
        }
        
		webDriver.quit();
*/	}

	public static void testPageAutorisationXpathBbyLib() throws Exception {
/*
		WebDriver webDriver;
		webDriver = WebDriverFactory.get("firefox");

		String url;
		String url2;

		url = "file://D:/usr/vdaburon/dev/workspace3.7/gestdoctf/tmp/Formulaire Choix des autorisations.htm";
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//webDriver.get(url);

		webDriver.get(url);
		String nom = "nom16";
		String prenom = "prenom16";

		int valueUtilisateur = FindCheckAutorisation.valueCheckByNomPrenom(webDriver, nom, prenom);
		
		System.out.println("valueUtilisateur = " + valueUtilisateur);
		
		String nomGroupeRecherche = "groupe lib long8";
		int valueGroupe = FindCheckAutorisation.valueCheckByNomGroupe(webDriver, nomGroupeRecherche);
		
		System.out.println("valueGroupe = " + valueGroupe);

	  
		webDriver.quit();
*/	}
	
	public static void testPageAutorisation() throws MalformedPatternException, IOException {
/*
		WebDriver webDriver;
		webDriver = WebDriverFactory.get("chrome");

		String url;
		String url2;

		// url2 = "file://D:/usr/vdaburon/dev/workspace3.7/gestdoctf/tmp/Formulaire Choix des autorisations.htm";
		url = "http://localhost:8080/Formulaire%20Choix%20des%20autorisations.htm";
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.get(url);

		//webDriver.get(url2);
		String nom = "nom16";
		String prenom = "prenom16";

		//int valueCheckUtil = ParseCheckAutorisation.valueCheckByNomPrenom(webDriver.getPageSource(), nom, prenom);
		// System.out.println("valueCheckUtil = " + valueCheckUtil);

		String nomGroupe = "groupe lib long1";
		int valueCheckGroupe = ParseCheckAutorisation.valueCheckByNomGroupe(webDriver.getPageSource(), nomGroupe);
		System.out.println("valueCheckGroupe = " + valueCheckGroupe);

		webDriver.quit();
*/	}

	public static void testRegEx() throws MalformedPatternException {
		PatternCompiler compiler = new Perl5Compiler();

		// <tr>
		//              <td class="row1" align="center" ><INPUT TYPE="CHECKBOX" value="1105" name="chkUtilisateurIntId"  /></td>
		//              <td class="row1" ><span class="gen">nom105</span></td><td class="row1"><span class="gen">prenom105</span></td>
		// </tr>
		String sExpCheckBoxUtilisateurFF = ".*value=\"([0-9]+)\".*chkUtilisateurIntId\".*$";

		// Pour Chrome l'ordre change entre la value et la check box 
		//             <td class="row1" align="center"><input type="CHECKBOX" name="chkUtilisateurIntId" value="1010"></td>
		// <td class="row1" align="center"><input type="CHECKBOX" name="chkUtilisateurIntId" value="1097"></td>
		String sExpCheckBoxUtilisateurCH = ".*chkUtilisateurIntId\".*value=\"([0-9]+)\".*$";
		String sExpNomPrenom = ".*<td class=\"row1\"><span class=\"gen\">([A-Za-z_ '0-9.,&-]+)</span></td><td class=\"row1\"><span class=\"gen\">([A-Za-z_ 0-9]+)</span></td>.*";

		org.apache.oro.text.regex.Pattern patternCheckBoxUtilisateur1 = compiler.compile(sExpCheckBoxUtilisateurFF,Perl5Compiler.SINGLELINE_MASK);
		org.apache.oro.text.regex.Pattern patternCheckBoxUtilisateur2 = compiler.compile(sExpCheckBoxUtilisateurCH,Perl5Compiler.SINGLELINE_MASK);
		org.apache.oro.text.regex.Pattern patternNomPrenom = compiler.compile(sExpNomPrenom,Perl5Compiler.SINGLELINE_MASK);
		PatternMatcher matcher  = new Perl5Matcher();

		String lineToTest = "<td class=\"row1\" align=\"center\"><input type=\"CHECKBOX\" name=\"chkUtilisateurIntId\" value=\"1097\"></td>";
		String ligne = Utilitaires.noFrenchAccent(lineToTest);
		System.out.println("ligne (sans accent) = " + ligne);
		if (matcher.matches(ligne, patternCheckBoxUtilisateur1) || matcher.matches(ligne, patternCheckBoxUtilisateur2)) {
			MatchResult result = matcher.getMatch();

			String chckUtilId = result.group(1);
			System.out.println("chckUtilId=" + chckUtilId);
		}
		else {
			if (matcher.matches(ligne, patternNomPrenom)) {
				MatchResult result = matcher.getMatch();

				String nom = result.group(1);
				String prenom = result.group(2);

				System.out.println("nom=" + nom);
				System.out.println("prenom=" + prenom);	
			}
			else {
				System.out.println("Ne match pas, ligne =" + ligne);
			}
		}
	}

}
