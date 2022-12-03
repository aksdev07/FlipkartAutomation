package com.first.framework;

import org.openqa.selenium.By;

import java.io.IOException;

public interface XpathResources {
    BaseTest obj=new BaseTest("a");
    String tshirtName = "'Solid Men Mandarin Collar Blue, Maroon T-Shirt'";
    String productString=obj.getProductName();
    //=====================  FLIPKART SECTION ===================================
    //String popUpUserID = "//form[@autocomplete=\"on\"]//input[@type=\"text\"]";
    String popUpUserID = "//form[@autocomplete='on']//input[@type='text']";
    String popUpPassword = "//input[@type='password']";
    String requestOtp = "//button[contains(text(),'Request OTP')]";
    String otpPos = "//input[@type='text']";
    String popUpLoginButton = "//button[@type='submit']/child::span";
    String popUpWindow = "//div[@class='_3Njdz7']";
    String search = "//input[@name='q']";
    String searchClick = "//button[@type='submit']";
    String oneTshirt = String.format("//a[contains(text(),%s)]", tshirtName);
    By productXpath= By.xpath(String.format("//input[@value='%s']",productString));
    String tshirtAll = "//div[@class='_1HmYoV _35HD7C']//div[contains(@data-id,'TSH')]//a";


    String userIdValue= "userid";
    String pwdValue="password";

    String tShirtName = "Striped Men Round Neck White T-Shirt";


  String msgField="//div[@data-tab='6']";
  String send="//span[@data-icon='send']";
  //===================== Test Cases =====================
    void loginFunctionality();
    void searchItemFunctionality() throws IOException;
    void itemSelectionFunctionality();
    void purchaseFunctionality();
    void enterPin();
}
