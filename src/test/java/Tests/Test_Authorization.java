package Tests;

import Utils.ScreenshotListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Entities.User.*;


@Listeners(ScreenshotListener.class)
public class Test_Authorization extends BaseTest {


    @DataProvider(name = "params")
    public Object[][] params() {


        return new Object[][]
                {

                        {generateFirstName(10), generateLastName(10), generatePhone(10),
                                generateEmail(10), generatePassword(10), getPassword(),
                                true, "Hi, " + getFirstName() + " " + getLastName()},

                        {getFirstName(), getLastName(), getPhone(),
                                getEmail(), getPassword(), getPassword(),
                                false, "Email Already Exists."},

                        {generateFirstName(10), generateLastName(10), generatePhone(10),
                                generateEmail(10), generatePassword(10), getPassword(),       // test not should be passsed
                                true, "Hi, " + getFirstName() + " " + getLastName()},                     // other fields also do not have a character limit

                        {generateFirstName(0), generateLastName(10), generatePhone(10),
                                generateEmail(10), generatePassword(10), getPassword(),
                                false, "The First name field is required."},

                        {generateFirstName(10), generateLastName(0), generatePhone(10),
                                generateEmail(10), generatePassword(10), getPassword(),
                                false, "The Last Name field is required."},

                        {generateFirstName(10), generateLastName(10), generatePhone(0),
                                generateEmail(10), generatePassword(10), getPassword(),
                                true, "Hi, " + getFirstName() + " " + getLastName()},

                        {generateFirstName(10), generateLastName(10), generatePhone(0) + "f",
                                generateEmail(10), generatePassword(10), getPassword(),
                                true, "Hi, " + getFirstName() + " " + getLastName()},                     //test not should be passed

                        {generateFirstName(10), generateLastName(10), generatePhone(10),
                                generateEmail("invalid"), generatePassword(10), getPassword(),
                                false, "The Email field must contain a valid email address."},

                        {generateFirstName(10), generateLastName(10), generatePhone(10),
                                generateEmail(0), generatePassword(10), getPassword(),
                                false, "The Email field is required."},

                        {generateFirstName(10), generateLastName(10), generatePhone(10),
                                generateEmail(10), generatePassword(0), generatePassword(10),
                                false, "The Password field is required." + "\n" + "Password not matching with confirm password."},

                        {generateFirstName(10), generateLastName(10), generatePhone(10),
                                generateEmail(10), generatePassword(10), generatePassword(0),
                                false, "The Password field is required."},

                        {generateFirstName(10), generateLastName(10), generatePhone(10),
                                generateEmail(10), generatePassword(3), getPassword(),
                                false, "The Password field must be at least 6 characters in length."},

                        {generateFirstName(10), generateLastName(10), generatePhone(10),
                                generateEmail(10), generatePassword(6), generatePassword(6),
                                false, "Password not matching with confirm password."},

                        {generateFirstName(0), generateLastName(0), generatePhone(0),
                                generateEmail(0), generatePassword(0), generatePassword(0),
                                false, "The Email field is required.\n" +
                                "The Password field is required.\n" +
                                "The Password field is required.\n" +
                                "The First name field is required.\n" +
                                "The Last Name field is required."},

                        {enterSpecialCharacters(), enterSpecialCharacters(), enterSpecialCharacters(),
                                enterSpecialCharacters(), enterSpecialCharacters(), enterSpecialCharacters(),
                                false, "The Email field must contain a valid email address."}

                };
    }

    @Test(dataProvider = "params")
    public void signUp(String firstName, String lastName, String phone, String email,
                       String password, String confirmPassword, Boolean positiveCase, String result) {
        registerPage.openRegisterPage();
        registerPage.inputFirstName(firstName);
        registerPage.inputLastName(lastName);
        registerPage.phoneInput(phone);
        registerPage.emailInput(email);
        registerPage.passwordInput(password);
        registerPage.confirmPasswordInput(confirmPassword);
        registerPage.submit();
        Assert.assertEquals(registerPage.verifySignUp(positiveCase), result);

    }

}
