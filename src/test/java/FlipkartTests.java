import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FlipkartTests extends TestCases implements Resources{

    static WebDriver driver;

    @BeforeAll
    public static void createDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
    }

    @Test
    protected void loginFunctionality() {
        WebElement loginID = driver.findElement(By.xpath(popUpUserID));
        loginID.sendKeys(userIdValue);

        WebElement pwd=driver.findElement(By.xpath(popUpPassword));
        pwd.sendKeys(pwdValue);








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
