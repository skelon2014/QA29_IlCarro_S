package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
    //10/20/2021 - 10/22/2021 positive test
    //09/20/2021 - 10/22/2021 negative test
    @Test
    public void searchTest() {


    }

    @Test
    public void searchTestByNegativeType() {

    }

    @Test
    public void searchDataBySelectCurrentMonth() {
        app.search().fillSearchForm("Haifa", "10/25/2021", "10/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());

    }
    @Test
    public void searchDataBySelectMonthInFuture() {
      //  try {
            app.search().fillSearchFormInFuture("Haifa", "11/15/2021", "12/10/2021");
            app.userHelper().submitForm();
            Assert.assertTrue(app.search().isListOfCarsAppeared());
     //   }catch (Exception e){
      //      System.out.println(e.getMessage());
      //  }


    }
}
