package com.first.framework;

import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public interface XpathResources {
    ConfigResource obj=new ConfigResource();
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



  //===================== Test Cases =====================
    void loginFunctionality();
    void searchItemFunctionality();
    void itemSelectionFunctionality();
    void purchaseFunctionality();
}
