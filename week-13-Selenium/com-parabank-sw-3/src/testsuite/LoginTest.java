package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    //Task 4.1
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("parth@adhyaru.com");

        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("1234567890");
        WebElement login = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        actions.moveToElement(login).click().build().perform();
        String ExpectedText = "Accounts Overview";
    }

    //Task 4.2
@Test
    public void verifyTheErrorMessage(){

        Actions actions = new Actions(driver);
        //  WebElement login = driver.findElement(By.xpath("//div[@id=\"loginPanel\"]/p[2]/a"));
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("parth@dhyaru.com");

        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("124567890");
        WebElement login = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        actions.moveToElement(login).click().build().perform();
        String ExpectedText = "The username and password could not be verified.";

    }

    //Task 4.3
    @Test
    public void userShouldLogOutSuccessfully(){

        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("parth@adhyaru.com");
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("1234567890");
        WebElement login = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        actions.moveToElement(login).click().build().perform();
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a"));
        actions.moveToElement(logout).click().build().perform();

        String ExpectedText = "Customer Login";

    }


}
