package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.addressbook.data.ContactData;

/**
 * Created by Summoner on 03.03.2017.
 */
public class ContactDeletion  extends TestBase{

    public ContactDeletion() {
        super(BrowserType.FIREFOX);
    }

    @Test
    public void deletionContact(){

        //Проверим а есть ли контакты для модификации, если нет то добавим контакт
        if (! manager.getContactHelper().isThereSelectObject())
        {
            manager.getContactHelper().insertContact(new ContactData("Pavel", "", "Chupin", "PavelChupin", "", "Y-Solutions", "Novosibirk, B.Bogatkova, 185 - 41", "", "+79137382899", "", "", "pavel.chupin@gmail.com", "", "", "1984", "", "", "", "", "localhost/addressbook"));
        }

        manager.getNavigationHelper().gotoHomePage();
        manager.getContactHelper().selectElement();
        manager.getButtonHelper().deleteButton();
        manager.getButtonHelper().alertWindowOk();
        manager.getNavigationHelper().gotoHomePage();

    }
}
