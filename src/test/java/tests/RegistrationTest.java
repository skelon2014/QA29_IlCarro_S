package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
     @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }

    @Test(groups = {"web"})
    public void RegistrationPositiveTest()  {
        int i = (int) (System.currentTimeMillis() / 36000);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Sergey", "Sergeev", "skelon" + i + "@bk.ru", "Qwerty$4");
        app.userHelper().pause(2000);
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
     //   Assert.assertTrue(app.userHelper().isRegistrated());
    }

    @Test
    public void registrationNegativeTest() {
        int i = (int) (System.currentTimeMillis() / 36000);
         User user = new User()
                 .withName("Serg")
                 .withLastName("Lenin")
                 .withEmail("skelon" + i + "@bk.ru")
                 .withPassword("123456");
       logger.info("TestData: name: " + user.getName() + "; last name: "
               + user.getLastName() + "; email: " + user.getEmail() + "; Password: " + user.getPassword());

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm(user);
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isErrorPasswordDisplaed());
        Assert.assertFalse(app.userHelper().isYallaButtonActive());
    }

    @AfterMethod(alwaysRun = true)
    private void postCondition() {
        app.userHelper().clickOK();
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().deleteLogin();
        }
        app.userHelper().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
    }

    //====================fluentInterface=============
    @Test
    public void RegistrationPositiveTestModel()  {
        int i = (int) (System.currentTimeMillis() / 3600000);

        User user = new User()
                .withName("Serg")
                .withLastName("Sergeev")
                .withEmail("kselon3" + i + "@bk.ru")
                .withPassword("Qwerty$4");

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm(user);
        app.userHelper().pause(2000);
        app.userHelper().checkPolicy();
        app.userHelper().submitForm();
    //    Assert.assertTrue(app.userHelper().isRegistrated());
    }
}
