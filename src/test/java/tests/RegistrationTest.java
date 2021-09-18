package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    // @BeforeMethod
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
        Thread.sleep(1000);
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrated());
    }

    @Test
    public void registrationNegativeTest() {
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Q", "Q", "skelon@225bk.ru", "werty$4");
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isErrorPasswordDisplaed());
        Assert.assertFalse(app.userHelper().isYallaButtonActive());

    }

    @AfterMethod
    private void postCondition() {
        app.userHelper().clickOK();
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().deleteLogin();
        }
    }

    //====================fluentInterface=============
    @Test
    public void RegistrationPositiveTestModel() throws InterruptedException {
        int i = (int) (System.currentTimeMillis() / 3600000);

        User user = new User()
                .withName("Serg")
                .withLastName("Sergeev")
                .withEmail("kselon3" + i + "@bk.ru")
                .withPassword("Qwerty$4");

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm(user);
        Thread.sleep(1000);
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrated());
    }
}
