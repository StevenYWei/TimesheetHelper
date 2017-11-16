package utils;

import static constants.Constants.PROPERTY_FILENAME;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesManager {

	public static Properties prop = new Properties();
	public static InputStream input = null;
	public static OutputStream output = null;

	static {
		try {
			input = PropertiesManager.class.getClassLoader().getResourceAsStream(PROPERTY_FILENAME);
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PropertiesManager() {}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
