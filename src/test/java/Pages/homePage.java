package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class homePage
{
    // All elements for home page
    WebDriver driver;
    @FindBy(xpath = "//h3[contains(.,'Login Successfully')]")
    WebElement login_verification;

    @FindBy(xpath = "//a[contains(.,'SIGN-OFF')]")
    WebElement logout_verification;


    public  void verifyUserIsLoggedIn()
    {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(login_verification));
        Assert.assertEquals(login_verification.getText(),"Login Successfully");
    }
    public  void signOff()
    {
        logout_verification.click();
    }

}
