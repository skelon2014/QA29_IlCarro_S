package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentHelper extends HelperBase{
    public RentHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isRentButtonActive() {
        return wd.findElement(By.xpath("//button[normalize-space()='Rent now!!']")).isSelected();
    }

    public void choiceCar() {

            click(By.cssSelector(".search-results a:last-child"));

            click(By.xpath("//button[normalize-space()='Rent now!!']"));
            type(By.xpath("//input[@id='phone']"), "+123456789");
            click(By.cssSelector("button[type='submit']"));
            click((By.xpath("//button[normalize-space()='Close']")));
            backToHomePage();

    }

    public void selectAuto() {
        click(By.xpath("//div[@class='car-img-container ng-star-inserted'][1])"));
    }

    public void selectRentNow() {

        click(By.xpath("//button[normalize-space()='Rent now!!']"));
    }

    public void fillOrderForm(User user) {
        type(By.xpath("//input[@id='phone']"), "123456789");
        click(By.cssSelector("button[type='submit']"));
        click((By.xpath("//button[normalize-space()='Close']")));
        backToHomePage();
    }

}
