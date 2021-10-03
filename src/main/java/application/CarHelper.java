package application;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase {


    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void initAddingNewCar() {
        click(By.xpath("//a[@id='1']"));
    }

    public void filCarForm(Car car) {
        typeLocation(car.getAddress());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());

        selectFuel(By.id("fuel"), car.getFuel());
        select(By.id("gear"), car.getGear());
        select(By.id("wheelsDrive"), car.getwD());

        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getClasS());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistanceIncluded());
        type(By.cssSelector("input[placeholder='Type feature']"), car.getTypeFeature());
        type(By.id("about"), car.getAbout());

    }

    public void attachPhoto() {
        wd.findElement(By.id("photos"))
                .sendKeys("C:\\Users\\User\\Documents\\QA29\\Github\\QA29_IlCarro_S\\src\\test\\resources\\Photo\\Masya.jpg");
    }

    public void clickButtonSubmit() {
        new WebDriverWait(wd, 15)
                .until(ExpectedConditions
                        .elementToBeClickable(wd.findElement(By.xpath("//button[.='Submit']"))));
        click(By.xpath("//button[.='Submit']"));
    }

    //===========================================================
    private void typeLocation(String address) {
        type(By.xpath("//input[@id='pickUpPlace']"), address);
        pause(1000);
        click(By.cssSelector("div.pac-item"));
        pause(1000);
    }

    private void select(By locator, String option) {//tolko esli element opisan kak "select
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);//selectByIndex(1),selectByVisibleText(" Petrol")

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


    public boolean isCarAdded() {
        click(By.xpath("//button[.='Show car']"));

        return isElementPresent(By.xpath("//h1[.='Car added']"));
    }
}