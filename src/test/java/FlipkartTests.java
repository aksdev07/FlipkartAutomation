import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.testng.annotations.Test;


public class FlipkartTests extends TestCases implements Resources {

    private static WebDriver driver = null;


    @Test(priority = 1)
    public static void createDriver() {
     /*   driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.flipkart.com");*/

        System.setProperty("webdriver.chromedriver.driver","D://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");

            }


     @Test(priority = 2)
     protected  void loginFunctionality() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popUpWindow)));
        try {
            if (popUp.isDisplayed()) {
                WebElement loginID = driver.findElement(By.xpath(popUpUserID));
                loginID.sendKeys(userIdValue);


                WebElement pwd = driver.findElement(By.xpath(popUpPassword));
                pwd.sendKeys(pwdValue);

                WebElement submit = driver.findElement(By.xpath(popUpLoginButton));
                submit.click();
            }
        }
        catch(ElementNotVisibleException e)
            {
                System.out.println("Different Element is present");
            }

    }





    @Test(priority = 3)
    protected void searchItemFunctionality() throws InterruptedException {
Thread.sleep(5000);
        WebElement searchFeild=driver.findElement(By.xpath(searchField));
        searchFeild.sendKeys("T-shirt");
        WebElement search=driver.findElement(By.xpath(searchClick));
        search.sendKeys(Keys.ENTER);

    }


    @Test(priority = 4)
    protected void itemSelectionFunctionality() throws InterruptedException {
        Thread.sleep(3000);
       while (true)
            try {
            List<WebElement> tShirt = driver.findElements(By.xpath(tshirtAll));
            System.out.println("Size of the webelement : "+tShirt.size());
                for (WebElement s : tShirt) {
                    if (s.getText().contentEquals(tShirtName))
                        s.click();
                }
                 break;
                } catch (StaleElementReferenceException e) {
                driver.navigate().refresh();
                continue;
            }


    }




   @Test(priority = 5)
    protected void purchaseFunctionality() {

    }



    @Test(priority = 6)
    public static  void closeDriver() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }


}
