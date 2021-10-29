package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentHelper extends HelperBase {
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
            click(By.cssSelector(".search-results a:nth-child(1)"));
    }

    public void selectRentNow() {
        click(By.xpath("//button[normalize-space()='Rent now!!']"));
    }

    public void fillOrderForm(User user) {
        //  if(isElementPresent(By.cssSelector(".navigator"))){
        //    click(By.cssSelector(".navigator"));
        type(By.id("firstName"), user.getName());
        type(By.id("secondName"), user.getLastName());
        type(By.id("email"), user.getEmail());

        type(By.id("phone"), user.getPhoneNumber());
        click(By.xpath("//button[text()='Reserve']"));


        // backToHomePage();
    }

    public boolean isOrderSuccess() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return wd.findElement(By.cssSelector(".dialog-container")).getText().contains("Order success");
    }

    public boolean isRentNowAvailable() {
        return wd.findElement(By.xpath("//button[normalize-space()='Rent now!!']")).isSelected();
    }

    public void closeOrder() {
        click(By.xpath("//button[.='Close']"));
    }
}
