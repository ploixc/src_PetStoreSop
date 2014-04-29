package com.sopragroup.cco.tf.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constantes {
	
	public static final int CASE_A_COCHER_COCHER = 1;
	public static final int CASE_A_COCHER_DECOCHER = 2;
	public static final int CASE_A_COCHER_INVERSER = 3;

	
	public static  boolean startRecordVideo = true; // lance vlc et enregistre video ecran
	public static boolean saveAlwaysVideo = true; //true = failed ou OK, et false = uniquement failed sinon pas de video
	public static String fileVideoOut;
	public static String pathVlcExe;
	public static String launchVideoShell;
	public static String browser; // chrome, firefox, htmlunit, ie
	public static String webdriver_chrome_driver; // emplacement sur le disque du driver chrome (chromedriver.exe)
	public static String webdriver_ie_driver; // emplacement sur le disque du driver Internet Explorer (IEDriverServer.exe)
	
	
	public static Properties globalProp = null;
	
	
	public static void initialiseEnv() {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		String propertiesFileName = "global_local_eclipse.properties";
		if (loader != null) {
			InputStream in = loader.getResourceAsStream(propertiesFileName);
			Properties props = new Properties();
			try {
				if (in == null) {
					System.err.println("Pas de lecture du fichier " + propertiesFileName + " (pour JUnit dans Eclipse), in == null");
					propertiesFileName = "global.properties";
					in = loader.getResourceAsStream(propertiesFileName);
					if (in == null) {
						System.err.println("Pas de lecture du fichier " + propertiesFileName + " (pour Maven), in == null");
					} 
				}
				
				if (in != null) { 
					System.out.println("Lecture du fichier " + propertiesFileName);
					props.load(in);	
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			globalProp = props;
			globalProp.put("propertiesFileName", propertiesFileName);
			
			System.out.println("globalProp = " + globalProp);
		}
		
		String sStartVideoRecording =  globalProp.getProperty("startRecordVideo");
		if (sStartVideoRecording == null) {
			startRecordVideo = false;
			System.err.println("startRecordVideo PAS Renseigne !");
		}
		else {
			startRecordVideo = Boolean.valueOf(sStartVideoRecording);
			System.out.println("OK startRecordVideo = " + startRecordVideo);
		}
		
		
		String sSaveAlwaysVideo =  globalProp.getProperty("saveAlwaysVideo");
		if (sSaveAlwaysVideo == null) {
			saveAlwaysVideo = false;
			System.err.println("sSaveAlwaysVideo PAS Renseigne !");
		}
		else {
			saveAlwaysVideo = Boolean.valueOf(sSaveAlwaysVideo);
			System.out.println("OK saveAlwaysVideo = " + saveAlwaysVideo);
		}
		
			
		pathVlcExe = globalProp.getProperty("pathVlcExe");
		if (pathVlcExe == null) {
			System.err.println("pathVlcExe PAS Renseigne !");
		}
		else {
			System.out.println("pathVlcExe = " + pathVlcExe);
			File f = new File(pathVlcExe);
			if (!f.exists()) {
				System.err.println("pathVlcExe N'existe PAS, f = " + pathVlcExe);
			}
			else {
				if (!f.canExecute()) {
					System.err.println("pathVlcExe PAS les droits d'execution, f = " + pathVlcExe);
				}
			}
			
		}
				
		launchVideoShell = globalProp.getProperty("launchVideoShell");
		if (launchVideoShell == null) {
			System.err.println("launchVideoShell PAS Renseigne !");
		}
		else {
			System.out.println("launchVideoShell = " + launchVideoShell);
			File f = new File(launchVideoShell);
			if (!f.exists()) {
				System.err.println("launchVideoShell N'existe PAS, f = " + launchVideoShell);
			}
			else {
				if (!f.canExecute()) {
					System.err.println("launchVideoShell PAS les droits d'execution, f = " + launchVideoShell);
				}
			}
		}
		
		fileVideoOut =  globalProp.getProperty("fileVideoOut");
		if (fileVideoOut == null) {
			System.err.println("fileVideoOut PAS Renseigne !");
		}
		else {
			System.out.println("fileVideoOut = " + fileVideoOut);
		}
		
		browser =  globalProp.getProperty("browser");
		if (browser == null) {
			System.err.println("browser PAS Renseigne !");
		}
		else {
			System.out.println("browser = " + browser);
		}
		
		webdriver_chrome_driver = globalProp.getProperty("webdriver.chrome.driver");
		if (webdriver_chrome_driver == null) {
			System.err.println("webdriver.chrome.driver PAS Renseigne !");
		}
		else {
			System.out.println("webdriver.chrome.driver = " + webdriver_chrome_driver);
		}
		
		webdriver_ie_driver = globalProp.getProperty("webdriver.ie.driver");
		if (webdriver_ie_driver == null) {
			System.err.println("webdriver.ie.driver PAS Renseigne !");
		}
		else {
			System.out.println("webdriver.ie.driver = " + webdriver_ie_driver);
		}
		
	}
	
}
