package ru.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Summoner on 02.03.2017.
 */
public class NavigationHelper extends BaseHelper{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoAddNew() {
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {

        click(By.linkText("home"));
    }
}
