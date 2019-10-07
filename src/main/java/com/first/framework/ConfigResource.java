package com.first.framework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author github.com/aksdev07    (Anuj)
 *
 */

public class ConfigResource {
    private String result = "";
    private InputStream inputStream;

    public String initializerOFProperty(String configKeyName) throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            Date time = new Date(System.currentTimeMillis());
            // get the property value and print it out
            String keysValue = prop.getProperty(configKeyName);

            result = keysValue;
            System.out.println(result + " of user " + keysValue);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        return result;


    }


    public String getUserId() throws IOException {

        return initializerOFProperty("username");

    }


    public String getPasswordValue() throws IOException {

        return initializerOFProperty("password");
    }


    public String getUrlValue() throws IOException {

        return initializerOFProperty("URL");
    }
}