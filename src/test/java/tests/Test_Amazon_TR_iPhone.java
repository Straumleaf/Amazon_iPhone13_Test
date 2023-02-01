package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Test_Amazon_TR_iPhone {

    // 1. Go to 'https://www.amazon.com.tr/'
    // 2. Search iPhone13 512
    // 3. Check that the results are listed
    // 4. Click iPhone13 at the top of the list
    // 5. Log the following values for each size .Size information .Price .Color .Stock status

    @Test
    public void iphone_test (){

        // 1. Go to 'https://www.amazon.com.tr/'
        Driver.getDriver().get("https://www.amazon.com.tr/");

        // accepting cookies
        WebElement acceptCookies = Driver.getDriver().findElement(By.name("accept"));
        acceptCookies.click();

        // 2. Search iPhone13 512
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone 13 512" + Keys.ENTER);

        // 3. Check that the results are listed
        String expectedTitle = "Amazon.com.tr : iPhone 13 512";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        // 4. Click iPhone13 at the top of the list
        WebElement topList_iPhone = Driver.getDriver().findElement(By.xpath("//div[@data-index='0']/following-sibling::*[2]"));
        topList_iPhone.click();

        // 5. Log the following values for each size
        //      .Name       .Size information
        //      .Color      .Price
        //      .Stock
        WebElement itemName = Driver.getDriver().findElement(By.xpath("//div[@id='productOverview_feature_div']//table//tr/following-sibling::tr/td[2]"));

        WebElement itemSize = Driver.getDriver().findElement(By.xpath("//div/span[@class='selection']"));

        WebElement itemColor = Driver.getDriver().findElement(By.xpath("//div[@class='a-row']//span[@class='selection']/../../following-sibling::*//div[@class='a-row']//span[@class='selection']"));

        WebElement priceItem = Driver.getDriver().findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span//following-sibling::*"));

        WebElement itemStock = Driver.getDriver().findElement(By.xpath("//div[@id='availability']"));

        System.out.println(itemName.getText());
        System.out.println("Color: " + itemColor.getText() + "\t\tPrice: " + priceItem.getText().replaceAll("\n", ","));
        System.out.println("Stock: " + itemStock.getText());

    }
}
