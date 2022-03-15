package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginPage
{
    /**
     * This is where we are going to store our login Elements and login Methods
     */
    WebDriver driver;
    public loginPage(WebDriver driver){this.driver=driver;}

    //Below we will have all the Elemants
    @FindBy(xpath = "//input[contains(@name,'userName')]")
    WebElement xpath_username;
    @FindBy(xpath = "//input[contains(@name,'password')]")
    WebElement xpath_password;
    @FindBy(xpath = "//input[contains(@type,'submit')]")
    WebElement xpath_submit;

    //Below we will have all the Test Actions Methods
    public void enterUsername(String username)
    {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(xpath_username));
        xpath_username.sendKeys("Test");

    }
    public void enterPassword(String password)
    {
        xpath_password.sendKeys("Test");

    }
    public void clickSubmit()
    {
        xpath_submit.click();
    }


}
