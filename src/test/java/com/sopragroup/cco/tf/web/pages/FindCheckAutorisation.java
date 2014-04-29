package com.sopragroup.cco.tf.web.pages;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FindCheckAutorisation {
	static private boolean DEBUG = false;
	static Logger logger = Logger.getLogger(FindCheckAutorisation.class.getName());
	
	
	public static int valueCheckByNomPrenom(WebDriver webDriver , String nomRecherche, String prenomRecherche) throws Exception {
		
		int noTableUtilisateur = 3;

		// recherche des tableaux de type forumline, le 3eme tableau correspond aux utilisateurs
		WebElement tableElement = webDriver.findElement(By.xpath("(//table[@class='forumline'])["+noTableUtilisateur+"]"));
		
		// on recherche les lignes
        List<WebElement> trCollection=tableElement.findElements(By.xpath("tbody/tr"));

        int row_num,col_num;
        row_num=1;
        int valueCheckUtilisateur = -1;
        String sValueCheckUtilisateur = null;
        
        Iterator<WebElement> trIter =  trCollection.iterator();
        boolean encore = true;
        while (trIter.hasNext() && encore) {
        	// on saute les 2 premieres lignes qui ne contiennent pas de case a cocher ni de nom prenom
        	if (row_num <= 2) {
        		WebElement trElement = trIter.next();
        		row_num++;
        		continue;
        	}
        	WebElement trElement = (WebElement) trIter.next();
        
        	// on recherche les colonnes de la ligne courante
        	List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            col_num=1;
            String nomTmp = null;
        	String prenomTmp = null;
            for(WebElement tdElement : td_collection)
            {
            	
            	WebElement eInputCheck = null;
            	
            	if (col_num==1) {
            		// recherche la value du chkUtilisateurIntId, ici 1008
            		// <tr>
            		// <td class="row1" align="center"><input name="chkUtilisateurIntId" value="1008" type="CHECKBOX"></td>
            		// <td class="row1"><span class="gen">nom8</span></td><td class="row1"><span class="gen">prenom8</span></td>
                    // </tr>
            		eInputCheck = tdElement.findElement(By.xpath("input[@name='chkUtilisateurIntId']"));
            		sValueCheckUtilisateur = eInputCheck.getAttribute("value");
            	}           	
            	if (col_num==2) {
            		nomTmp = tdElement.getText().trim();
            	}
            	
            	if (col_num==3) {
            		prenomTmp = tdElement.getText().trim();
            	            	
            		if (nomRecherche.equalsIgnoreCase(nomTmp) && prenomRecherche.equalsIgnoreCase(prenomTmp)) {
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
        	logger.debug("Trouvé, valueCheckUtilisateur = " + valueCheckUtilisateur); 
        }
        else {
        	logger.debug("PAS Trouvé");
        }
		return valueCheckUtilisateur;
	}


	public static int valueCheckByNomGroupe(WebDriver webDriver, String nomGroupeRecherche) throws Exception {
		int noTableGroupe = 2;

		// recherche des tableaux de type forumline, le 2eme tableau correspond aux groupes
		WebElement tableElement = webDriver.findElement(By.xpath("(//table[@class='forumline'])["+noTableGroupe+"]"));
		
		// on recherche les lignes
        List<WebElement> trCollection=tableElement.findElements(By.xpath("tbody/tr"));

        int row_num,col_num;
        row_num=1;
        int valueCheckGroupe = -1;
        String sValueCheckGroupe = null;
        
        Iterator<WebElement> trIter =  trCollection.iterator();
        boolean encore = true;
        while (trIter.hasNext() && encore) {
        	// on saute les 2 premieres lignes qui ne contiennent pas de case a cocher ni de nom de groupe
        	if (row_num <= 2) {
        		WebElement trElement = trIter.next();
        		row_num++;
        		continue;
        	}
        	WebElement trElement = (WebElement) trIter.next();
        
        	// on recherche les colonnes de la ligne courante
        	List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            col_num=1;
            String nomGroupeTmp = null;

            for(WebElement tdElement : td_collection)
            {
            	
            	WebElement eInputCheck = null;
            	
            	if (col_num==1) {
            		// recherche la value du chkGroupeIntId, ici 1201
            		// <tr>
            		// <td class="row1" align="center"> <input name="chkGroupeIntId" value="1201" type="CHECKBOX"></td><td class="row1"><span class="gen"><a href="http://swinlr4.matt.fr.sopra:8080/gestdocqualif/servletAffUtilisateurInGroupe?groupeIntId=1201" target="_blank">groupe lib long0</a></span></td>
            		// </tr>
            		eInputCheck = tdElement.findElement(By.xpath("input[@name='chkGroupeIntId']"));
            		sValueCheckGroupe = eInputCheck.getAttribute("value");
            	}           	
            	if (col_num==2) {
            		nomGroupeTmp = tdElement.getText().trim();
            	            	
            		if (nomGroupeRecherche.equalsIgnoreCase(nomGroupeTmp)) {
            			valueCheckGroupe = Integer.parseInt(sValueCheckGroupe);
            			encore = false;
            		}
            		else {
            			nomGroupeTmp = null;
            		}
            	}
            	col_num++;
            }
            row_num++;
        }

    
        if (!encore) {
        	logger.debug("Trouvé, valueCheckGroupe = " + valueCheckGroupe); 
        }
        else {
        	logger.debug("PAS Trouvé");
        }
		return valueCheckGroupe;
	}	
}
