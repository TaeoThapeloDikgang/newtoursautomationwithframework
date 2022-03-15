package Tests;

import Configurations.browserSetup;
import Configurations.extentReport;
import Pages.loginPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class loginTest extends extentReport
{
    // TODO This is where we are going to put our test code for Login

    WebDriver driver = browserSetup.startBrowser("chrome","https://demo.guru99.com/test/newtours/login.php");
    Pages.loginPage login_Page = PageFactory.initElements(driver,Pages.loginPage.class);

    @Test

    public void loginToNewToursWebsite()
    {
        test = extent.createTest("Login",   "Login  to  new  Tours  Website");
        test.log(Status.INFO, "Login Started");
        login_Page.enterUsername("Test");
        login_Page.enterPassword("Test");
        login_Page.clickSubmit();
        test.log(Status.INFO, "Login Completed");

    }

    @AfterTest

    public void tearDown()
    {
        driver.close();
    }

}
