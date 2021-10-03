package application;

import models.CarLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarLombokHelper extends HelperBase{
    public CarLombokHelper(WebDriver wd) {
        super(wd);
    }
    public void initAddingNewCar() {
        click(By.xpath("//a[@id='1']"));
    }
    public void filCarForm(CarLombok car) {
        typeLocation(car.getAddress());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());
        typeFuel(car.getFuel());
        //  type(By.xpath(""));
    }

    private void typeLocation(String address) {
        type(By.xpath("//input[@id='pickUpPlace']"), address);
        pause(1000);
        click(By.cssSelector("div.pac-item"));
        pause(1000);
    }
    private void typeFuel(String fuel) {
        click(By.id("fuel"));
        pause(1000);
        click(By.cssSelector("option.Petrol"));
        pause(1000);
    }
}
