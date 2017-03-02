package ru.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.data.LoginData;

/**
 * Created by Summoner on 02.03.2017.
 */
public class SessionHelper extends BaseHelper{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(LoginData loginData) {
        type(By.name("user"), loginData.getUser());
        type(By.name("pass"), loginData.getPassword());
        //Нажатие на кнопку логин
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
