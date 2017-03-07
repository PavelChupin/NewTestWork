package ru.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.addressbook.data.GroupData;

/**
 * Created by Summoner on 07.03.2017.
 */
public class GroupHelper extends BaseHelper{

    private NavigationHelper navigationHelper;
    private ButtonHelper buttonHelper;

    public GroupHelper(WebDriver wd, NavigationHelper navigationHelper, ButtonHelper buttonHelper) {
        super(wd);
        this.navigationHelper = navigationHelper;
        this.buttonHelper = buttonHelper;
    }

    public void insertGroupDataForm(GroupData groupData) {
        type(By.name("group_name"),groupData.getName());
        type(By.name("group_header"),groupData.getHeader());
        type(By.name("group_footer"),groupData.getFooter());
    }

    public void insertGroup(GroupData groupData) {
        //Выполним переход на страницу работы с группами, нужно если в процессе добавления контакта группы не существует
        navigationHelper.gotoGroupPage();

        //Нажмем кнопку новая группа
        buttonHelper.buttonNewGroup();

        //Заполним форму данными
        insertGroupDataForm(groupData);

        //Нажимамем кнопку сохранить группу
        buttonHelper.buttonSaveGroup();

        //Возвращается на страницу групп
        navigationHelper.gotoGroupToPage();

        //Выполним переход на страницу работы с группами
        navigationHelper.gotoGroupPage();
    }
}
