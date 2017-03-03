package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import ru.addressbook.data.ContactData;

public class ContactCreation extends TestBase{

     public ContactCreation() {super(BrowserType.CHROME);}

    @Test
    public void creationContact() {
        //String[] browers = {BrowserType.IE, BrowserType.CHROME, BrowserType.FIREFOX};
        //for (String s : browers) {
        manager.getContactHelper().insertContact(new ContactData("Pavel", "", "Chupin", "PavelChupin", "", "Y-Solutions", "Novosibirk, B.Bogatkova, 185 - 41", "", "+79137382899", "", "", "pavel.chupin@gmail.com", "", "", "1984", "", "", "", "", "localhost/addressbook"));
        //}
    }

}
