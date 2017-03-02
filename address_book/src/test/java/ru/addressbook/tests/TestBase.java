package ru.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.manager.Manager;

/**
 * Created by Summoner on 02.03.2017.
 */
public class TestBase {

    protected final Manager manager;


    public TestBase(String browers){
        manager = new Manager(browers);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        manager.init();
    }

    @AfterMethod
    public void tearDown() {
        manager.stop();
    }

    public Manager getManager() {
        return manager;
    }
}
