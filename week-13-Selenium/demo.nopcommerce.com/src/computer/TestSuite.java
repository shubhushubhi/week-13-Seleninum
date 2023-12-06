package computer;

import browsertesting.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestSuite extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void testName(){
//1.1 Click on Computer Menu.
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a")).click();
// 1.2 Click on Desktop
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();

// 1.3 Select Sort By position "Name: Z to A"
     // driver.findElement(By.xpath("//select[@id='products-orderby']/option[3]")).click(); //or

        WebElement dropDown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByIndex(2); // select by index

//        1.4 Verify the Product will arrange in Descending order.

  // String actualText= driver.findElement(By.xpath("//select[@id='products-orderby']/option[3]")).getText();
  //System.out.println(actualText);
 }
 @Test
 public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
   //  2.1 Click on Computer Menu.
     driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a")).click();

//  2.2 Click on Desktop
     driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();

//2.3 Select Sort By position "Name: A to Z"
     //driver.findElement(By.xpath("//select[@id='products-orderby']/option[2]")).click(); // or

    WebElement dropDown = driver.findElement(By.id("products-orderby"));
    Select select = new Select(dropDown);
    select.selectByIndex(1); // select by index

//2.4 Click on "Add To Cart"
     Thread.sleep(1000);
   driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();

 //2.5 Verify the Text "Build your own computer"
    String actualText= driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText();
    System.out.println(actualText);

   String expectedText= "Build your own computer";
   Assert.assertEquals(actualText,expectedText);

//2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
     WebElement selectprocessor=driver.findElement(By.xpath("//dd[@id='product_attribute_input_1']/select"));
     Thread.sleep(2000);
     Select selectpro=new Select(selectprocessor);
     selectpro.selectByIndex(1);

//2.7.Select "8GB [+$60.00]" using Select class.
     Thread.sleep(2000);
     WebElement selectMemory=driver.findElement(By.xpath("//dd[@id='product_attribute_input_2']/select"));
     Select selectmemory1=new Select(selectMemory);
     Thread.sleep(2000);
     selectmemory1.selectByIndex(3);

//2.8 Select HDD radio "400 GB [+$100.00]"
    driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();

// 2.9 Select OS radio "Vista Premium [+$60.00]"
     driver.findElement(By.xpath("//dd[@id='product_attribute_input_4']/ul/li[2]/input")).click();
     Thread.sleep(2000);

//A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
//[+$5.00]"
     driver.findElement(By.xpath("//dd[@id='product_attribute_input_5']/ul/li[1]/input[1]")).isEnabled();

     driver.findElement(By.xpath("//dd[@id='product_attribute_input_5']/ul[1]/li[3]/input[1]")).click();

//2.11 Verify the price "$1,475.00"
     Thread.sleep(2000);
     String actualText2= driver.findElement(By.xpath("//span[@id='price-value-1']")).getText();
     System.out.println(actualText2);
     String expectedText2= "$1,475.00";
     Assert.assertEquals(actualText2,expectedText2);

//2.12 Click on "ADD TO CARD" Button.
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/button")).click();

//2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
//After that close the bar clicking on the cross button.

     String actualText3= driver.findElement(By.xpath("//div[@id='bar-notification']/div/p/a")).getText();
     System.out.println(actualText3);
     String expectedText3= "shopping cart";
     Assert.assertEquals(actualText3,expectedText3);

     //After that close the bar clicking on the cross button.
     driver.findElement(By.xpath("//div[@id='bar-notification']/div/span")).click();

     //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
     Thread.sleep(1000);
    Actions actions = new Actions(driver);
    WebElement shopingCart = driver.findElement(By.xpath("//div[@class='header-links']/ul/li[4]/a/span[1]"));
    shopingCart.click();

//2.15 Verify the message "Shopping cart"
     String actualText4= driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
     System.out.println(actualText4);
     String expectedText4= "Shopping cart";
    Assert.assertEquals(actualText4,expectedText4);

//2.16 Change the Qty to "2" and Click on "Update shopping cart"
     driver.findElement(By.xpath("//input[@class='qty-input']")).clear(); //clear Qty 1 and send Qty 2
     driver.findElement(By.xpath("//input[@class='qty-input']")).sendKeys("2");

     driver.findElement(By.xpath("//div[@class='common-buttons']/button[1]")).click();// Click on "Update shopping cart"

//2.17 Verify the Total"$2,950.00"
     String actualText5= driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
     System.out.println(actualText5);
    String expectedText5= "$2,950.00";
     Assert.assertEquals(actualText5,expectedText5);

//2.18 click on checkbox “I agree with the terms of service”
  driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

//2.19 Click on “CHECKOUT”
     driver.findElement(By.xpath("//button[@id='checkout']")).click();

//2.20 Verify the Text “Welcome, Please Sign In!”
     String actualText6= driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
     System.out.println(actualText6);
     String expectedText6= "Welcome, Please Sign In!";
    Assert.assertEquals(actualText6,expectedText6);
// 2.21Click on “CHECKOUT AS GUEST” Tab
     driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']")).click();

// 2.22 Fill the all mandatory field
     Thread.sleep(2000);
     driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Shubhi");
     driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("adhya");
     driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("kinn@yahoo.com");
     driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("Hitech");
     driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("United States");
     driver.findElement(By.id("BillingNewAddress_StateProvinceId")).sendKeys("American Samoa");
     //BillingNewAddress_StateProvinceId
     driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
     driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("34");
     driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("london");
     driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("hf121sa");
     driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0785241630");

//     2.23 Click on “CONTINUE”
     Thread.sleep(2000);
     driver.findElement(By.xpath("//div[@id=\"checkout-step-billing\"]/div/button[4]")).click();

//     2.24 Click on Radio Button “Next Day Air($0.00)”
      Thread.sleep(2000);
    //driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
//     2.25 Click on “CONTINUE”
//     2.26 Select Radio Button “Credit Card”
//     2.27 Select “Master card” From Select credit card dropdown
//     2.28 Fill all the details
//     2.29 Click on “CONTINUE”
//
 }
}
