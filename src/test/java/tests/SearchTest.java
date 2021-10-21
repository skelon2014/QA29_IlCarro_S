package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
   @BeforeTest(alwaysRun = true)
   public void preCondition(){
       app.userHelper().pause(500);
       app.userHelper().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
       app.userHelper().pause(500);
   }
    @Test(groups = {"web"})
    public void searchTestByType() {
        app.search().typeData("Haifa", "10/21/2021", "12/14/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void searchTestByNegativeType() {
        app.search().typeData("Haifa", "09/16/2021", "12/14/2021");
        Assert.assertFalse(app.search().isButtonYallaActive());
    }

    @Test
    public void searchDataBySelectCurrentMonth() {
        app.search().fillSearchForm("Haifa", "10/25/2021", "10/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void searchDataBySelectMonthInFuture() {
        app.search().fillSearchFormInFuture("Haifa", "10/25/2021", "11/05/2022");
        app.userHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }
    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        app.userHelper().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
    }
}
