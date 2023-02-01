package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {

    // name - returnOrderDate ()
    // return type - String
    // arg1 - WebDriver driver
    // arg2 - String costumerName

    // this method should accept a customerName and return the costumer
    // order date as a String

    public static String returnOrderDate(WebDriver driver, String costumerName){

        String locator = "//td[.='" + costumerName + "']/following-sibling::td[3]";

        WebElement costumerDateCell = driver.findElement(By.xpath(locator));

        return costumerDateCell.getText();
    }

    // name - orderVerify ()
    // return type - void
    // arg1 - WebDriver driver
    // arg2 - String costumerName
    // arg3 - String expectedOrderDate

    // this method should accept above-mentioned arguments and internally assert
    // expectedOrderDate matching actualOrderDate

    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrderDate){

        String locator = "//td[.='" + costumerName + "']/following-sibling::td[3]";

        String actualOrderCell = driver.findElement(By.xpath(locator)).getText();

        Assert.assertEquals(actualOrderCell, expectedOrderDate);

    }
}
