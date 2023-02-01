package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    public static void crm_login(WebDriver driver) {

        // this method will login with helpdesk1@cybertekschool.com
        // user when it is called

        // enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        // enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        // username: helpdesk1@cybertekschool.com, password: UserUser
        // username: helpdesk2@cybertekschool.com, password: UserUser

        // click to "Log In" button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

    public static void crm_login(WebDriver driver, String userName, String password) {

        // this method will login with helpdesk1@cybertekschool.com
        // user when it is called

        // enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(userName);

        // enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        // username: helpdesk1@cybertekschool.com, password: UserUser
        // username: helpdesk2@cybertekschool.com, password: UserUser

        // click to "Log In" button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

}
