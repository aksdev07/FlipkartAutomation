import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.first.framework.Util;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FlipkartTests extends TestCases implements Resources{

    static WebDriver driver;
    static Util ref =new Util();

    @BeforeAll
    public static void createDriver(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        driver.get("https://www.flipkart.com");
    }

    @Test
    protected void loginFunctionality() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popUpWindow)));
         try {
            if (popUp.isDisplayed()) {
                WebElement loginID = driver.findElement(By.xpath(popUpUserID));
                loginID.sendKeys(ref.getUserIdValue());

                WebElement pwd = driver.findElement(By.xpath(popUpPassword));
                pwd.sendKeys(pwdValue);

                WebElement submit = driver.findElement(By.xpath(popUpLoginButton));
                submit.click();
            }
        }catch(ElementNotVisibleException e)
        {
            System.out.println("Different Element is present");
        }


    }


    @Test
    protected void searchItemFunctionality() {

    }


    @Test
    protected void itemSelectionFunctionality() {

    }


    @Test
    protected void purchaseFunctionality() {

    }


    @AfterAll
    public static  void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
