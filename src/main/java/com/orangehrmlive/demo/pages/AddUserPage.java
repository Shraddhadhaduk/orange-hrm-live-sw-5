package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']" )
    static WebElement verifyAddUserText;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']" )
    WebElement enterEmployeeName;
    @CacheLookup
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']" )
    WebElement enterTheUserName;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Disabled')]")
    WebElement selectDisable;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//font[contains(text(),'Save')]")
    WebElement clickOnSaveButton;




    public String setVerifyAddUserText() {
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
        return getTextFromElement(verifyAddUserText);
    }
    public void setEnterEmployeeName(String employeeName){
        sendTextToElement(enterEmployeeName, employeeName);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setEnterTheUserName(String userName){
        sendTextToElement(enterTheUserName,userName);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setSelectDisable(){
        selectByIndexFromDropDown(selectDisable,0);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setConfirmPassword(String password){
        sendTextToElement(confirmPassword,password);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
    public void setClickOnSaveButton(){
        clickOnElement(clickOnSaveButton);
        CustomListeners.test.log(Status.PASS, "Message is not displayed");
    }
}
