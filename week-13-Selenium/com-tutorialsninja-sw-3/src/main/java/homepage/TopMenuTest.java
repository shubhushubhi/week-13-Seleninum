package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.xml.xpath.XPathExpression;
import java.awt.*;
public class TopMenuTest extends BaseTest{
    String baseurl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    public void selectMenu(String menu) {  //1.1 create method with name "selectMenu" it has one parameter name "menu" of type
        //1.1 Mouse hover on “Desktops” Tab and click
        driver.findElement(By.xpath("//a[text()='"+menu+"']")).click();
    }
    @Test
        public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Desktops']")).click(); //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");

        String ActualText = driver.findElement(By.xpath("//h2[text()='Desktops']")).getText();//1.3 Verify the text ‘Desktops’
        String ExpectedText = "Desktops";
        Assert.assertEquals(ActualText,ExpectedText);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a")).click();

     //2.2 call selectMenu method and pass the menu = “Show AllLaptops & Notebooks”
      selectMenu("Show AllLaptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        String ActualText = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();//1.3 Verify the text ‘Laptops & Notebooks’
        String ExpectedText = "Laptops & Notebooks";
        Assert.assertEquals(ActualText,ExpectedText);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
       //3.1 Mouse hover on “Components” Tab and click
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a")).click();

      // 3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

     //3.3 Verify the text ‘Components’
        String ActualText = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        System.out.println(ActualText);
        String ExpectedText = "Components";
        Assert.assertEquals(ActualText,ExpectedText);
    }
    @After
    public void close(){
        closeBrowser();

    }


}
