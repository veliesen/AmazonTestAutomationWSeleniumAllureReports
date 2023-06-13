import BaseTest.BaseTest;
import InterfacePages.AccountPage;
import InterfacePages.HomePage;
import InterfacePages.Variables;
import InterfacePages.SignInPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.thoughtworks.gauge.*;

public class AccountPageTest extends BaseTest  {



    @Test(description = "TC0015 PASS- Check Account Section and Navigate to Account Creation Page")
    public void TC0015(){
        HomePage homePage = new HomePage(driver, new Actions(driver));
        AccountPage accountPage = new AccountPage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection();
        accountPage
                .navigateAccountCreate(element)
                .checkAccountPage()
                .navigateAPtoHomepage();


    }
    @Test(description = "TC0016 PASS- Clear The Form to Create New Account, Fill NameSurname and ClickOn Create Account, Check Warning Text")
    public void TC0016(){
        HomePage homePage = new HomePage(driver, new Actions(driver));
        AccountPage accountPage = new AccountPage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection();
        accountPage
                .navigateAccountCreate(element)
                .clearEmailAccount()
                .clearPassword()
                .fillNameSurname(getGeneratedText())
                .clickOnConfirmAccount()
                .checkApEmailWarningText()
                .navigateAPtoHomepage();

    }
    @Test(description = "TC0017 PASS- Clear The Form to Create New Account, Fill Email and NameSurname, ClickOn Create Account, Check Warning Text")
    public void TC0017(){
        HomePage homePage = new HomePage(driver, new Actions(driver));
        AccountPage accountPage = new AccountPage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection();
        accountPage
                .navigateAccountCreate(element)
                .clearEmailAccount()
                .clearPassword()
                .fillNameSurname(getGeneratedText())
                .fillEmailAccount(getGeneratedText())
                .clickOnConfirmAccount()
                .checkPasswordWarningText()
                .navigateAPtoHomepage();
    }
    @Test(description = "TC0018 PASS- Clear The Form to Create New Account, Fill Email, NameSurname,Password, ClickOn Create Account, Check Warning Text")
    public void TC0018(){
        HomePage homePage = new HomePage(driver, new Actions(driver));
        AccountPage accountPage = new AccountPage(driver, new Actions(driver));
        homePage.hoverCheckAccountSection();
        accountPage
                .navigateAccountCreate(element)
                .checkAccountPage()
                .clearEmailAccount()
                .clearPassword()
                .fillNameSurname(getGeneratedText())
                .fillEmailAccount(getGeneratedText())
                .fillPasswordAccount(getGeneratedText())
                .clickOnConfirmAccount()
                .checkApPasswordWarningText()
                .navigateAPtoHomepage();
    }
}
