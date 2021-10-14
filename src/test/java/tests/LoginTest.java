package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class LoginTest extends TestBase {
 //   @BeforeMethod
    public void preCondition() {
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }

    @Test
    public void loginSuccess()  {
        logger.info("Login with email: skelon222@bk.ru & password: Qwerty$4");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("skelon222@bk.ru", "Qwerty$4");
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());
    }

    @Test
    public void loginNegativeWrongPassword()  {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("skelon223@bk.ru", "Qwerty64");
        app.userHelper().submitForm();
        Assert.assertFalse(app.userHelper().isLogged());
    }

    @AfterMethod
    public void postCondition() {
        app.userHelper().clickOK();
        if(app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }
    //================fluentInterface============
    @Test
    public void loginSuccessModel()  {
        User user = new User()
                .withEmail("skelon222@bk.ru")
                .withPassword("Qwerty$4");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());
    }
}
