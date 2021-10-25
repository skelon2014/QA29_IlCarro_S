package application;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> validDataLoginClass() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"skelon222@bk.ru", "Qwerty$4"});
        list.add(new Object[]{"skelon22@bk.ru", "Qwerty$4"});
        list.add(new Object[]{"skelon202@bk.ru", "Qwerty$4"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> invalidDataLoginClass() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"skelon222@bk.ru", "Qw4erty4"});
        list.add(new Object[]{"skelon22@bk.ru", "we4rty$4"});
        list.add(new Object[]{"skelon202@bk.ru", "Qwerty$qq"});
     //   list.add(new Object[]{"skelon222bk.ru", "Qw4erty4"});
        list.add(new Object[]{"skelon22@bkru", "we4rty$4"});
   //     list.add(new Object[]{"skelon202@bk ru", "Qwerty$qq"});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>dataLoginCSV() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while(line != null){
            String[]split = line.split(",");
            list.add(new Object[]{split[0],split[1]});
            line = reader.readLine();
        }
        return list.iterator();
    }
}