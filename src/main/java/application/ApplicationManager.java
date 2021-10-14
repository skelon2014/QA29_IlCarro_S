package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    CarLombokHelper carLombok;
    SearchHelper search;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        carLombok = new CarLombokHelper(wd);
        search = new SearchHelper(wd);
    }

    public void stop(){
        wd.quit();
    }

    public UserHelper userHelper() {
        return userHelper;
    }

    public CarHelper carHelper() {
        return carHelper;
    }

    public CarLombokHelper carLombok() {
        return carLombok;
    }

    public SearchHelper search() {
        return search;
    }
}
