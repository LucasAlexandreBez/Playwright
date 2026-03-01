package engine;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import config.GlobalTestRunConfig;

/**
 * Manages Allure runtime metadata files.
 * <p>
 * This class is responsible for preparing auxiliary files required by
 * Allure Report during test execution.
 * </p>
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public final class AllureEnvironmentManager {

    private static final Path ALLURE_RESULTS =
            Path.of("target", "allure-results");

    private AllureEnvironmentManager() {}

    /**
     * Copies the {@code categories.json} file from test resources
     * to the Allure results directory.
     * @throws RuntimeException if the file cannot be found or copied
     */
    public static synchronized void copyCategoriesFile() {
        try {
            Files.createDirectories(ALLURE_RESULTS);

            try (InputStream is = AllureEnvironmentManager.class
                    .getClassLoader()
                    .getResourceAsStream("categories.json")) {
                if (is == null) {
                    throw new RuntimeException("categories.json not found in test resources");
                }
                if (!Files.exists(ALLURE_RESULTS.resolve("categories.json"))) {
                    Files.copy(
                            is,
                            ALLURE_RESULTS.resolve("categories.json"),
                            StandardCopyOption.REPLACE_EXISTING
                    );
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to copy categories.json to Allure results", e);
        }
    }

    /**
     * Generates the {@code environment.properties} file used by Allure Report.
     * @throws RuntimeException if the file cannot be written
     */
    public static synchronized void writeEnvironmentFile() {
        try {
            Files.createDirectories(ALLURE_RESULTS);

            Properties props = new Properties();
            props.setProperty("Environment", System.getProperty("env", "local"));
            props.setProperty("Browser", GlobalTestRunConfig.SELECTED_BROWSER.toString());
            props.setProperty("Java", System.getProperty("java.version"));
            props.setProperty("OS", System.getProperty("os.name"));

            try (OutputStream os = Files.newOutputStream(
                    ALLURE_RESULTS.resolve("environment.properties"))) {
                props.store(os, "Allure Environment");
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to write Allure environment properties", e);
        }
    }
}
