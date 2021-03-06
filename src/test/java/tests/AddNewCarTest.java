package tests;

import models.Car;
import models.CarLombok;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if(!app.userHelper().isLogged()){
            app.userHelper().login(new User().withEmail(app.email()).withPassword(app.password()));
        }

//        if(!app.userHelper().isLogged()){
//            app.userHelper().login(new User().withEmail("skelon222@bk.ru").withPassword("Qwerty$4"));
//        }

//        if(app.userHelper().isElementPresent(By.xpath("//a[@class='navigation-link'][.=' Log in ']"))) {
//            app.userHelper().openLoginForm();
//            User user = new User()
//                    .withEmail("skelon222@bk.ru")
//                    .withPassword("Qwerty$4");
//            app.userHelper().fillLoginForm(user);
//            app.userHelper().submitForm();
//            Assert.assertTrue(app.userHelper().isLogged());
//            app.userHelper().clickOK();
//        }
//        app.userHelper().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
    }

    @Test(groups = {"web"})
    public void addNewCarSuccess() {
        int i = (int) (System.currentTimeMillis() / 3600%1000);
        Car car = new Car()
                .withAddress("Tel Aviv, Israel")
                .withMake("BMW")
                .withModel("M5")
                .withYear("2020")
                .withEngine("2.3")
                .withFuel("Petrol")
                .withGear("MT")
                .withwD("AWD")
                .withDoors("5")
                .withSeats("4")
                .withClasS("C")
                .withFuelConsumption("6.5")
                .withCarRegNumber("101-664-" + i)
                .withPrice("65")
                .withDistanceIncluded("5050")
                .withTypeFeature("type of")
                .withAbout("Very good car!!!");
        app.carHelper().initAddingNewCar();
        app.carHelper().filCarForm(car);
        app.carHelper().attachPhoto();
        app.carHelper().clickButtonSubmit();
     //   Assert.assertTrue(app.carHelper().isCarAdded());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {

        if (!app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
        app.userHelper().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
    }

//================Lombok===================
    @Test
    public void addNewCarLombok() {
        int i = (int) (System.currentTimeMillis() / 3600%1000);
        CarLombok carLombok = CarLombok.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("101-68-" + i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("Very good car!!!")
                .build();
        app.carLombok().initAddingNewCar();
        app.carLombok().filCarForm(carLombok);
        app.carHelper().attachPhoto();
        app.carHelper().clickButtonSubmit();
        Assert.assertTrue(app.carHelper().isCarAdded());
    }
}
