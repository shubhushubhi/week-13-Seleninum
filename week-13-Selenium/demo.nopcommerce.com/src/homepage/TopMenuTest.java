package homepage;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.awt.*;

public class TopMenuTest extends BaseTest {

    String baseurl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

  //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
  public void selectMenu(String menu) {

      // 1.2 This method should click on the menu whatever name is passed as parameter.
      driver.findElement(By.xpath("//div[@class='header-menu']/ul")).click();
  }
//1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
@Test
 public void verifyPageNavigation(){
    driver.findElement(By.xpath("//div[@class='header-menu']/ul")).click();

    String actualText= driver.findElement(By.xpath("//div[@class='header-menu']/ul")).getText();
    System.out.println(actualText);

    String expectedText= "Computers\n" +
            "Electronics\n" +
            "Apparel\n" +
            "Digital downloads\n" +
            "Books\n" +
            "Jewelry\n" +
            "Gift Cards";
    Assert.assertEquals(actualText,expectedText);
 }


}
