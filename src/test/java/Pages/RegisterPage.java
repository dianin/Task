package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private WebDriver driver;

    private static final String URL = "https://www.phptravels.net/register";

    private By firstNameInput = By.xpath("//*[@name='firstname']");
    private By lastNameInput = By.xpath("//*[@name='lastname']");
    private By phoneInput = By.xpath("//*[@name='phone']");
    private By emailInput = By.xpath("//*[@name='email']");
    private By passwordInput = By.xpath("//*[@name='password']");
    private By confirmPasswordInput = By.xpath("//*[@name='confirmpassword']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By greeting = By.xpath("//*[@class='RTL' and @style='margin-left: 17px']");
    private By alert = By.xpath("//*[@class='alert alert-danger']");


    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openRegisterPage() {
        driver.get(URL);
    }

    public void inputFirstName(String textToInput) {
        input(firstNameInput, textToInput);
    }

    public void inputLastName(String textToInput) {
        input(lastNameInput, textToInput);
    }

    public void phoneInput(String textToInput) {
        input(phoneInput, textToInput);
    }

    public void emailInput(String textToInput) {
        input(emailInput, textToInput);
    }

    public void passwordInput(String textToInput) {
        input(passwordInput, textToInput);
    }

    public void confirmPasswordInput(String textToInput) {
        input(confirmPasswordInput, textToInput);
    }

    public void submit() {
        click(submitButton);
    }

    public String verifySignUp(Boolean positiveCase) {
        return (positiveCase) ? getText(greeting) : getText(alert);
    }

}
