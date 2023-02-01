package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // creating a private constructor, to limit access to the object of this class
    // from outside
    private Driver(){}

    // using a static modifier to make it possible to use in static method
    private static WebDriver driver;

    // create utility method which will return same driver instance
    // wherever we call it
    public static WebDriver getDriver() throws RuntimeException {

        if(driver == null){

            // reading type of browser from config properties
            String browserType = ConfigReader.getProperty("browser");

            // choosing the wright driver type as per config properties
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new RuntimeException("There is no such driver as " + browserType + " or config file error!");
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        return driver;
    }

    // this method make sure our driver value is always null after using quit() method
    public static void closeDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
