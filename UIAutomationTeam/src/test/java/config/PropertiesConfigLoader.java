package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads environment-specific configuration from a properties file based on the
 * active Maven profile.
 * <p>
 * The configuration file must follow the naming convention {@code application-<profile>.properties.}
 * Execution fails fast if no profile is defined or if a required configuration key is missing.
 * </p>
 *
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class PropertiesConfigLoader {

	private static Properties properties;

	private PropertiesConfigLoader() {}

	public static String getPropertyValue(String key) {
		if (properties == null) {
			loadPropertyFile();
		}
		String value = properties.getProperty(key);
		if (value == null || value.isBlank()) {
			throw new IllegalStateException("Required configuration key not found or empty: " + key);
		}
		return value;
	}

	private static synchronized void loadPropertyFile() {
		String env = System.getProperty("env");
		if (env == null || env.isBlank()) {
			throw new IllegalStateException("No environment profile defined. Run with: mvn test -P<profile>");
		}
		String fileName = "application-" + env + ".properties";
		
		try (InputStream file = PropertiesConfigLoader.class.getClassLoader().getResourceAsStream(fileName)) {
			if (file == null) {
				throw new IllegalStateException("Config file not found: " + fileName);
			}
			Properties loaded = new Properties();
			loaded.load(file);
			properties = loaded;
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config: " + fileName, e);
		}
	}
}
