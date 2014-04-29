package com.sopragroup.cco.tf.web.steps;

import org.junit.AfterClass;
import org.apache.log4j.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.sopragroup.cco.tf.utils.Constantes;
import com.sopragroup.cco.tf.utils.video.LanceCmdLongue;
import com.sopragroup.cco.tf.utils.video.VideoUtils;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
// @Cucumber.Options(format={"junit:target/junit.xml", "html:target/cucumber", "json:target/cucumber.json"}), tags = {"@login, @recherche, @ajout"}
// @Cucumber.Options(format={"html:target/cucumber-html", "json:target/cucumber.json"},tags = {"@file6"})
// @Cucumber.Options(format={"html:target/cucumber-html", "json:target/cucumber.json"},tags = {"@ajout"})
// @Cucumber.Options(format={"html:target/cucumber-html", "json:target/cucumber.json"},tags = {"@file3, @file2"})
@Cucumber.Options(format={"html:target/cucumber-html", "json:target/cucumber.json"})
public class GestdocTest {
	
	private static Logger LOG = Logger.getLogger(GestdocTest.class.getName());
	
	/**
	 * BeforeClass est appelé avant lancer le test
	 * On lit le fichier de constantes et on démarre Videolan si on veut des vidéos
	 */
	@BeforeClass 
	public static void setUpClass() { 
		
		System.out.println("Avant Constantes.initialiseEnv");
		Constantes.initialiseEnv();
		System.out.println("Après Constantes.initialiseEnv");
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);
		
		LOG.info("Debut setUpClass dans log4j");
		System.out.println("Master setUpClass");
		
		if (Constantes.startRecordVideo) {
			System.out.println("Lance VLC");

			LanceCmdLongue cmdLongue = new LanceCmdLongue();
			cmdLongue.init(Constantes.launchVideoShell, Constantes.pathVlcExe, Constantes.fileVideoOut);

			//On créer notre thread avec notre tache à executer
			Thread t = new Thread(cmdLongue);
			//On lance le thread
			t.start();
		}


	}

	
	/**
	 * AfterClass est appelé à la fin du test
	 * On arrete Videolan s'il avait démarré
	 */
	@AfterClass public static void tearDownClass() { 
		System.out.println("Master tearDown");
		if (Constantes.startRecordVideo) {
			System.out.println("Arret de VLC");
			VideoUtils.quit();
		}
	}
	
}
