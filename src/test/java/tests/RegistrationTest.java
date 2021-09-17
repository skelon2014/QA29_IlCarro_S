package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
  //  @BeforeMethod
    public void preCondition() {
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }

    @Test
    public void RegistrationPositiveTest() throws InterruptedException {
        int i = (int) (System.currentTimeMillis() / 36000);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Sergey", "Sergeev", "skelon" + i + "@bk.ru", "Qwerty$4");
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrated());
        //     clickOK();
    }

    @Test
    public void registrationNegativeTest() throws InterruptedException {
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Sergey", "Sergeev", "skelon222@bk.ru", "Qwerty$4");
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertFalse(app.userHelper().isRegistrated());

    }

    @AfterMethod
    private void postCondition() {
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().deleteLogin();
        }
    }
}
