package ru.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.data.LoginData;

/**
 * Created by Summoner on 02.03.2017.
 */
public class BaseHelper {
    protected WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public void alertWindowOk() {
        wd.switchTo().alert().accept();
    }

    public void selectElement() {
        click(By.name("selected[]"));
    }

    public boolean isThereSelectObject() {
        return isElementPresent(By.name("selected[]"));
    }

    protected boolean isElementPresent(By locator) {
        try{
            wd.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }


}
