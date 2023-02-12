package tests.login;

import Pages.LoginPage;
import Pages.MenuPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTest extends BaseTest {

    Faker faker = new Faker();

    LoginPage loginPage;
    MenuPage menu;

    String email = "test@gmail.com";
    String password = "test@gmail.com";

    String wrongEmail = faker.internet().emailAddress();
    String wrongPassword = faker.internet().password();

    String errorMessage = "Please check your activation or Login + Password combination";

    @Test
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.getAuth(email, password);

        menu = new MenuPage(driver);
        Assert.assertTrue(menu.waitElementVisible(menu.getAccountButton()));
    }

    @Test
    public void loginTestWithWrongEmailUndPassword() {
        loginPage = new LoginPage(driver);
        loginPage.getAuth(wrongEmail, wrongPassword);

//        menu = new MenuPage(driver);
        Assert.assertTrue(loginPage.waitElementVisible(loginPage.getErrorMsg()));
        Assert.assertEquals(loginPage.getErrorMsgText(), errorMessage,
                "The actual text of error message does not matches the expected");
    }
}
