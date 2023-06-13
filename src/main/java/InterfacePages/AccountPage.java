package InterfacePages;

import BaseTest.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AccountPage extends BaseTest {
    public WebDriver driver;
    public Actions actions;

    public String text;
    public String generatedText=getGeneratedText();

    public String decryptedEmail=getDecryptedEmail();

    public AccountPage(WebDriver driver, Actions actions){
        this.driver=driver;
        this.actions=actions;
    }

    @Step("Click On Create Account ")
    public AccountPage navigateAccountCreate(String element){

        driver.findElement(By.xpath(element)).click();
        return this;
    }

    @Step("Click On Create Account Button")
    public AccountPage clickOnCreateAccountButton(){
        driver.findElement(By.id("createAccountSubmit")).click();

        return this;
    }

    @Step("Navigate to HomePage")
    public AccountPage navigateAPtoHomepage(){
        driver.navigate().to("https://www.amazon.com.tr/");

        return this;
    }
    @Step("Checks Account Page Text")
    public AccountPage checkAccountPage(){
        text=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/h1")).getText();
        Assert.assertEquals("Hesap oluşturun",text);


        return this;
    }
    @Step("Clear Text Email Section")
    public AccountPage clearEmailAccount(){
        driver.findElement(By.id("ap_email")).clear();

        return this;
    }
    @Step("Clear Password Section")
    public AccountPage clearPassword(){
        driver.findElement(By.id("ap_password")).clear();

        return this;
    }
    @Step("Fill the Name Section")
    public AccountPage fillNameSurname(String generatedText){
         driver.findElement(By.id("ap_customer_name")).sendKeys(generatedText);
         this.generatedText=generatedText;

        return this;
    }
    @Step("Check Email Warning Text ")
    public AccountPage checkApEmailWarningText(){
        text=driver.findElement(By.cssSelector("#auth-email-missing-alert > div:nth-child(1) > div:nth-child(2)")).getText();
        Assert.assertEquals("E-posta adresinizi veya cep telefonu numaranızı girin",text);

        return this;
    }
    @Step("Clear Name And Surname Section")
    public AccountPage clearGeneratedText(){
        driver.findElement(By.id("ap_customer_name")).clear();

        return this;
    }

    @Step("Fill Email Section With Valid")
    public AccountPage fillEmailAccount(String generatedText){
        driver.findElement(By.id("ap_email")).sendKeys(generatedText+"@gmail.com");
        this.generatedText=generatedText;

        return this;
    }
    @Step("Check Password Warning Text ")
    public AccountPage checkPasswordWarningText(){
        text=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[3]/div[1]/div[2]/div/div")).getText();
        Assert.assertEquals("Minimum 6 karakter gerekli",text);

        return this;
    }
    @Step("Fill Password Section With Generated Text")
    public AccountPage fillPasswordAccount(String generatedText){
        driver.findElement(By.id("ap_password")).sendKeys(generatedText);
        this.generatedText=generatedText;

        return this;
    }

    @Step("Click On Confirm Account Button")
    public AccountPage clickOnConfirmAccount(){
        driver.findElement(By.id("continue")).click();

        return this;
    }
    @Step("Check Password Warning Text ")
    public AccountPage checkApPasswordWarningText(){
        text=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[3]/div[2]/div[1]/div/div")).getText();
        Assert.assertEquals("Şifrenizi tekrar girin",text);

        return this;
    }










}
