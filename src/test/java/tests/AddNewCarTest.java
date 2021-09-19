package tests;

import models.Car;
import models.CarNew;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("skelon222@bk.ru", "Qwerty$4");
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isLogged());

    }

    @Test
    public void addNewCarSuccess() {
        int i = (int) (System.currentTimeMillis() / 36000000);
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
                .withCarRegNumber("100-66-" + i)
                .withPrice("65")
                .withDistanceIncluded("500")
                .withTypeFeature("type of")
                .withAbout("Very good car!!!");
        app.carHelper().initAddingNewCar();
        app.carHelper().filCarForm(car);
        //  app.carHelper().attachPhoto();
        //  app.carHelper().clickButtonSubmit();
        //  Assert.assertTrue(app.carHelper().isCarAdded);


    }

    @AfterMethod
    public void postCondition() {

        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }

    }

    @Test
    public void addNewCarLombok() {
        int i = (int) (System.currentTimeMillis() / 36000000);
        CarNew car = CarNew.builder()
                .carRegNumber("")
                .address("")
                .about("")
                .make("")
                .model("")
                .clasS("")
                .distanceIncluded("")
                .doors("")
                .engine("")
                .fuel("")
                .fuelConsumption("")
                .gear("")
                .price("")
                .seats("")
                .wD("")
                .typeFeature("")
                .year("")
                .build();

    }

}
