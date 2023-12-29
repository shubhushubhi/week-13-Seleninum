package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//li[@class='dropdown open']/a") //Desktop xpath
    WebElement Desktops;
    public void clickOnDesktopLink() {
        log.info("Clicking on Desktop link :"); // create method for desktop
        clickOnElement(Desktops);
    }

//    @CacheLookup
//    @FindBy(className = "ico-login")
//    WebElement loginLink;
//
//    @CacheLookup
//    @FindBy(linkText = "Register")
//    WebElement registerLink;
//
//    @CacheLookup
//    @FindBy(xpath = "//div[@class='header-menu']/child::ul[1]/li/a")
//    List<WebElement> topMenuList;
//
//    public void clickOnLoginLink() {
//        log.info("Clicking on login link :");
//        clickOnElement(loginLink);
//
//    }
//
//    public void clickOnRegisterLink() {
//        log.info("Clicking on register link : " + registerLink.toString());
//        clickOnElement(registerLink);
//    }
//
//
//    public String verifyLoginLink() {
//        return getTextFromElement(loginLink);
//    }
//
//    public void clickOnMenuTab(String tab) {
//        for (WebElement menu : topMenuList) {
//            if (menu.getText().contains(tab)) {
//                clickOnElement(menu);
//                break;
//            }
//        }
//    }

}
