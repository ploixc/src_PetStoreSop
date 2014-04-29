package com.sopragroup.cco.tf.utils.video;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class VideoUtils {

	static String host = "localhost";
	static int port = 4242;
	
	static String ficOutVideo = "";
	static NioClient clientStatic;
	static RspHandler handlerStat;
	static long debutRecord;
	static long dureeMini = 2000;
	static Thread threadStat;
	static boolean estInitialise = false;
	
	public static void initConnexionVlcRc()  {
		System.out.println("Debut initConnexionVlcRc");
		NioClient client;
		try {
			client = new NioClient(InetAddress.getByName(host), port);
		
			Thread t = new Thread(client);
			t.setDaemon(true);
			t.start();
			
			RspHandler handler = new RspHandler();
			
			threadStat = t;
			handlerStat = handler;
			clientStatic = client;
			String retour;
			String cmd;
			cmd = "is_playing";
			clientStatic.send((cmd + "\n").getBytes(), handlerStat);
			retour = handlerStat.waitForResponseString();
			System.out.println("cmd = " + cmd + ", retour = " + retour);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin    initConnexionVlcRc");

	}
	
	public static void startRecord(String fileOut) {
		if (!estInitialise) {
			initConnexionVlcRc();
			estInitialise = true;
		}
		System.out.println("Debut startRecord");
		try {
			ficOutVideo = fileOut;
			//System.out.println("ficOut = " + ficOutVideo);
		
			String retour;
			String cmd;
			Thread.sleep(1000);
			
			cmd = "play";
			clientStatic.send((cmd + "\n").getBytes(), handlerStat);
			retour = handlerStat.waitForResponseString();
			System.out.println("cmd = " + cmd + ", retour = " + retour);
			debutRecord = System.currentTimeMillis();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin   startRecord");
	}
	
	public static void stopRecord()  {
		System.out.println("Debut stopRecord");
		try {
			String retour;
			String cmd;
			
			long current = System.currentTimeMillis();
			if (debutRecord + dureeMini >  current) {
				long delta = (debutRecord + dureeMini) -  current;
				//System.out.println("Delta = " + delta);
				Thread.sleep(delta);
			}
			Thread.sleep(1500);
			cmd = "stop";
			clientStatic.send((cmd + "\n").getBytes(), handlerStat);
			retour = handlerStat.waitForResponseString();
			System.out.println("cmd = " + cmd + ", retour = " + retour);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin    stopRecord");
		
	}
	public static void quit()  {
		System.out.println("Debut quit");
		try {
			String retour;
			String cmd;
			
			long current = System.currentTimeMillis();
			if (debutRecord + dureeMini >  current) {
				long delta = (debutRecord + dureeMini) -  current;
				System.out.println("Delta = " + delta);
				Thread.sleep(delta);
			}
			
			Thread.sleep(1000);
			cmd = "quit";
	
			clientStatic.send((cmd + "\n").getBytes(), handlerStat);
			retour = handlerStat.waitForResponseString();
			System.out.println("cmd = " + cmd + ", retour = " + retour);
			//threadStat.stop();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin    quit");
		
	}
	
	static void renameFile(String oldName, String newName) {
		//Obtain the reference of the existing file
		File oldFile = new File(oldName); 

		System.out.println("Rename new = " + newName);
		//Now invoke the renameTo() method on the reference, oldFile in this case
		oldFile.renameTo(new File(newName));
	}
}
