package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class SettingsProvider {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final Properties properties = new Properties();

    public SettingsProvider() {}

    private static void loadConfig() {
        try (InputStream input = new FileInputStream("target/classes/properties-from-pom.properties")) {
            properties.load(input);
        } catch (IOException e) {
            String message = String.format("Exception while load .properties. Details: %s", e.getMessage());
            log.error(message);
            throw new RuntimeException(message);
        }
    }

    public static String getPropertyValue(String key) {
        return getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.put(key, value);
    }

    private static String getProperty(String key) {
        return properties.getProperty(key);
    }

    static {
        loadConfig();
    }
}
