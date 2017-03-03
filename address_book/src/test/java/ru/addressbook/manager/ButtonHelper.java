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

    public void buttonEdit() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void buttonUpdate() {
        click(By.name("update"));
    }

    public void deleteButton() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }
}
