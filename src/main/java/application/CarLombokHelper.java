package application;

import models.CarLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarLombokHelper extends HelperBase{
    public CarLombokHelper(WebDriver wd) {
        super(wd);
    }
    public void initAddingNewCar() {
        click(By.xpath("//a[@id='1']"));
    }
    public void filCarForm(CarLombok carL) {
        typeLocation(carL.getAddress());
        type(By.id("make"), carL.getMake());
        type(By.id("model"), carL.getModel());
        type(By.id("year"), carL.getYear());
        type(By.id("engine"), carL.getEngine());
        selectFuel(By.id("fuel"), carL.getFuel());
        select(By.id("gear"), carL.getGear());
        select(By.id("wheelsDrive"), carL.getWD());
        type(By.id("doors"), carL.getDoors());
        type(By.id("seats"), carL.getSeats());
        type(By.id("class"), carL.getClasS());
        type(By.id("fuelConsumption"), carL.getFuelConsumption());
        type(By.id("serialNumber"), carL.getCarRegNumber());
        type(By.id("price"), carL.getPrice());
        type(By.id("distance"), carL.getDistanceIncluded());
        type(By.xpath("//input[@placeholder='Type feature']"), carL.getTypeFeature());
        type(By.id("about"), carL.getAbout());
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

    private void selectFuel(By locator, String option) {//tolko esli element opisan kak "select"
        Select selecet = new Select(wd.findElement(locator));
        if (option.equals("Petrol")) {//selectByIndex(1),selectByVisibleText(" Petrol")
            selecet.selectByValue(option);
        } else if (option.equals("Diesel")) {
            selecet.selectByValue(option);
        } else if (option.equals("Hybrid")) {//selectByIndex(1),selectByVisibleText(" Petrol")
            selecet.selectByValue(option);
        } else if (option.equals("Electric")) {//selectByIndex(1),selectByVisibleText(" Petrol")
            selecet.selectByValue("Electric");
        } else if (option.equals("Gas")) {//selectByIndex(1),selectByVisibleText(" Petrol")
            selecet.selectByValue("Gas");
        }
    }

    private void select(By locator, String option) {//tolko esli element opisan kak "select
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);//selectByIndex(1),selectByVisibleText(" Petrol")

    }

}
