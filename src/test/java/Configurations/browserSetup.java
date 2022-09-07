package Configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class browserSetup {

    /**
     * This is a browser class we are going to setup all the browsers that we will need for our framework
     */

    public static String dir = System.getProperty("user.dir"); //Getting user Directory
    public static String Chromedriver = dir + "/Drivers/chromedriver";//creating Chromedriver Directory
    public static String Firefoxdriver = dir + "/Drivers/geckodriver";//creating Firefox Directory
    static WebDriver driver;
    public static WebDriver startBrowser(String browserchoice, String url){
        if("firefox".equalsIgnoreCase(browserchoice)){
            System.setProperty("webdriver.gecko.driver",Firefoxdriver);
            driver=new FirefoxDriver();
        }
        else if("chrome".equalsIgnoreCase(browserchoice))
        {
            System.setProperty("webdriver.chrome.driver",Chromedriver);
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
  }
