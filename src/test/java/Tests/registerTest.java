package Tests;

import Configurations.browserSetup;
import Configurations.extentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class registerTest extends extentReport
{
      // TODO This is where we are going to put our test code for Register

        WebDriver driver = browserSetup.startBrowser("chrome","https://demo.guru99.com/test/newtours/login.php");
        Pages.registerPage register_Page=PageFactory.initElements(driver,Pages.registerPage.class);

        @Test
        public void registerToNewtourWebsite()
        {
            test = extent.createTest("Register",   "Register to new Tours Website");
            test.log(Status.INFO, "Registration Started");
            register_Page.clickRegister();
            register_Page.enterFirstName();
            register_Page.enterLastName();
            register_Page.enterPhone();
            register_Page.enterEmail();
            register_Page.enterAddress();
            register_Page.enterCity();
            register_Page.enterState();
            register_Page.enterPostalCode();
            register_Page.selectCountry();
            register_Page.enterUserName();
            register_Page.enterPassword();
            register_Page.enterConfirmPassword();
            register_Page.clickSubmit();
            test.log(Status.INFO, "Registration Completed");

        }
}
