package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private final WebDriverWait shortWait;
    private final WebDriverWait longWait;
    private WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        shortWait = new WebDriverWait(driver, 15);
        longWait = new WebDriverWait(driver, 40);
    }

    public void scrollUntilElementVisible(By selector) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",

                driver.findElement(selector));
    }

    public List<WebElement> returnList(By selector) {
        return driver.findElements(selector);
    }

    public void click(By selector) {
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        driver.findElement(selector).click();
    }

    void input(By selector, String textToInput) {
        scrollUntilElementVisible(selector);
        click(selector);
        driver.findElement(selector).clear();
        driver.findElement(selector).sendKeys(textToInput);
    }

    public String getText(By selector) {
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return driver.findElement(selector).getText();
    }
}
