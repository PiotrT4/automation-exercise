package helpers;

import java.io.*;
import java.util.Properties;

public class ConfigurationReader {
    private final String browser;
    private final String headless;
    private final String baseUrl;
    private final String waitInSeconds;
    private final String uBlockChromePath;
    private final String uBlockFirefoxPath;
    private final String uBlockEdgePath;

    public ConfigurationReader() {
        String configurationPath = "src/main/resources/configuration.properties";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(configurationPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found: " + configurationPath);
        }

        Properties properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        browser = properties.getProperty("browser");
        headless = properties.getProperty("headless");
        baseUrl = properties.getProperty("baseUrl");
        waitInSeconds = properties.getProperty("waitInSeconds");
        uBlockChromePath = properties.getProperty("uBlockChromePath");
        uBlockFirefoxPath = properties.getProperty("uBlockFirefoxPath");
        uBlockEdgePath = properties.getProperty("uBlockEdgePath");
    }

    public String getBrowser() {
        if (!browser.isEmpty()) return browser;
        else throw new RuntimeException("\"browser\" is not specified in the configuration.properties files");
    }

    public boolean isHeadless() {
        if (!headless.isEmpty()) return Boolean.parseBoolean(headless);
        else throw new RuntimeException("\"headless\" is not specified in the configuration.properties files");
    }

    public String getBaseUrl() {
        if (!baseUrl.isEmpty()) return baseUrl;
        else throw new RuntimeException("\"browser\" is not specified in the configuration.properties files");
    }

    public int getWaitInSeconds() {
        if (!waitInSeconds.isEmpty()) return Integer.parseInt(waitInSeconds);
        else throw new RuntimeException("\"waitInSeconds\" is not specified in the configuration.properties files");
    }

    public String getUBlockChromePath() {
        if (!uBlockChromePath.isEmpty()) return uBlockChromePath;
        else throw new RuntimeException("\"uBlockChromePath\" is not specified in the configuration.properties files");
    }

    public String getUBlockFirefoxPath() {
        if (!uBlockFirefoxPath.isEmpty()) return uBlockFirefoxPath;
        else throw new RuntimeException("\"uBlockFirefoxPath\" is not specified in the configuration.properties files");
    }

    public String getUBlockEdgePath() {
        if (!uBlockEdgePath.isEmpty()) return uBlockEdgePath;
        else throw new RuntimeException("\"uBlockEdgePath\" is not specified in the configuration.properties files");
    }
}
