package utilities;

/* just a bunch of simple and generic methods */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    public static void sleep (int seconds) {

        // this method accept int in sec as an argument
        // and execute Thread.sleep for given duration

        try {
            Thread.sleep(seconds * 1000L);
        }catch (InterruptedException e) { }

    }

    public static void switchWindowAndVerify(WebDriver driver, String expInURL, String expTitle){

        // this method switching window and verify and
        // taking as an argument WebDriver, expectedURL
        // and expected window title as a string

        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains(expInURL)) break;
        }

        // assert : title contains expTitle
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expTitle));

    }

    public static void verifyTitle(WebDriver driver, String expTitle ) {

        // this method accepts arguments as WebDriver and (String) expTitle
        // and asserts if it is true

        Assert.assertEquals(driver.getTitle(), expTitle);

    }

}
