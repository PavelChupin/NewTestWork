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
        manager.getNavigationHelper().gotoHomePage();
        //Проверим а есть ли контакты для удаления, если нет то добавим контакт
        if (! manager.getContactHelper().isThereSelectObject())
        {
            manager.getContactHelper().insertContact(new ContactData("Pavel", "", "Chupin", "PavelChupin", "", "Y-Solutions", "Novosibirk, B.Bogatkova, 185 - 41", "", "+79137382899", "", "", "pavel.chupin@gmail.com", "", "", "1984", "", "", "", "", "localhost/addressbook", "HomeGroup"));
        }
        //manager.getNavigationHelper().gotoHomePage(); //Закоментировано так как есть про методе insertContact, если не пойдем по if то переход уже сделан в начале метода deletionContact
        manager.getContactHelper().selectElement();
        manager.getButtonHelper().buttonDeleteContact();
        manager.getButtonHelper().alertWindowOk();
        manager.getNavigationHelper().gotoHomePage();

    }
}
