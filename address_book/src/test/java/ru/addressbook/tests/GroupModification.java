package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.addressbook.data.GroupData;

/**
 * Created by Summoner on 07.03.2017.
 */
public class GroupModification extends  TestBase{


    public GroupModification() {
        super(BrowserType.FIREFOX);
    }

    @Test
    public void modificationGroup()
    {
        manager.getNavigationHelper().gotoGroupPage();
        //Проверяем есть ли на странице объекты для изменения
        if(! manager.getGroupHelper().isThereSelectObject()){
            manager.getGroupHelper().insertGroup(new GroupData("test1", "test1", "test1"));
        }
    }
}
