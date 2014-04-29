package com.sopragroup.cco.tf.web.pages;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

import com.sopragroup.cco.tf.utils.Utilitaires;
/**
 * @deprecated cette classe est deprecated car elle ne fonctionne que pour Firefox et Chrome et pas IE ou HtmlUnit 
 * par contre elle est beaucoup plus rapide que le nouvelle version (x 40 plus rapide  pour rechercher les valeurs en fin de tableau)<br/>
 * Remplacee par {@link FindCheckAutorisation} <br/>
 * Globalement la recherche par parsing du code source de la page N'est PAS une bonne idee car
 * la methode webDriver.getPageSource() appelee donne un resultat a partir du DOM et le resultat est different
 * selon le navigateur et donc le parsing est complique car l'ordre des champs changent selon le navigateur
 * Il est preferable de rester au niveau DOM par des instructions XPATH (mais nettement plus long)
 * <br/>
 * Ex avec Chrome  : <code>&lt;input type="CHECKBOX" name="chkUtilisateurIntId" value="1103"&gt;</code><br/>
 * Ex avec Firefox : <code>&lt;input name="chkUtilisateurIntId" value="1103" type="CHECKBOX"&gt;</code><br/>
 * 
 * Le parsing du groupe ne fonctionne pas avec le navigateur HtmlUnit car le text entre la balise td est sur une autre ligne a cause un saut de ligne
 * 
 * @author vdaburon
 *
 */

public class ParseCheckAutorisation {
	static private boolean DEBUG = false;
	static Logger logger = Logger.getLogger(ParseCheckAutorisation.class.getName());
	
	public static int numCheckByNomPrenom(String page, String nomRecherche, String prenomRecherche) throws MalformedPatternException, IOException {
		return resCheckByNomPrenom(page, nomRecherche, prenomRecherche, "NUM");
	}
	
	public static int valueCheckByNomPrenom(String page, String nomRecherche, String prenomRecherche) throws MalformedPatternException, IOException {
		return resCheckByNomPrenom(page, nomRecherche, prenomRecherche, "VALUE");
	}

	public static int resCheckByNomPrenom(String page, String nomRecherche, String prenomRecherche, String typeRes) throws MalformedPatternException, IOException {

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


		//String ligne = "              <td class=\"row1\" align=\"center\" ><INPUT TYPE=\"CHECKBOX\" NAME=\"chkUtilisateurIntId\" VALUE=\"1105\"  ></td>" ;
		//String ligne = "              <td class=\"row1\" ><span class=\"gen\">nom105</span></td><td class=\"row1\"><span class=\"gen\">prenom105</span></td>" ;
		String ligne = "";
		boolean encore = true;
		int nbLigne=0;
		int nbCheckBoxUtilisateur = -1;
		String valueCheckBoxUtilisateur ="-1";
		boolean bTrouve = false;
		
		BufferedReader in = new BufferedReader(new CharArrayReader(page.toCharArray()));
		while (encore) {

			ligne = in.readLine();
			
			if (ligne != null) {
				ligne = Utilitaires.noFrenchAccent(ligne);
				if (DEBUG) { 
					System.out.println("ligne (sans accent) = " + ligne);
				}
				nbLigne++;
				
				if ((nbLigne % 10000) == 0) {
					logger.info("Lignes traitee = " + nbLigne);
				}
				
				if (matcher.matches(ligne, patternCheckBoxUtilisateur1) || matcher.matches(ligne, patternCheckBoxUtilisateur2)) {
					MatchResult result = matcher.getMatch();

					String chckUtilId = result.group(1);
					nbCheckBoxUtilisateur++;
					valueCheckBoxUtilisateur = chckUtilId;
					if (DEBUG) {
						System.out.println("chckUtilId=" + chckUtilId);
						System.out.println("nbCheckBoxUtilisateur = " + nbCheckBoxUtilisateur);
					}					
				}
				else {
					if (matcher.matches(ligne, patternNomPrenom)) {
						MatchResult result = matcher.getMatch();

						String nom = result.group(1);
						String prenom = result.group(2);
						
						if (nom.equals(nomRecherche) && prenom.equals(prenomRecherche)) {
							bTrouve = true;
							encore = false;
							if (DEBUG) {
								System.out.println("Trouve la correspondance !");
								System.out.println("nbCheckBoxUtilisateur = " + nbCheckBoxUtilisateur);
								System.out.println("valueCheckBoxUtilisateur = " + valueCheckBoxUtilisateur);
							}
						}
						
						if (DEBUG) {
							System.out.println("nom=" + nom);
							System.out.println("prenom=" + prenom);	
						}
					}
					else {
						if (DEBUG) {
							System.out.println("Ne match pas, ligne =" + ligne);
						}
					}
				}
			}
			else {
				// plus de ligne
				encore = false;
			}
			
		}// while
		if (typeRes.equals("NUM")) {
			return nbCheckBoxUtilisateur;
		}
		else { // la valeur de la checkBox, Ex : 1001 pour <input type="CHECKBOX" value="1001" name="chkUtilisateurIntId" />
			return Integer.parseInt(valueCheckBoxUtilisateur);
		}
	}
	
	public static int valueCheckByNomGroupe(String page, String nomGroupeRecherche) throws MalformedPatternException, IOException {
		return resCheckByNomGroupe(page, nomGroupeRecherche, "VALUE");
	}

	
	public static int resCheckByNomGroupe(String page, String nomGroupeRecherche, String typeRes) throws MalformedPatternException, IOException {
		
		PatternCompiler compiler = new Perl5Compiler();
		// <tr>
		// 	<td align="center" class="row1"> <input type="CHECKBOX" value="1216" name="chkGroupeIntId" /></td><td class="row1"><span class="gen"><a target="_blank" href="/gestdoc/servletAffUtilisateurInGroupe?groupeIntId=1216">groupe lib long15</a></span></td>
		// </tr>

		String sExpCheckBoxGroupeFF = ".*value=\"([0-9]+)\".*chkGroupeIntId\".*$";
		String sExpCheckBoxGroupeCH = ".*chkGroupeIntId\".*value=\"([0-9]+)\".*$";
		String sExpNomGroupe = ".*servletAffUtilisateurInGroupe[?]groupeIntId=[0-9]+.*\">([A-Za-z_ '0-9.,&-]+)</a>.*";

		org.apache.oro.text.regex.Pattern patternCheckBoxGroupe1 = compiler.compile(sExpCheckBoxGroupeFF,Perl5Compiler.SINGLELINE_MASK);
		org.apache.oro.text.regex.Pattern patternCheckBoxGroupe2 = compiler.compile(sExpCheckBoxGroupeCH,Perl5Compiler.SINGLELINE_MASK);
		org.apache.oro.text.regex.Pattern patternNomGroupe = compiler.compile(sExpNomGroupe,Perl5Compiler.SINGLELINE_MASK);
		PatternMatcher matcher  = new Perl5Matcher();


		//String ligne = "              <td class=\"row1\" align=\"center\" ><INPUT TYPE=\"CHECKBOX\" NAME=\"chkUtilisateurIntId\" VALUE=\"1105\"  ></td>" ;
		//String ligne = "              <td class=\"row1\" ><span class=\"gen\">nom105</span></td><td class=\"row1\"><span class=\"gen\">prenom105</span></td>" ;
		String ligne = "";
		boolean encore = true;
		int nbLigne=0;
		int nbCheckBoxGroupe = -1;
		String valueCheckBoxGroupe ="-1";
		boolean bTrouve = false;
		boolean bMatched = false;
		
		BufferedReader in = new BufferedReader(new CharArrayReader(page.toCharArray()));
		while (encore) {

			ligne = in.readLine();
			
			if (ligne != null) {
				ligne = Utilitaires.noFrenchAccent(ligne);
				if (DEBUG) { 
					System.out.println("ligne (sans accent) = " + ligne);
				}
				nbLigne++;
				
//				if (nbLigne > 200) {
//					encore = false;
//				}
				
				if ((nbLigne % 10000) == 0) {
					logger.info("Lignes traitee = " + nbLigne);
				}
								
				bMatched = false;
				
				if (matcher.matches(ligne, patternCheckBoxGroupe1) || matcher.matches(ligne, patternCheckBoxGroupe2)) {
					bMatched = true;
					MatchResult result = matcher.getMatch();

					String chckGroupeId = result.group(1);
					nbCheckBoxGroupe++;
					valueCheckBoxGroupe = chckGroupeId;
					if (DEBUG) {
						System.out.println("chckGroupeId=" + chckGroupeId);
						System.out.println("nbCheckBoxGroupe = " + nbCheckBoxGroupe);
					}					
				}
				if (matcher.matches(ligne, patternNomGroupe)) {
					bMatched = true;
					MatchResult result = matcher.getMatch();

					String nom = result.group(1);
					if (nom.equals(nomGroupeRecherche)) {
						bTrouve = true;
						encore = false;
						if (DEBUG) {
							System.out.println("Trouve la correspondance !");
							System.out.println("nbCheckBoxUtilisateur = " + nbCheckBoxGroupe);
							System.out.println("valueCheckBoxGroupe = " + valueCheckBoxGroupe);
						}
					}
					
					if (DEBUG) {
						System.out.println("nom=" + nom);

					}
				}
				
				if (bMatched == false) {
					if (DEBUG) {
						System.out.println("Ne match pas, ligne =" + ligne);
					}
				}
			}
			else {
				// plus de ligne
				encore = false;
			}
			
		}// while
		
		if (bTrouve == false) {
			valueCheckBoxGroupe = "-1";
		}
		
		if (typeRes.equals("NUM")) {
			return nbCheckBoxGroupe;
		}
		else { // la valeur de la checkBox, Ex : 1001 pour <input type="CHECKBOX" value="1001" name="chkUtilisateurIntId" />
			return Integer.parseInt(valueCheckBoxGroupe);
		}
	}

}
