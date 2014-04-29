package com.sopragroup.cco.tf.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

public class FileUtils {

	public static byte[] readFully(String file) {
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(file, "r");
		
        int taille = (int) raf.length();

        byte buff[] = new byte[taille];

        raf.readFully(buff);

        raf.close();
        return buff;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
        
	}
	
	static public Properties loadProperties(String name) throws IOException {
		ClassLoader loader = ClassLoader.getSystemClassLoader();

		if(loader != null) {
			InputStream in = loader.getResourceAsStream(name);
			Properties props = new Properties();
			props.load(in);
			return props;
		}

		
		return null;
	}

	
}
