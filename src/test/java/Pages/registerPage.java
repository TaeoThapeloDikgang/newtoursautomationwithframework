package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registerPage
{
   WebDriver driver;
    public registerPage(WebDriver driver){this.driver=driver;}

    //Below we will have all the Elemants

    @FindBy(xpath = "//a[contains(.,'REGISTER')]")
    WebElement register;


    @FindBy(xpath = "//input[contains(@name,'firstName')]")
    WebElement firstName;

    @FindBy(xpath = "//input[contains(@name,'lastName')]")
    WebElement lastName;

    @FindBy(xpath = "//input[contains(@name,'phone')]")
    WebElement phone;

    @FindBy(xpath = "//input[contains(@name,'userName')]")
    WebElement userName;

    @FindBy(xpath = "//input[contains(@name,'address1')]")
    WebElement address1;

    @FindBy(xpath = "//input[contains(@name,'city')]")
    WebElement city;

    @FindBy(xpath = "//input[contains(@name,'state')]")
    WebElement state;

    @FindBy(xpath = "//input[contains(@name,'postalCode')]")
    WebElement postalcode;

    @FindBy(xpath = "//select[contains(@name,'country')]")
    WebElement country;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    WebElement email;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    WebElement password;

    @FindBy(xpath = "//input[contains(@name,'confirmPassword')]")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[contains(@name,'submit')]")
    WebElement submit;

    //Below we will have all the Test Actions Methods

    public void clickRegister()
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(register));
        register.click();
    }
    public void enterFirstName()
    {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("Vijilesh");
    }
    public void enterLastName() {
        lastName.sendKeys("Kumar");
    }
    public void enterPhone() {
        phone.sendKeys("0000");
    }
    public void enterEmail() {
        userName.sendKeys("123@gmail.com");
    }
    public void enterAddress() {
        address1.sendKeys("Jackal Creek");
    }
    public void enterCity() {
        city.sendKeys("JNB");
    }
    public void enterState() {
        state.sendKeys("GP");
    }
    public void enterPostalCode() {
        postalcode.sendKeys("2194");
    }
    public void selectCountry()
    {
        Select drp_country= new Select(driver.findElement(By.name("country")));
        drp_country.selectByVisibleText("AUSTRIA");
    }
    public void enterUserName() {
        email.sendKeys("Viji");
    }
    public void enterPassword() {
        password.sendKeys("Test");
    }
    public void enterConfirmPassword() {
        confirmPassword.sendKeys("Test");
    }
    public void clickSubmit() {
     submit.click();
   }

 }
