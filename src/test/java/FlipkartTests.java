import com.first.framework.XpathResources;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.first.framework.ConfigResource;
import java.io.IOException;
import java.util.List;

public class FlipkartTests extends TestCases implements XpathResources {

    private static WebDriver driver;
    private static ConfigResource ref =new ConfigResource();
    private static int c=0;

 @Test(priority = 1)
    public static void createDriver() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
    protected void searchItemFunctionality() throws InterruptedException {
        Thread.sleep(5000);
        WebElement searchFeild=driver.findElement(By.xpath(searchField));
        searchFeild.sendKeys("T-shirt");
        WebElement search=driver.findElement(By.xpath(searchClick));
        search.sendKeys(Keys.ENTER);

    }


    @Test(priority =4 )
    protected void itemSelectionFunctionality() throws InterruptedException, IOException {
        Thread.sleep(3000);

        while (true) {
            try {
                List<WebElement> tShirt = driver.findElements(By.xpath(tshirtAll));
                System.out.println("Size of the webelement : " + tShirt.size());
                for (WebElement s : tShirt) {
                    if (s.getText().contentEquals(ref.getTshirtName())) {
                        s.click();
                        c++;
                        break;
                    }
                }


            } catch (StaleElementReferenceException e) {
                driver.navigate().refresh();
                continue;
            }
            if (c>0) {
                System.out.println("inside if");
                break;
            }

        }
    }



    @Test(priority =5 )
    protected void purchaseFunctionality() {
        System.out.println("Will write later");

    }


    @Test(priority =6 )
    public static  void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
