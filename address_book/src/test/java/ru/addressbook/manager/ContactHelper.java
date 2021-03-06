package ru.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.addressbook.data.ContactData;
import ru.addressbook.data.GroupData;

/**
 * Created by Summoner on 02.03.2017.
 */
public class ContactHelper extends BaseHelper {

    private NavigationHelper navigationHelper;
    private ButtonHelper buttonHelper;
    private GroupHelper groupHelper;


    public ContactHelper(WebDriver wd, NavigationHelper navigationHelper, ButtonHelper buttonHelper, GroupHelper groupHelper) {
        super(wd);
        this.navigationHelper = navigationHelper;
        this.buttonHelper = buttonHelper;
        this.groupHelper = groupHelper;
    }

    public void insertContactDataForm(ContactData contactData, boolean flag) {
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

        //Заполним поле группа если передан флаг добавления контакта
        if(flag){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else{//Если не передан, то выполним проверку что бы небыло ошибок/исключения
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());
    }

    public void insertContact(ContactData contactData) {
        //navigationHelper.gotoHomePage(); //Не нужен так как переход уже сделан тестами
        //Нажмем пункт меню Добавить контакт
        navigationHelper.gotoAddNewPage();

        //Если группа передана, то проверим ее существование и если группы нету, то добавим ее
        if (contactData.getGroup() != null) {
            //Поищем группу среди доступных, если не найдена то добавим новую
            if (findGroup(contactData.getGroup()) != 1) {
                groupHelper.insertGroup(new GroupData(contactData.getGroup(), contactData.getGroup(), contactData.getGroup()));
                navigationHelper.gotoAddNewPage();
            }
        }
        //Заполним форму данными контакта
        insertContactDataForm(contactData,true);

        //Нажатие на кнопку Enter сохранить контакт
        buttonHelper.buttonSaveContact();

        //Выбор пункта меню вернуться на главную страницу
        navigationHelper.gotoHomePage();
    }

}



