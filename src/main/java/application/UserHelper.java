package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

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

    public boolean isLogged() throws InterruptedException {
        String text = wd.findElement(By.xpath("//h2[.='Logged in success']")).getText();
        Thread.sleep(2000);
        click(xpath("//button[.='Ok']"));
        return text.equals("Logged in success");
    }

    public boolean isRegistrated() throws InterruptedException {
        String text = wd.findElement(By.cssSelector(".message")).getText();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(2000);
        click(xpath("//button[.='Ok']"));
        return text.equals("You are logged in success");
    }

    public void clickOK() {
        click(xpath("//button[@type='button']"));
    }

    public void logout() {
        // click(By.cssSelector("[href^='/logout']"));
        click(By.xpath("//a[.=' Logout ']"));
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public void deleteLogin() {
        click(By.xpath("//a[.='Delete account']"));
        click(By.xpath("//button[.='Delete']"));
    }
}
