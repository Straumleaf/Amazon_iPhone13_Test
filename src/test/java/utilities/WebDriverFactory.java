package utilities;

// TASK: NEW METHOD CREATION
// Method name: getDriver
// Static method
// Accepts String arg: browserType
//      - this arg will determine what type of browser is opened
//      - if "chrome" passed --> it will open Chrome browser
//      - if "firefox" passed -- it will open Firefox browser
// RETURN TYPE: "WebDriver"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }else {
            System.out.println("Given browser absent");
            return null;
        }
    }




}
