package Tests;

import Pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected RegisterPage registerPage;

    @BeforeMethod
    public void SetUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        context.setAttribute("driver", driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterMethod
    public void GetDown() {
        driver.quit();
        driver = null;

    }
}
