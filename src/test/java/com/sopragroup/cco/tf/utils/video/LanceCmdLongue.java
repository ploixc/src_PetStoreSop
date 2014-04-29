package com.sopragroup.cco.tf.utils.video;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class LanceCmdLongue implements Runnable {

	String maCmd = "";
	String ficOut = "";
	String vlcBin = "";
	
	public void init(String laCmd, String leVlcBin, String nomFichier) {
		maCmd = laCmd;
		vlcBin = leVlcBin;
		ficOut = nomFichier;
		
		
	}
	
	@Override
	public void run(){
		System.out.println("Travail a effectuer");
        
		ProcessBuilder pb = new ProcessBuilder(maCmd, vlcBin, ficOut);
        Process p;
		try {
			p = pb.start();
		
	        String output = loadStream(p.getInputStream());
	        //String error  = loadStream(p.getErrorStream());
	        int rc = p.waitFor();
	        System.out.println("Process ended with rc=" + rc);
	        System.out.println("\nStandard Output:\n");
	        System.out.println(output);
	        //System.out.println("\nStandard Error:\n");
	        //System.out.println(error);
	        System.out.println("Process fini");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }

    private static String loadStream(InputStream s) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(s));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line=br.readLine()) != null)
            sb.append(line).append("\n");
        return sb.toString();
    }

}