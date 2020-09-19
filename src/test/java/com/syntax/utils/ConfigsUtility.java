package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigsUtility {

	public static Properties prop;

	public static String configFilePath = System.getProperty("user.dir")
			+ "/src/test/resources/configs/configuration.properties";

	public static Properties readProperties() {

		try {
			FileInputStream fis = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static String getProperty(String key) {
		try {
			FileInputStream fis = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
