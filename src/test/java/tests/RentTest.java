package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RentTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.userHelper().isElementPresent(By.cssSelector("div[class='header'] a:nth-child(6)"))) {
            app.userHelper().openLoginForm();
            User user = new User()
                    .withEmail("skelon222@bk.ru")
                    .withPassword("Qwerty$4");
            app.userHelper().fillLoginForm(user);
            app.userHelper().submitForm();
            app.userHelper().clickOK();
        }
    }

    @Test
    public void rentWithLogin() {
        app.search().fillSearchFormInFuture("Tel Aviv", "12/01/2021", "12/05/2021");
        app.userHelper().submitForm();
        //  Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.userHelper().pause(2000);
        app.rentHelper().choiceCar();
        app.userHelper().logout();
    }

    @Test
    public void rentWithotLogin() {
        app.userHelper().logout();
    }

//    @AfterMethod(alwaysRun = true)
//    public void postCondition() {
//        if (app.userHelper().isLogOutPresent()) {
//            app.userHelper().logout();
//        }
//    }

    @Test
    public void rentWithLogin_Taya() {
        if (!app.userHelper().isLogged()) {
            app.userHelper().login(new User().withEmail(app.email()).withPassword(app.password()));
        }
        User user = new User()
                .withName("John")
                .withLastName("Dow")
                .withEmail("skelon4444@bk.ru")
                .withPassword("Qwerty$4")
                .withPhone("+1234567890");
        app.search().fillSearchForm("Haifa", "12/29/2021", "12/30/2021");
        app.userHelper().submitForm();
        app.userHelper().pause(1000);
        app.rentHelper().selectAuto();
        app.rentHelper().selectRentNow();
        app.rentHelper().fillOrderForm(user);
        Assert.assertTrue(app.rentHelper().isOrderSuccess());
        app.rentHelper().closeOrder();
        app.userHelper().backToHomePage();

    }
}
