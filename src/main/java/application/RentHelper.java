package application;

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

            click(By.xpath("(//div[@class='car-img-container ng-star-inserted'])[5]"));

            click(By.xpath("//button[normalize-space()='Rent now!!']"));
            type(By.xpath("//input[@id='phone']"), "123456789");
            click(By.cssSelector("button[type='submit']"));
            click((By.xpath("//button[normalize-space()='Close']")));
            backToHomePage();

    }
}
