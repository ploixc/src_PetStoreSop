package com.sopragroup.cco.tf.web.steps;


import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sopragroup.cco.tf.utils.Constantes;
import com.sopragroup.cco.tf.utils.FileUtils;
import com.sopragroup.cco.tf.utils.video.VideoUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * <p>
 * Example of a WebDriver implementation that has delegates all methods to a static instance (REAL_DRIVER) that is only 
 * created once for the duration of the JVM. The REAL_DRIVER is automatically closed when the JVM exits. This makes 
 * scenarios a lot faster since opening and closing a browser for each scenario is pretty slow.
 * To prevent browser state from leaking between scenarios, cookies are automatically deleted before every scenario.
 * </p>
 * <p>
 * A new instance of SharedDriver is created for each Scenario and passed to yor Stepdef classes via Dependency Injection
 * </p>
 * <p>
 * As a bonus, screenshots are embedded into the report for each scenario. (This only works
 * if you're also using the HTML formatter).
 * </p>
 * <p>
 * A new instance of the SharedDriver is created for each Scenario and then passed to the Step Definition classes'
 * constructor. They all receive a reference to the same instance. However, the REAL_DRIVER is the same instance throughout
 * the life of the JVM.
 * </p>
 */
public class SharedDriver extends EventFiringWebDriver {
	
	private static final WebDriver REAL_DRIVER = WebDriverFactory.get();
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
        	System.out.println("Quit du driver par addShutdownHook");
            // REAL_DRIVER.close();
            REAL_DRIVER.quit();
        }
    };

    static {
    	Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
        super(REAL_DRIVER);
    }

    @Override
    public void close() {
    	
        if(Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        
        super.close();
    }

    /**
     * Avant de lancer le scenario, on efface tous les cookies de facon a etre proche d'un nouvel utilisateur
     * cet effacement permet de garder le navigateur ouvert pour plusieurs scenarios ce qui accelere beaucoup les tests
     * 
     * @param scenario le scenario qui va etre joué
     */
    @Before
    public void deleteAllCookies(Scenario scenario) {
        manage().deleteAllCookies();
        if (Constantes.startRecordVideo) {
        	VideoUtils.startRecord(Constantes.fileVideoOut);
        }
        
    }

    /**
     * A la fin du scenario, on demande l'image de l'ecran au navigateur
     * on peut egalement ajouter la video
     * @param scenario le scenerio qui vient de terminer
     */
    @After
    public void embedScreenshotOrVideo(Scenario scenario) {
        try {
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	if (((HasCapabilities)REAL_DRIVER).getCapabilities().is(CapabilityType.TAKES_SCREENSHOT)) {
        		// il faut que le browser soit different de htmlunit car il ne supporte pas le ScreenShot
	            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png");
        	}

        	if (Constantes.startRecordVideo) {
            	VideoUtils.stopRecord();
            	if (Constantes.saveAlwaysVideo || scenario.isFailed()) {
            		byte[] videoByte = FileUtils.readFully(Constantes.fileVideoOut);
	            	if (videoByte != null) {
	            		scenario.embed(videoByte, "video/ogg");
	            	}
            	}
            }
        	
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }        
    }
}