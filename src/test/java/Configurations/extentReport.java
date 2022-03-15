package Configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class extentReport
{
    /**
     * This is a Extent report class, that will generate the report on Execution
     */
    private ExtentHtmlReporter htmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void reportSetup()
    {
      htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/ExecutionReport.html");
      htmlReporter.config().setDocumentTitle("New Tours Automation Reports");
      htmlReporter.config().setReportName("Automation Test Report");
      htmlReporter.config().setTheme(Theme.DARK);
      extent= new ExtentReports();
      extent.attachReporter(htmlReporter);
      extent.setSystemInfo("Operating System", "windows");
      extent.setSystemInfo("Automator","VIJILESH");
    }

    @AfterMethod

    public void teardown(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(Status.FAIL, "Test case Failed is  " + result.getName());
            test.log(Status.FAIL, "Test case Failed is  " + result.getThrowable());
        }else if(result.getStatus()==ITestResult.SKIP)
        {
            test.log(Status.SKIP, "Test case Skipped is  " + result.getName());
        }else if(result.getStatus()==ITestResult.SUCCESS)
        {
            test.log(Status.PASS, "Test case Passed is  " + result.getName());
        }

    }
    @AfterSuite

    public void reporttearDown()
    {
        extent.flush();
    }
}
