package desktops;

import homepage.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DesktopsTest extends BaseTest {
    String baseurl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a")).click();
        //1.2 Click on “Show AllDesktops”
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();
        //1.3 Select Sort By position "Name: Z to A"
        driver.findElement(By.xpath("//select[@id='input-sort']/option[3]")).click();
        //1.4 Verify the Product will arrange in Descending order.
        driver.findElement(By.xpath("//div[@id='product-category']/div/div/h3")).click();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a")).click();
        //2.2 Click on “Show All Desktops”
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();

        //2.3 Select Sort By position "Name: A to Z"
        driver.findElement(By.xpath("//select[@id='input-sort']/option[2]")).click();

        //2.4 Select product “HP LP3065”
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[1]/h4/a")).click();

        //2.5 Verify the Text "HP LP3065"

        String ActualText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/h1")).getText();
        String ExpectedText = "HP LP3065";
        Assert.assertEquals(ActualText, ExpectedText);

        //  2.6 Select Delivery Date "2022-11-30"
        driver.findElement(By.xpath("//div[@class='input-group date']/input")).click();

        // 2.7.Enter Qty "1” s.
        driver.findElement(By.xpath("//*[@id=\"input-quantity\"]")).click();

        // 2.8 Click on “Add to Cart” button
        driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();

        // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(1000);
        String ActualText1 = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
        System.out.println(ActualText1);
        String ExpectedText1 = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals(ActualText1, ExpectedText1);


        //2.10 Click on link “shopping cart” display into success message
        driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/a[2]")).click();

        // 2.11 Verify the text "Shopping Cart"
        String actualText2 = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).getText();
        System.out.println(actualText2);
        String expectedText2 = "Shopping Cart";
        Assert.assertEquals(actualText2, expectedText2);

        // 2.12 Verify the Product name "HP LP3065"

        String actualText3 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")).getText();
        System.out.println(actualText3);
        String expectedText3 = "HP LP3065";
        Assert.assertEquals(actualText3, expectedText3);

        // 2.13 Verify the Delivery Date "2022-11-30"
        String actualText4 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/small[1]")).getText();
        System.out.println(actualText4);
        String expectedText4 = "Delivery Date:2011-04-22";
        Assert.assertEquals(actualText4, expectedText4);

        //2.14 Verify the Model "Product21"

        String actualText5 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[3]")).getText();
        System.out.println(actualText5);
        String expectedText5 = "Product 21";
        Assert.assertEquals(actualText5, expectedText5);

        //2.15 Verify the Total "£74.73"


        driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/span")).click();  //Convert Currency
        driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button")).click(); //GBP £
        String actualText6 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")).getText();
        System.out.println(actualText6);
        String expectedText6 = "£74.73";
        Assert.assertEquals(actualText6, expectedText6);
    }

}



