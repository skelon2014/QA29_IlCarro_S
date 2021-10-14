package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("[href^='/login']"));
    }

    public void openRegistrationForm() {
        click(By.cssSelector("[href^='/regist']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#email"), email);
        type(By.id("password"), password);
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {

        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.cssSelector("#email"), email);
        type(By.id("password"), password);
    }

    public void submitForm() {
        click(By.cssSelector("button[type='submit']"));
    }

    public boolean isLogged() {
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement dialog = wd.findElement(By.cssSelector(".message"));
       // System.out.println(dialog.getText());
        return dialog.getText().equals("Logged in success");
    }

    public boolean isRegistrated() {
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement dialogReg = wd.findElement(By.cssSelector(".message"));
        System.out.println(dialogReg.getText());

        return dialogReg.getText().equals("You are logged in success");
    }

    public void clickOK() {

        if (isElementPresent(By.xpath("//button[@type='button']"))) {
            click(By.xpath("//button[@type='button']"));
        }
    }

    public void logout() {
        if (isElementPresent(By.xpath("//a[.=' Logout ']"))) {
            click(By.xpath("//a[.=' Logout ']"));
        }
    }

    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public void deleteLogin() {
        click(By.xpath("//a[.='Delete account']"));
        click(By.xpath("//button[.='Delete']"));
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public boolean isErrorPasswordDisplaed() {
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement error = wd.findElement(By.xpath("//div[@class='error']"));
        System.out.println(error.getText());
        return isElementPresent(By.xpath("//div[@class='error']"));
    }

    public boolean isYallaButtonActive() {

        return wd.findElement(By.cssSelector("button[type='submit']")).isSelected();
    }
//===================fluentInterface================
public void fillRegistrationForm(User user) {
    type(By.id("name"),user.getName());
    type(By.id("lastName"), user.getLastName());
    type(By.cssSelector("#email"), user.getEmail());
    type(By.id("password"), user.getPassword());
}

    public void fillLoginForm(User user) {
        type(By.cssSelector("#email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }
}
