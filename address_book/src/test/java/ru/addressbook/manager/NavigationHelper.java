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

    public void gotoAddNewPage() {
        if (isElementPresent(By.tagName("h1")) //Если на странице есть элемент заголовок (тег)
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry") //Если значение элемента заголовок равно проверяемому значению
                && isElementPresent(By.name("submit"))) { /*Если на странице есть кнопка с именем*/
            return;
        }
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {
        if (isElementPresent(By.id("maintable"))){ //если есть таблица, то это страница Home
            return;
        }
        click(By.linkText("home"));
    }

    public void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1")) //Если на странице есть элемент заголовок (тег)
                && wd.findElement(By.tagName("h1")).getText().equals("Groups") //Если значение элемента заголовок равно проверяемому значению
                && isElementPresent(By.name("new"))) { /*Если на странице есть кнопка с именем*/
            return;
        }
        click(By.linkText("groups"));
    }

    public void gotoGroupToPage() {
        if (isElementPresent(By.tagName("h1")) //Если на странице есть элемент заголовок (тег)
                && wd.findElement(By.tagName("h1")).getText().equals("Groups") //Если значение элемента заголовок равно проверяемому значению
                && isElementPresent(By.name("new"))) { /*Если на странице есть кнопка с именем*/
            return;
        }
        click(By.linkText("group page"));
    }
}
