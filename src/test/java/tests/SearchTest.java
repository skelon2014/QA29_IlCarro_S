package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
   @BeforeTest(alwaysRun = true)
   public void preCondition(){
    //   app.userHelper().pause(500);
    //   app.userHelper().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
      // app.userHelper().pause(500);
   }
    @Test(groups = {"web"})
    public void search4TestByType() {
        app.search().typeData("Rehovot", "10/30/2021", "12/14/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.userHelper().pause(2000);
    }

    @Test
    public void search3TestByNegativeType() {
        app.search().typeData("Haifa", "09/16/2021", "12/14/2021");
        Assert.assertFalse(app.search().isButtonYallaActive());
        app.userHelper().pause(2000);
    }

    @Test
    public void search2DataBySelectCurrentMonth() {
        app.search().fillSearchForm("Ierusalim", "10/27/2021", "10/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.userHelper().pause(2000);
    }

    @Test
    public void search1DataBySelectMonthInFuture() {
        app.search().fillSearchFormInFuture("Tel Aviv", "11/27/2021", "12/05/2022");
        app.userHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.userHelper().pause(2000);
    }
    @AfterMethod(alwaysRun = true)
    public void postCondition(){
     //   app.userHelper().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
        app.userHelper().backToHomePage();
    }
}
