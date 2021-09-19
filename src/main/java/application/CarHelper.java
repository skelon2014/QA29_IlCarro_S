package application;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarHelper extends HelperBase {
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void initAddingNewCar() {
        click(By.xpath("//a[@href='/let-car-work']"));
    }

    public void filCarForm(Car car) {
        typeLocation(car.getAddress());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());
        type(By.xpath("//select[@id='fuel']"), car.getFuel());
        //  type(By.xpath(""));
    }
//===========================================================
    private void typeLocation(String address) {
        type(By.xpath("//input[@id='pickUpPlace']"), address);
        pause(1000);
        click(By.cssSelector("div.pac-item"));
        pause(1000);
    }
}
