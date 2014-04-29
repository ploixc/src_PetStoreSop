package com.sopragroup.cco.tf.utils;

import org.apache.commons.lang3.StringUtils;



public class Utilitaires {
	
	
	public static boolean containsTrimIgnoreCase(String toTrim, String toCompare) {
		String inter = StringUtils.trimToEmpty(toTrim);
		return StringUtils.containsIgnoreCase(inter, toCompare);
	}
	
	/** Cette méthode retourne faux si la chaine passée en paramètre est vide, vrai sinon.
	@param string la chaine que l'on veut tester
	@return true si elle n'est pas null ni vide ni remplis de blancs, false sinon*/
	public static boolean estNonVide(String string)	{
		if (string != null && !(string.trim()).equals(""))	{
			return true;
		}
		else
			return false;
	}

	/** Cette méthode retourne faux si la chaine passée en paramètre est vide, vrai sinon.
	@param string La chaîne que l'on veut tester
	@return true si la chaîne est null, vide ou bien remplis de blancs, false sinon*/
	public static boolean estVide(String string)	{
		if (string == null) {
			return true;
		}
		if ((string.trim()).equals(""))	{
			return true;
		}
		return false;
	}

	/** Remplace les lettres en lettre majuscule, en éliminant les accents
	@param in la chaîne à traiter
	@return La chaîne équivalente mais en majuscule*/
	public static String stringUpperCase(String in) {
		char[] bin=in.toCharArray();
		char[] bout=new char[bin.length];
		char car;
		int iout=0;
		for(int i=0;i<bin.length;i++) {
			car = bin[i];
			switch (car) {
				case 'à': bout[iout++]='A'; break;
				case 'â': bout[iout++]='A'; break;
				case 'ä': bout[iout++]='A'; break;
				case 'é': bout[iout++]='E'; break;
				case 'è': bout[iout++]='E'; break;
				case 'ê': bout[iout++]='E'; break;
				case 'ë': bout[iout++]='E'; break;
				case 'î': bout[iout++]='I'; break;
				case 'ï': bout[iout++]='I'; break;
				case 'ô': bout[iout++]='O'; break;
				case 'ö': bout[iout++]='O'; break;
				case 'ù': bout[iout++]='U'; break;
				case 'û': bout[iout++]='U'; break;
				case 'ü': bout[iout++]='U'; break;
				case 'ç': bout[iout++]='C'; break;
				case 'ÿ': bout[iout++]='Y'; break;

				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'u':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z': bout[iout++]=(char)(car-32); break;

				default : bout[iout++]=car;
			}
		}
		return new String(bout,0,iout);
	}

	
	/** Transforme une chaîne de caractère en chaînes lisible par un navigateur web
	(remplacement de certains signe comme & par &amp;amp;)
	@param in la chaîne à traiter
	@return la chaîne traitée
	*/
	public static String textToHtml(String in) {
		char[] bin=in.toCharArray();
		StringBuffer bout = new StringBuffer(bin.length);
		char car;
		for(int i=0;i<bin.length;i++) {
			switch (car=bin[i]) {
				case '\"': bout.append("&quot;"); break;
				case '&': bout.append("&amp;"); break;
				case '\'': bout.append("&#39;"); break;
				case '<': bout.append("&lt;"); break;
				case '>': bout.append("&gt;"); break;
				case '^': bout.append("&circ;"); break;
				case '~': bout.append("&tilde;"); break;
				case '€': bout.append("&euro;"); break;
				case 'À': bout.append("&Aegrave;"); break;
				case 'Á': bout.append("&Aacute;"); break;
				case 'Â': bout.append("&Acirc;"); break;
            
				case 'Ä': bout.append("&Auml;"); break;
				case 'Ç': bout.append("&Ccedil;"); break;
				case 'È': bout.append("&Eegrave;"); break;
				case 'Ê': bout.append("&Ecirc;"); break;
				case 'Ë': bout.append("&Euml;"); break;
        
				case 'Í': bout.append("&Iacute;"); break;
				case 'Ó': bout.append("&Oacute;"); break;
				case 'Ô': bout.append("&Ocirc;"); break;
          
				case 'Ö': bout.append("&Ouml;"); break;
				case 'Ù': bout.append("&Uegrave;"); break;
				case 'Ú': bout.append("&Uacute;"); break;
				case 'Û': bout.append("&Ucirc;"); break;
				case 'Ü': bout.append("&Uuml;"); break;
				case 'Ý': bout.append("&Yacute;"); break;
				case 'ß': bout.append("&szlig;"); break;
				case 'à': bout.append("&agrave;"); break;
				case 'â': bout.append("&acirc;"); break;
         
				case 'ä': bout.append("&auml;"); break;
         
				case 'ç': bout.append("&ccedil;"); break;
				case 'è': bout.append("&egrave;"); break;
				case 'é': bout.append("&eacute;"); break;
				case 'ê': bout.append("&ecirc;"); break;
				case 'ë': bout.append("&euml;"); break;
				case 'î': bout.append("&icirc;"); break;
				case 'ï': bout.append("&iuml;"); break;
				case 'ó': bout.append("&oacute;"); break;
				case 'ô': bout.append("&ocirc;"); break;
				case 'ö': bout.append("&ouml;"); break;
				case 'ù': bout.append("&ugrave;"); break;
				case 'ú': bout.append("&uacute;"); break;
				case 'û': bout.append("&ucirc;"); break;
				case 'ü': bout.append("&uuml;"); break;

				default : bout.append(car);
			}
		}
		return bout.toString();
	}

	/** Remplace les accents par l'equivalent minuscule francais
	* @param in la chaîne à traiter
	* @return La chaîne équivalente avec les accents remplaces 
	*/
	public static String noFrenchAccent(String in) {
		char[] bin=in.toCharArray();
		char[] bout=new char[bin.length];
		char car;
		int iout=0;
		for(int i=0;i<bin.length;i++) {
			switch (car=bin[i]) {
				case 'à': bout[iout++]='a'; break;
				case 'â': bout[iout++]='a'; break;
				case 'ä': bout[iout++]='a'; break;
				case 'é': bout[iout++]='e'; break;
				case 'è': bout[iout++]='e'; break;
				case 'ê': bout[iout++]='e'; break;
				case 'ë': bout[iout++]='e'; break;
				case 'î': bout[iout++]='i'; break;
				case 'ï': bout[iout++]='i'; break;
				case 'ô': bout[iout++]='o'; break;
				case 'ö': bout[iout++]='o'; break;
				case 'ù': bout[iout++]='u'; break;
				case 'û': bout[iout++]='u'; break;
				case 'ü': bout[iout++]='u'; break;
				case 'ç': bout[iout++]='c'; break;
				case 'ÿ': bout[iout++]='y'; break;

				case '\u00C0' : bout[iout++]='a'; break; // A majuscule accent grave
				case '\u00C1' : bout[iout++]='a'; break;
				case '\u00C2' : bout[iout++]='a'; break;
				case '\u00C3' : bout[iout++]='a'; break;
				case '\u00C4' : bout[iout++]='a'; break;
				case '\u00C5' : bout[iout++]='a'; break;
				case '\u00C6' : bout[iout++]='a'; break;
				
				case '\u00C7' : bout[iout++]='c'; break;
				
				case '\u00C8' : bout[iout++]='e'; break;
				case '\u00C9' : bout[iout++]='e'; break;
				case '\u00CA' : bout[iout++]='e'; break;
				case '\u00CB' : bout[iout++]='e'; break;
				
				
				case '\u00CC' : bout[iout++]='i'; break;
				case '\u00CD' : bout[iout++]='i'; break;
				case '\u00CE' : bout[iout++]='i'; break;
				case '\u00CF' : bout[iout++]='i'; break;
				
				case '\u00D2' : bout[iout++]='o'; break;
				case '\u00D3' : bout[iout++]='o'; break;
				case '\u00D4' : bout[iout++]='o'; break;
				case '\u00D5' : bout[iout++]='o'; break;
				case '\u00D6' : bout[iout++]='o'; break;
				
				
				case '\u00D9' : bout[iout++]='u'; break;
				case '\u00DA' : bout[iout++]='u'; break;
				case '\u00DB' : bout[iout++]='u'; break;
				case '\u00DC' : bout[iout++]='u'; break;
				
				case '\u00DD' : bout[iout++]='y'; break;
				
				
				default : bout[iout++]=car;
			}
		}
		return new String(bout,0,iout);
	}
	
	public static String getConfigurationProperty(
	        String envKey, String sysKey, String defValue) {
	    String retValue = defValue;
	    String envValue = System.getenv(envKey);
	    String sysValue = System.getProperty(sysKey);
	    // system property prevails over environment variable
	    if (sysValue != null) {
	        retValue = sysValue;
	    } else if (envValue != null) {
	        retValue = envValue;
	    }
	    return retValue;
	}

}
