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

    public void buttonEditContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void buttonUpdateContact() {
        click(By.name("update"));
    }

    public void buttonDeleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void buttonSaveGroup() {
        click(By.name("submit"));
    }

    public void buttonNewGroup() {
        click(By.name("new"));
    }
}
