package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.addressbook.data.ContactData;

/**
 * Created by Summoner on 03.03.2017.
 */
public class ContactModification extends TestBase{

    public ContactModification() {
        super(BrowserType.CHROME);
    }

    @Test
    public void modificationContact(){
        manager.getNavigationHelper().gotoHomePage();
        //Проверим а есть ли контакты для модификации, если нет то добавим контакт
        if (! manager.getContactHelper().isThereSelectObject())
        {
            manager.getNavigationHelper().gotoHomePage();
            manager.getNavigationHelper().gotoAddNewPage();
            manager.getContactHelper().insertContact(new ContactData("Pavel", "", "Chupin", "PavelChupin", "", "Y-Solutions", "Novosibirk, B.Bogatkova, 185 - 41", "", "+79137382899", "", "", "pavel.chupin@gmail.com", "", "", "1984", "", "", "", "", "localhost/addressbook"));
        }

        manager.getNavigationHelper().gotoHomePage();
        manager.getContactHelper().selectElement();
        manager.getButtonHelper().buttonEdit();
        manager.getContactHelper().insertContactDataForm(new ContactData("Pavel", "", "Chupin", "PavelChupin", "", "Y-Solutions", "Novosibirk, B.Bogatkova, 185 - 41", "", "+79137382899", "", "", "pavel.chupin@gmail.com", "", "", "1984", "", "", "", "", "localhost/addressbook"));
        manager.getButtonHelper().buttonUpdate();
        manager.getNavigationHelper().gotoHomePage();
    }
}
