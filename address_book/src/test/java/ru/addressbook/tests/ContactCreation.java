package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import ru.addressbook.data.ContactData;
import ru.addressbook.manager.ContactHelper;
import ru.addressbook.manager.Manager;

public class ContactCreation extends TestBase{

     public ContactCreation() {super(BrowserType.CHROME);}

    @Test
    public void creationContact() {
        //String[] browers = {BrowserType.IE, BrowserType.CHROME, BrowserType.FIREFOX};
        //for (String s : browers) {


            manager.getNavigationHelper().gotoHomePage();
            manager.getNavigationHelper().gotoAddNew();
            manager.getContactHelper().insertContactDataForm(new ContactData("Pavel", "", "Chupin", "PavelChupin", "", "Y-Solutions", "Novosibirk, B.Bogatkova, 185 - 41", "", "+79137382899", "", "", "pavel.chupin@gmail.com", "", "", "1984", "", "", "", "", "localhost/addressbook"));

            //Нажатие на кнопку Enter сохранить контакт
            manager.getButtonHelper().buttonSaveContact();

            //Выбор пункта меню вернуться на главную страницу
            manager.getNavigationHelper().gotoHomePage();
        //}
    }

}
