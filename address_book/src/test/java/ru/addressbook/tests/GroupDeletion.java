package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.addressbook.data.GroupData;

/**
 * Created by Summoner on 07.03.2017.
 */
public class GroupDeletion extends  TestBase{


    public GroupDeletion() {
        super(BrowserType.FIREFOX);
    }

    @Test
    public void deletionGroup()
    {
        manager.getNavigationHelper().gotoGroupPage();
        //Проверяем есть ли на странице объекты для удаления
        if(! manager.getGroupHelper().isThereSelectObject()){
            manager.getGroupHelper().insertGroup(new GroupData("test1", "test1", "test1"));
        }

    }
}
