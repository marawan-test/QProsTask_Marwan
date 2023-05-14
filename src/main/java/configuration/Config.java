package configuration;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties prop = new Properties();
    private FileInputStream input = null;
    private FileWriter fw = null ;

    public Config() {
        try {

            input = new FileInputStream(
                     "./src/main/java/configuration/config.properties");
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String Key) {
        return prop.getProperty(Key);
    }

}
