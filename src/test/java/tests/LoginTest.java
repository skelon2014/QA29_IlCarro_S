package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }

    @Test
    public void loginSuccess() throws InterruptedException {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("skelon222@bk.ru", "Qwerty$4");
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());
    }

    @Test
    public void loginNegativeWrongPassword() throws InterruptedException {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("skelon222@bk.ru", "Qwerty64");
        app.userHelper().submitForm();
        Assert.assertFalse(app.userHelper().isLogged());
    }

    @AfterMethod
    public void postCondition() {
        if(app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }
}
