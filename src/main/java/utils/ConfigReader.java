package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;

	static {
		File proFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(proFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	
//	public Properties intializeProperties() {
//
//		Properties prop = new Properties();
//		File proFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
//
//		try {
//			FileInputStream fis = new FileInputStream(proFile);
//			prop.load(fis);
//		}catch(Throwable e) {
//			e.printStackTrace();
//		}
//
//		return prop;
//
	}

}
