package ru.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.addressbook.data.LoginData;
//import sun.plugin2.util.BrowserType;
import org.openqa.selenium.remote.BrowserType;
import java.util.concurrent.TimeUnit;

/**
 * Created by Summoner on 02.03.2017.
 */
public class Manager {

    private ButtonHelper buttonHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    //private BaseHelper baseHelper;
    private ContactHelper contactHelper;
    private String browserType;

    WebDriver wd;

    public Manager(String browserType) {
        this.browserType = browserType;
    }

    public void init() {
        //String browers = BrowserType.FIREFOX;
        if (browserType.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if (browserType.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if (browserType.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //Запуск стартовой страници
        wd.get("http://localhost/addressbook/");

        navigationHelper = new NavigationHelper(wd);
        buttonHelper = new ButtonHelper(wd);
        contactHelper = new ContactHelper(wd, navigationHelper, buttonHelper);

        //Авторизация
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login(new LoginData("admin", "secret"));
    }

    public void stop() {
        wd.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ButtonHelper getButtonHelper() {
        return buttonHelper;
    }
}
