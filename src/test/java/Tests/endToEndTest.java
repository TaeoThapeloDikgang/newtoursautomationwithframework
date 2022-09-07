package Tests;

import Configurations.TakeSreenShot;
import Configurations.browserSetup;
import Configurations.extentReport;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class endToEndTest extends extentReport
{
    public static String dir = System.getProperty("user.dir");
    public static final String excel_location = dir + "/TestData/DataSheet.xlsx";
    FileInputStream fis = new FileInputStream(excel_location);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    // TODO This is where we are going to put our test code for Login

    WebDriver driver = browserSetup.startBrowser("chrome", "https://demo.guru99.com/test/newtours/login.php");
    Pages.loginPage login_Page = PageFactory.initElements(driver, Pages.loginPage.class);
    Pages.homePage home_Page = PageFactory.initElements(driver, Pages.homePage.class);
    TakeSreenShot takeSreenShot= new TakeSreenShot();
    public endToEndTest() throws IOException {
    }
        @Test
        public void loginTest ()
        {

            //Reading data from Excel
            XSSFSheet sheet = workbook.getSheetAt(0);
            String username = sheet.getRow(1).getCell(0).getStringCellValue();
            String password = sheet.getRow(1).getCell(1).getStringCellValue();
            test = extent.createTest("Login", "Login to  new  Tours  Website");
            test.log(Status.INFO, "Login test Started");
                login_Page.enterUsername(username);
                login_Page.enterPassword(password);
                login_Page.clickSubmit();
            takeSreenShot.takeSnapshot(driver,"LoginSuccessfully");
            test.log(Status.INFO, "Login test Completed");
        }
        @Test(priority = 1)
        public void verification_and_logout ()
        {
            test = extent.createTest("Logout", "Verification and Logout new  Tours  Website");
            test.log(Status.INFO, "Verification and Logout Test Started");
            //home_Page.verifyUserIsLoggedIn();
            home_Page.signOff();
            takeSreenShot.takeSnapshot(driver,"SignOffSuccessfully");
            test.log(Status.INFO, "Verification and Logout Completed");
        }
        @AfterTest
        public void tearDown ()
        {
            driver.close();
        }


}



