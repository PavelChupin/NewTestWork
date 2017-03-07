package ru.addressbook.manager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.data.LoginData;

import java.util.List;

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
        //Проверим переданы ли данные для изменения, если не переданы ни чего не меняем
        if (text != null) {
            //Проверим переданное значение отличается от уже заполненого, если нет менять ни чего не нужно
            if (! text.equals(wd.findElement(locator).getAttribute("value"))) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
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
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected int findGroup(String groupName) {
        List<WebElement> groups = wd.findElement(By.name("new_group")).findElements(By.tagName("option"));
        for (WebElement group : groups) {
            if (group.getText().equals(groupName)) {
                return 1;
            }
        }
        return 0;
    }
}
