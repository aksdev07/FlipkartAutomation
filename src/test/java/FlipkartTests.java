import com.first.framework.XpathResources;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.first.framework.ConfigResource;
import java.io.IOException;

public class FlipkartTests extends TestCases implements XpathResources {

    private static WebDriver driver;
    private static ConfigResource ref =new ConfigResource();

 @Test(priority = 1)
    public static void createDriver() throws IOException {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get(ref.getUrlValue());
    }
    @Test(priority = 2)
    protected void loginFunctionality() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popUpWindow)));
         try {
            if (popUp.isDisplayed()) {
                WebElement loginID = driver.findElement(By.xpath(popUpUserID));
                loginID.sendKeys(ref.getUserId());

                WebElement pwd = driver.findElement(By.xpath(popUpPassword));
                pwd.sendKeys(ref.getPasswordValue());

                WebElement submit = driver.findElement(By.xpath(popUpLoginButton));
                submit.click();
            }
        }catch(ElementNotVisibleException e)
        {
            System.out.println("Different Element is present");
        }


    }


    @Test(priority = 3)
    protected void searchItemFunctionality() {

    }


    @Test(priority =4 )
    protected void itemSelectionFunctionality() {

    }


    @Test(priority =5 )
    protected void purchaseFunctionality() {

    }


    @Test(priority =6 )
    public static  void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
