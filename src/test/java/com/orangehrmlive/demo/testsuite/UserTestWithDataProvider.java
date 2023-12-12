package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.AdminPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestDataWithUserTest;

@Listeners(CustomListeners.class)
public class UserTestWithDataProvider extends BaseTest {

    HomePage homePage;
    AdminPage adminPage;
    LoginPage loginPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        adminPage = new AdminPage();
        loginPage = new LoginPage();
    }


    @Test(dataProvider = "details", dataProviderClass = TestDataWithUserTest.class)
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userRole, String employeeName, String Status) {
        //Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        adminPage.clickOnAdmin();
        //Enter Username <username>
        //Select User Role <userRole>
        //Enter EmployeeName <employeeName>
        //Select Status <status>
        adminPage.addDetails(username,userRole,employeeName,Status);




    }
}
