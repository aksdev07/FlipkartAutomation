import com.first.framework.BaseTest;
import com.first.framework.XpathResources;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

public class FlipkartTests extends BaseTest implements XpathResources {
    private static Logger logger;

    public FlipkartTests() throws IOException {
    }


    @BeforeTest
    public void createDriver() throws IOException {

    }

    @BeforeClass
    public void loginFunctionality() {
        try {
            WebElement loginID = driver.findElement(By.xpath(popUpUserID));
            loginID.sendKeys(ref.getUserId());
            WebElement pwd = driver.findElement(By.xpath(popUpPassword));
            pwd.sendKeys(ref.getPasswordValue());
            WebElement submit = driver.findElement(By.xpath(popUpLoginButton));
            submit.click();
            wait.until(ExpectedConditions.invisibilityOf(submit));
        } catch (ElementNotVisibleException e) {
            logger.info("Different Element is present");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Assert.assertTrue(driver.findElement(By.xpath(search)).isDisplayed());
        }
    }


    @Test(priority = 1)
    public void searchItemFunctionality() throws IOException {
        FlipkartTests k=new FlipkartTests();
        SoftAssert softAssert = new SoftAssert();
        WebElement searchField = driver.findElement(By.xpath(search));
        searchField.sendKeys(ref.getProductName());
        WebElement product = driver.findElement(productXpath);
        softAssert.assertTrue(product.isDisplayed());
        searchField.submit();
        softAssert.assertAll();
    }


    @Test(priority = 2)
    public void itemSelectionFunctionality() {
        WebElement shirt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(oneTshirt)));
        shirt.click();
        String Parent = driver.getWindowHandle();
        Set<String> winHandle = driver.getWindowHandles();
        for (String s : winHandle) {
            if (!s.equals(Parent))
                driver.switchTo().window(s);
            logger.info(s);
        }
        wait.until(ExpectedConditions.invisibilityOf(shirt));
    }


    // @Test(priority = 3)
    public void purchaseFunctionality() {
        logger.info("Will write later");
    }

    @Override
    @Test(priority = 1)
    public void enterPin() {
        logger.info("PIN is 824512");
    }

    @AfterClass
    public static void tearDown() {

        driver.quit();
    }

}
