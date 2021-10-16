package com.first.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import static com.first.framework.XpathResources.popUpUserID;

/**
 * @author github.com/aksdev07    (Anuj)
 */

public class BaseTest {
    private static Logger logger = Logger.getLogger(BaseTest.class.getName());
    private String result = "";
    private InputStream inputStream;
    private static int c = 0;
    public static BaseTest ref;
    public static WebDriver driver;
    public WebDriverWait wait;
    public BaseTest(String init){

    }
    public BaseTest() throws IOException {
        logger = Logger.getLogger(BaseTest.class.getName());
        ref = new BaseTest();
        if(getBrowserName().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(getBrowserName().equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        BaseTest obj = new BaseTest();
        driver.get(obj.getUrlValue());
        logger.fine("Driver instantiated Successfully");
        wait = new WebDriverWait(driver, 15);
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popUpUserID)));
      //  Assert.assertTrue(popUp.isDisplayed(), "Worked");
    }
    private String initializerOFProperty(String configKeyName) {
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

            result = prop.getProperty(configKeyName);
            System.out.println(result + " from config.properties");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            assert inputStream != null;
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public String getProductName() {
        return initializerOFProperty("product");
    }

    public String getTshirtName() throws IOException {
        System.out.println(c);
        c++;
        return initializerOFProperty("tshirtname");
    }

    public String getBrowserName() {
        String s="";
        try {
            s= initializerOFProperty("browser");
        } catch (Exception e) {

        }
        return s;
    }
}