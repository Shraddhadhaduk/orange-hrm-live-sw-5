package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class UserTest extends BaseTest {
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

    @Test(groups = {"sanity", "smoke", "regession"})
    public void adminShouldAddUserSuccessFully() {
        //1.1 Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //1.2 click On "Admin" Tab
        adminPage.clickOnAdmin();
        //1.3 Verify "System Users" Text
        String actualText = viewSystemUsersPage.verifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");
        //1.4 click On "Add" button
        viewSystemUsersPage.clickOnAddButton();
        //1.5 Verify "Add User" Text
        String actualMessage = addUserPage.setVerifyAddUserText();
        String expectedMessage = "Add User";
        Assert.assertEquals(actualMessage, expectedMessage, "Add User is not displayed");
        //	click On "Add" button
        viewSystemUsersPage.clickOnAddButton();
        //1.6 Select User Role "Admin"
        adminPage.selectUserRole("Admin");
        //1.7 enter Employee Name "Ananya Dash"
        addUserPage.setEnterEmployeeName("Ananya Dash");
        //1.8 enter Username
        addUserPage.setEnterTheUserName("Ananya Dash");
        //1.9 Select status "Disable"
        addUserPage.setSelectDisable();
        //1.10 enter password
        homePage.enterPassWord("admin123");
        //1.11 enter Confirm Password
        addUserPage.setConfirmPassword("admin123");
        //1.12 click On "Save" Button
        addUserPage.setClickOnSaveButton();
        //1.13 verify message "Successfully Saved"
//        String actualText1 = adminPage.getSuccessfulText();
//        Assert.assertEquals(actualText1, "Successfully Saved");
    }

    @Test(groups = {"smoke","regrassion"})
    public void searchTheUserCreatedAndVerifyIt(){
        //Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //click On "Admin" Tab
        adminPage.clickOnAdmin();
        //Verify "System Users" Text
        String actualText = adminPage.getSystemUserText();
        Assert.assertEquals(actualText, "System Users");
        //Enter Username
        adminPage.enterUserName1("shraddha");
        //Select User Role
        adminPage.selectUserRole("Admin");
        //Select Status
        adminPage.selectStatus("Disable");
        //Click on "Search" Button
        adminPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        String actualResult = adminPage.setVerifyTheResult();
        String expectedResult = "Virat kholi";
        Assert.assertEquals(actualResult, expectedResult, "Virat Kholi is not displayed");
    }

    @Test(groups = {"regrassion"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(){
        //Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //click On "Admin" Tab
        adminPage.clickOnAdmin();
        //Verify "System Users" Text
        String actualText = adminPage.getSystemUserText();
        Assert.assertEquals(actualText, "System Users");
        //Enter Username
        adminPage.enterUserName1("shraddha");
        //Select User Role
        adminPage.selectUserRole("Admin");
        //Select Status
        adminPage.selectStatus("Disable");
        //Click on "Search" Button
        adminPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        String actualResult = adminPage.setVerifyTheResult();
        String expectedResult = "Virat kholi";
        Assert.assertEquals(actualResult, expectedResult, "Virat Kholi is not displayed");
        //Click on Check box
        adminPage.setTickOnCheckbox();
        //Click on Delete Button
        adminPage.setClickOnDeleteButton();
        //Popup will display
        adminPage.verifyThePopUpWindowIsDisplayed();
        //Click on Ok Button on Popup
        adminPage.clickOnYesButton();
        //verify message "Successfully Deleted"

    }

    @Test(groups = {"regrassion"})
    public void searchTheUserAndVerifyTheMessageRecordFound(){
        //Login to Application
        homePage.enterUserName("Admin");
        homePage.enterPassWord("admin123");
        loginPage.setClickOnLogin();
        //click On "Admin" Tab
        adminPage.clickOnAdmin();
        //Verify "System Users" Text
        String actualText = adminPage.getSystemUserText();
        Assert.assertEquals(actualText, "System Users");
        //Click on "Search" Button verify message "(1) Record Found"
        //Verify username <username>
        //Click on Reset Tab
    }

}