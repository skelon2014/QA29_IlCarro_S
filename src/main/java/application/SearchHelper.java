package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class SearchHelper extends HelperBase {
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        selectData(dataFrom, dataTo);
        pause(3000);
    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));
        click(By.id("dates"));
    }

    private void selectData(String dataFrom, String dataTo) {
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
        int monthNow = LocalDate.now().getMonthValue();
        String[] dataF = dataFrom.split("/");
        String[] dataT = dataTo.split("/");

        int mf = Integer.parseInt(dataF[0]);
        int mt = Integer.parseInt(dataT[0]);
        int df = Integer.parseInt(dataF[1]);
        int dt = Integer.parseInt(dataT[1]);

        int from = mf - monthNow;
        int period = mt - mf;

            if (from >= 0) {
                while (from > 0) {
                    click(By.xpath("//button[@aria-label='Next month']"));
                    from--;
                }
                String locatorFrom = String.format("//div[text()=' %s ']", df);
                click(By.xpath(locatorFrom));
                pause(1000);

            }else {
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
            } else if(period == 0 && dt - df >= 0) {
                String locatorTo = String.format("//div[text()=' %s ']", dt);
                click(By.xpath(locatorTo));
            }else{
                System.out.println("Invalid period of dates");
            }
        }



    //  System.out.println(monthNow);
    //click.inputData
    //which month now?
    //int month = LocalDate.now().getMonthValue();
    //if(int i = dataF[0] -month>=0){
    // while(i>0){
    //   click(By....)
    //   --i;
    // }


    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }
}

