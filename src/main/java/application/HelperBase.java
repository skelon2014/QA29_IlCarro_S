package application;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>2;
    }

    public void pause(int milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void backToHomePage(){
        click(By.xpath("//a[@href='/']"));

    }

    public void takeScreenshot(String pathToFile){
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try{
            Files.copy(tmp,screenshot);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

