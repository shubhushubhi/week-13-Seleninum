package electronics;

import browsertesting.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;

import java.awt.*;

public class ElectronicsTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void textverified(){
//1.1 Mouse Hover on “Electronics” Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a")).click();

//1.2 Mouse Hover on “Cell phones” and click
        driver.findElement(By.xpath("//ul[@class='sublist']/li[2]/a")).click();

//1.3 Verify the text “Cell phones”
        String actualText= driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualText);
       String expectedText= "Cell phones";
       Assert.assertEquals(actualText,expectedText);
 }
@Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//2.1 Mouse Hover on “Electronics” Tab
    driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a")).click();
//2.2 Mouse Hover on “Cell phones” and click
    driver.findElement(By.xpath("//ul[@class='sublist']/li[2]/a")).click();
//2.3 Verify the text “Cell phones”
    String actualText= driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
    System.out.println(actualText);
    String expectedText= "Cell phones";
    Assert.assertEquals(actualText,expectedText);

//2.4 Click on List View Tab
   driver.findElement(By.xpath("//div[@class='product-viewmode']/a[2]")).click();

//2.5 Click on product name “Nokia Lumia 1020” link
    Thread.sleep(2000);
   driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();

//2.6 Verify the text “Nokia Lumia 1020”
    String actualText1= driver.findElement(By.xpath("//div[@class='overview']/div/h1")).getText();
    System.out.println(actualText1);
    String expectedText1= "Nokia Lumia 1020";
    Assert.assertEquals(actualText1,expectedText1);

//2.7 Verify the price “$349.00”
    String actualText2= driver.findElement(By.xpath("//div[@class='prices']/div/span")).getText();
    System.out.println(actualText2);
    String expectedText2= "$349.00";
    Assert.assertEquals(actualText2,expectedText2);

//2.8 Change quantity to 2
    driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear(); // clear Qty 1
    driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2"); //same xpathe entre new Qty

//2.9 Click on “ADD TO CART” tab
    driver.findElement(By.xpath("//button[@id='add-to-cart-button-20']")).click();

//    2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
    //After that close the bar clicking on the cross button.
    String actualText3= driver.findElement(By.xpath("//div[@id='bar-notification']/div/p")).getText();
    System.out.println(actualText3);
   String expectedText3= "The product has been added to your shopping cart";
   Assert.assertEquals(actualText3,expectedText3);

//After that close the bar clicking on the cross button.
  driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/span")).click();

//2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
    driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")).click(); //

//2.12 Verify the message "Shopping cart"
   String actualText4= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1")).getText();
   System.out.println(actualText4);
   String expectedText4= "Shopping cart";
   Assert.assertEquals(actualText4,expectedText4);

//2.13 Verify the quantity is 2
//   Thread.sleep(2000);
//   String actualText5= driver.findElement(By.xpath("//input[@class='qty-input']")).getText();
//   System.out.println(actualText5);
//   String expectedText5= "2";
//   Assert.assertEquals(actualText5,expectedText5);

// 2.14 Verify the Total $698.00
         Thread.sleep(2000);
   String actualText6= driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]")).getText();
   System.out.println(actualText6);
   String expectedText6 = "$698.00";
   Assert.assertEquals(actualText6,expectedText6);

// 2.15 click on checkbox “I agree with the terms of service”
  driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

//2.16 Click on checkout
 driver.findElement(By.xpath("//button[@id='checkout']")).click();

////2.17 Verify the Text “Welcome, Please Sign In!”
  String actualMsg= driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
  System.out.println(actualMsg);
  String expectedMsg= "Welcome, Please Sign In!";
  Assert.assertEquals(actualMsg,expectedMsg);

//2.18 Click on “REGISTER” tab
  driver.findElement(By.xpath("//div[@class='buttons']/button[2]")).click();

// 2.19 Verify the text “Register”
 String actualMsg1= driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
 System.out.println(actualMsg1);
  String expectedMsg1= "Register";
 Assert.assertEquals(actualMsg1,expectedMsg1);

// 2.20 Fill the mandatory fields
   driver.findElement(By.id("FirstName")).sendKeys("Krishiv");
   driver.findElement(By.id("LastName")).sendKeys("Adhaya");
   driver.findElement(By.id("Email")).sendKeys("kinn01@yahoo.com");
   driver.findElement(By.id("Password")).sendKeys("123123");
   driver.findElement(By.id("ConfirmPassword")).sendKeys("123123");

//2.21 Click on “REGISTER”Button
   driver.findElement(By.xpath("//button[@id='register-button']")).click();

//2.22 Verify the message “Your registration completed”
   String actualMsg2= driver.findElement(By.xpath("//div[@class='page-body']/div")).getText();
   System.out.println(actualMsg2);
   String expectedMsg2= "Your registration completed";
   Assert.assertEquals(actualMsg2,expectedMsg2);

////    2.23 Click on “CONTINUE” tab
  driver.findElement(By.xpath("//div[@class='buttons']/a")).click();

////    2.24 Verify the text “Shopping cart”
    Thread.sleep(2000);
String actualMsg3= driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
System.out.println(actualMsg3);

String expectedMsg3= "Shopping cart";
Assert.assertEquals(actualMsg3,expectedMsg3);

//    2.25 click on checkbox “I agree with the terms of service”
    driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

//    2.26 Click on “CHECKOUT”
//    2.27 Fill the Mandatory fields
//2.28 Click on “CONTINUE”

//2.29 Click on Radio Button “2nd Day Air ($0.00)”
//2.30 Click on “CONTINUE”
//2.31 Select Radio Button “Credit Card”
//2.32 Select “Visa” From Select credit card dropdown
//2.33 Fill all the details
// 2.34 Click on “CONTINUE”CHECKOUT”










}











}
