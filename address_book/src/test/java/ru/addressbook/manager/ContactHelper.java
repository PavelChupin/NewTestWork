package ru.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.data.ContactData;

/**
 * Created by Summoner on 02.03.2017.
 */
public class ContactHelper extends BaseHelper{

    private NavigationHelper navigationHelper;
    private ButtonHelper buttonHelper;


    public ContactHelper(WebDriver wd, NavigationHelper navigationHelper, ButtonHelper buttonHelper) {
        super(wd);
        this.navigationHelper = navigationHelper;
        this.buttonHelper  = buttonHelper;
    }

    public void insertContactDataForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());

        type(By.name("homepage"), contactData.getHomepage());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[1]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[12]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[12]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[1]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[13]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[13]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[7]"));
        }
        type(By.name("byear"), contactData.getByear());
        /*if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).click();
        }*/

        type(By.name("ayear"), contactData.getAyear());

        /*if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).click();
        }*/
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());
    }

   public void insertContact(ContactData contactData) {
        navigationHelper.gotoHomePage();
        navigationHelper.gotoAddNew();
        insertContactDataForm(contactData);

        //Нажатие на кнопку Enter сохранить контакт
        buttonHelper.buttonSaveContact();

        //Выбор пункта меню вернуться на главную страницу
        navigationHelper.gotoHomePage();
    }

    //
    public boolean isThereSelectObject() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectElement() {
        click(By.name("selected[]"));
    }
}
