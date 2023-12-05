package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    //Task3.1
@Test
    public void verifyThatSigningUpPageDisplay(){

    Actions actions = new Actions(driver);
        WebElement register = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/p[2]/a"));
    actions.moveToElement(register).click().build().perform();
    String ExpectedText = "Signing up is easy!";
    }
@Test
    public void userShouldRegisterAccountSuccessfully(){
    Actions actions = new Actions(driver);
    WebElement register = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/p[2]/a"));
    actions.moveToElement(register).click().build().perform();

    driver.findElement(By.xpath("//*[@id=\"customer.firstName\"]")).sendKeys("Krishiv");

    driver.findElement(By.xpath("//*[@id=\"customer.lastName\"]")).sendKeys("Adhyarru");
    driver.findElement(By.xpath("//*[@id=\"customer.address.street\"]")).sendKeys("12, Talbot Road");
    driver.findElement(By.xpath("//*[@id=\"customer.address.city\"]")).sendKeys("Harroww");
    driver.findElement(By.xpath("//*[@id=\"customer.address.state\"]")).sendKeys("Middlesexx");
    driver.findElement(By.xpath("//*[@id=\"customer.address.zipCode\"]")).sendKeys("3800090");
    driver.findElement(By.xpath("//*[@id=\"customer.phoneNumber\"]")).sendKeys("12345678900");
    driver.findElement(By.xpath("//*[@id=\"customer.ssn\"]")).sendKeys("Krishivv");
    driver.findElement(By.xpath("//*[@id=\"customer.username\"]")).sendKeys("Krishiv12.adhyaru2000@hotmail.com");
    driver.findElement(By.xpath("//*[@id=\"customer.password\"]")).sendKeys("12345678900");
    driver.findElement(By.xpath("//*[@id=\"repeatedPassword\"]")).sendKeys("12345678900");
    WebElement register1 = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
    actions.moveToElement(register1).click().build().perform();
    String ExpectedText = "Your account was created successfully. You are now logged in.";




    }

    //@After
    /*
    public void closeBrowser(){

        driver.quit();
    }

     */



}
