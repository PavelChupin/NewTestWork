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
            manager.getContactHelper().insertContact(new ContactData("Pavel", "", "Chupin", "PavelChupin", "", "Y-Solutions", "Novosibirk, B.Bogatkova, 185 - 41", "", "+79137382899", "", "", "pavel.chupin@gmail.com", "", "", "1984", "", "", "", "", "localhost/addressbook","HomeGroup"));
        }
        //manager.getNavigationHelper().gotoHomePage(); //Закоментировано так как есть про методе insertContact, если не пойдем по if то переход уже сделан в начале метода deletionContact
        manager.getContactHelper().selectElement();
        manager.getButtonHelper().buttonEditContact();
        manager.getContactHelper().insertContactDataForm(new ContactData("Pavel", "", "Chupin", "PavelChupin", "", "Y-Solutions", "Novosibirk, B.Bogatkova, 185 - 41", "", "+79137382899", "", "", "pavel.chupin@gmail.com", "", "", "1984", "", "", "", "", "localhost/addressbook","HomeGroup"),false);
        manager.getButtonHelper().buttonUpdateContact();
        manager.getNavigationHelper().gotoHomePage();
    }
}
