package myaccounts;

import dev.failsafe.Call;
import homepage.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyAccountsTest extends BaseTest {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
        //1.1 create method with name "selectMyAccountOptions" it has one parameter name
        //"option" of type string
        public void selectMyAccountOptions(String option) {
            //1.2 This method should click on the options whatever name is passed as parameter.
            //(Hint: Handle List of Element and Select options)
            driver.findElement(By.xpath(option)).click();
 }
 @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
     //1.1 Click on My Account Link.
     driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[1]")).click();

     //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    selectMyAccountOptions("//nav[@id='top']/div[1]/div[2]/ul/li[2]/ul[1]/li[1]/a");

     //driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a")).click();//click on Register account

     //1.3 Verify the text “Register Account”.
     String actualText = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    System.out.println(actualText);

    // String expectedText = "Register Account";
   //  Assert.assertEquals(actualText,expectedText);
 }
@Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
  //  2.1 Click on My Account Link.
   driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[1]")).click();

    //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
    selectMyAccountOptions("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a");
    //driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")).click();// click on login Account

    // 2.3 Verify the text “Returning Customer”.
    //String actualText1 = driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/h2")).getText();
   // System.out.println(actualText1);

   // String expectedText1 = "Register Account";
  //  Assert.assertEquals(actualText1,expectedText1);
    }
@Test
    public void verifyThatUserRegisterAccountSuccessfully() {
    // 3.1 Click on My Account Link.
    driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[1]")).click();

    // 3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    selectMyAccountOptions("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"); // or

    //driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a")).click();//click on Register account

//3.3 Enter First Name
//3.4 Enter Last Name
//3.5 Enter Email
//3.6 Enter Telephone
//3.7 Enter Password
//3.8 Enter Password Confirm
    driver.findElement(By.id("input-firstname")).sendKeys("kin");
    driver.findElement(By.id("input-lastname")).sendKeys("adhy");
    driver.findElement(By.id("input-email")).sendKeys("ki18@yahoo.com");
    driver.findElement(By.id("input-telephone")).sendKeys("123456987");
    driver.findElement(By.id("input-password")).sendKeys("hitech");
    driver.findElement(By.id("input-confirm")).sendKeys("hitech");

//3.9 Select Subscribe Yes radio button
    driver.findElement(By.xpath("//label[@class='radio-inline']/input")).click();

//3.10 Click on Privacy Policy check box
    driver.findElement(By.xpath("//input[@type='checkbox']")).click();

//3.11 Click on Continue button
    driver.findElement(By.xpath("//input[@value='Continue']")).click();

//3.12 Verify the message “Your Account Has Been Created!”
    String actualText2 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    System.out.println(actualText2);

    String expectedText2 = "Your Account Has Been Created!";
    Assert.assertEquals(actualText2,expectedText2);

//3.13 Click on Continue button
    driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();

//3.14 Click on My Account Link.
    driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[1]")).click();

//3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”

//selectMyAccountOptions("Logout");
   driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[5]/a")).click();//click on Logout

//3.16 Verify the text “Account Logout”
   String actualText3 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
   System.out.println(actualText3);

   String expectedText3 = "Account Logout";
   Assert.assertEquals(actualText3,expectedText3);

//3.17 Click on Continue button
    driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();
 }
 @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
 //4.1 Click on My Account Link.
     driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[1]")).click();

//4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
     selectMyAccountOptions("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a"); //or

    // driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")).click();// click on login Account

//4.3 Enter Email address
//4.5 Enter Password
     driver.findElement(By.id("input-email")).sendKeys("kin18@yahoo.com");
     driver.findElement(By.id("input-password")).sendKeys("hitech");
//4.6 Click on Login button
    driver.findElement(By.xpath("//input[@value='Login']")).click();

//4.7 Verify text “My Account”
     String actualText = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
     System.out.println(actualText);

    String expectedText= "My Account";
    Assert.assertEquals(actualText,expectedText);
//4.8 Click on My Account Link.
     driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]/a")).click();

//4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
 selectMyAccountOptions("//ul[@class='dropdown-menu dropdown-menu-right']/li[5]/a");  //or

     //driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[5]/a")).click();//click on Logout

//4.10 Verify the text “Account Logout”
     String actualText1 = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
     System.out.println(actualText1);

     String expectedText2= "Account Logout";
     Assert.assertEquals(actualText1,expectedText2);

//4.11 Click on Continue button
    driver.findElement(By.xpath("//div[@class='pull-right']/a")).click();

 }
}



