package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    CarLombokHelper carLombok;
    SearchHelper search;
    String browser;
    RentHelper rentHelper;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Start browser CHROME");
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Start browser FIREFOX");
        }
//wd = new ChromeDriver();

        wd.register(new MyListener());

        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        carLombok = new CarLombokHelper(wd);
        search = new SearchHelper(wd);
        rentHelper = new RentHelper(wd);
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

    public RentHelper rentHelper() {
        return rentHelper;
    }
}
