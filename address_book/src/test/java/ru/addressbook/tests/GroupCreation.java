package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.addressbook.data.GroupData;

/**
 * Created by Summoner on 07.03.2017.
 */
public class GroupCreation extends  TestBase{


    public GroupCreation() {
        super(BrowserType.FIREFOX);
    }

    @Test
    public void creationGroup()
    {
        manager.getNavigationHelper().gotoGroupPage();
        manager.getGroupHelper().insertGroup(new GroupData("test1", "test1", "test1"));
    }

}
