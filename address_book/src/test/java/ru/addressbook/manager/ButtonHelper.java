package ru.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Summoner on 02.03.2017.
 */
public class ButtonHelper extends BaseHelper{

    public ButtonHelper(WebDriver wd) {
        super(wd);
    }

    public void buttonSaveContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
}
