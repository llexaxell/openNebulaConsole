package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {

	/**
	 * Get the property file "fileName"
	 * @param fileName
	 * @return
	 */
	public static Properties getPropertyFile(String fileName){
		Properties prop = new Properties();
		try {
			InputStream inputStream = Util.class.getClassLoader().getResourceAsStream(fileName+".properties");
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
