package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    ViewSystemUserPage viewSystemUsersPage;
    LoginPage loginPage;

    @BeforeMethod
    public void inIt() {
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
        viewSystemUsersPage = new ViewSystemUserPage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","smoke","regrassion"})
    public void verifyUserShouldLoginSuccessFully(){
        //Enter username
        //Enter password
        //Click on Login Button
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //Verify "WelCome" Message
    }

    @Test(groups = {"smoke","regrassion"})
    public void verifyThatTheLogoDisplayOnHomePage(){
       //Login To The application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
       //Verify Logo is Displayed
        homePage.displayLogoHome();
    }
    @Test(groups = {"regrassion"})
    public void verifyUserShouldLogOutSuccessFully(){
        //Login To The application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //Click on User Profile logo
        dashboardPage.clickOnProfilePhoto();
        //Mouse hover on "Logout" and click
        dashboardPage.clickOnLogOut();
        //Verify the text "Login Panel" is displayed
        String actualText = dashboardPage.getLoginPanel();
        Assert.assertEquals(actualText, "Login");
    }


}
