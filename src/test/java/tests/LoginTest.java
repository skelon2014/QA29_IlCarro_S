package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class LoginTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
     //   if (app.userHelper().isLogOutPresent()) {
     //       app.userHelper().logout();
     //   }
       // app.userHelper().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
    }
    @DataProvider
    public Iterator <Object[]> validDataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"skelon222@bk.ru","Qwerty$4"});
        list.add(new Object[]{"skelon22@bk.ru","Qwerty$4"});
        list.add(new Object[]{"skelon202@bk.ru","Qwerty$4"});

        return list.iterator();
    }

    @Test (dataProvider = "validDataLogin")
    public void loginSuccessWithDP(String email, String password)  {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(email, password);
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());

    }
    @Test
    public void loginSuccess()  {
        //  logger.info("Login with email: skelon222@bk.ru & password: Qwerty$4");
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

    @AfterMethod(alwaysRun = true)
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
