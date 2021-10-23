package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;

public class SearchHelper extends HelperBase {
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        selectData(dataFrom, dataTo);
        pause(1000);
    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
      //  click(By.cssSelector("div.pac-item"));
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector(".pac-item"))).click().perform();
       pause(1000);
    }

    private void selectData(String dataFrom, String dataTo) {
        if(isElementPresent(By.id("dates"))) {
            click(By.id("dates"));
        }else{
            click(By.cssSelector("[formcontrolname='dates']"));
        }
        String[] dataF = dataFrom.split("/");
        String[] dataT = dataTo.split("/");
        String locatorFrom = String.format("//div[text()=' %s ']", dataF[1]);
        //   String locatorFrom = S"//div[text()='"+dataF[1]+"']";
        String locatorTo = String.format("//div[text()=' %s ']", dataT[1]);
        click(By.xpath(locatorFrom));
        click(By.xpath(locatorTo));
    }

    public void fillSearchFormInFuture(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        selectDataInFuture(dataFrom, dataTo);
        pause(3000);
    }

    private void selectDataInFuture(String dataFrom, String dataTo) {
        if(isElementPresent(By.id("dates"))) {
            click(By.id("dates"));
        }else{
            click(By.cssSelector("[formcontrolname='dates']"));
        }
        int monthNow = LocalDate.now().getMonthValue();
        int yearNow = LocalDate.now().getYear();

        String[] dataF = dataFrom.split("/");
        String[] dataT = dataTo.split("/");

        int mf = Integer.parseInt(dataF[0]);
        int mt = Integer.parseInt(dataT[0]);
        int df = Integer.parseInt(dataF[1]);
        int dt = Integer.parseInt(dataT[1]);
        int yf = Integer.parseInt(dataF[2]);
        int yt = Integer.parseInt(dataT[2]);

        int from = mf - monthNow + (yf - yearNow) * 12;
        int period = mt - mf + (yt - yearNow) * 12;

        if (from >= 0) {
            while (from > 0) {
                click(By.xpath("//button[@aria-label='Next month']"));
                from--;
            }
            String locatorFrom = String.format("//div[text()=' %s ']", df);
            click(By.xpath(locatorFrom));
            pause(1000);

        } else {
            System.out.println("Invalid date");
        }

        if (period > 0) {
            while (period > 0) {
                click(By.xpath("//button[@aria-label='Next month']"));
                period--;
            }
            String locatorTo = String.format("//div[text()=' %s ']", dt);
            click(By.xpath(locatorTo));
            pause(1000);
        } else if (period == 0 && dt - df >= 0) {
            String locatorTo = String.format("//div[text()=' %s ']", dt);
            click(By.xpath(locatorTo));
        } else {
            System.out.println("Invalid period of dates");
        }
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void typeData(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        pause(1000);
        if(isElementPresent(By.id("dates"))) {
            type(By.id("dates"), dataFrom + " - " + dataTo);
        }else{
            type(By.cssSelector("[formcontrolname='dates']"),dataFrom + " - " + dataTo);
        }
    //    type(By.id("dates"), dataFrom + " - " + dataTo);
        click(By.cssSelector(".cdk-overlay-container"));
    }

    public boolean isButtonYallaActive() {
        WebElement el = wd.findElement(By.xpath("//button[@type='submit']"));
        return el.isEnabled();
    }
    public boolean isSearchFormPresent(){
        return wd.findElements(By.xpath("//h1[text()='Find your car now!']")).size()>0;
    }
}


