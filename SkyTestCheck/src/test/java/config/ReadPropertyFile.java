package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {
	Properties propFile;
	public String getProperty(String propKey) {
		String homePath = System.getProperty("user.dir");
		propFile = new Properties();
		try {
			InputStream fileInput = new FileInputStream(homePath+"/src/test/config/config.properties");
			propFile.load(fileInput);
			
			 
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return(propFile.getProperty(propKey));
	}
	
}
