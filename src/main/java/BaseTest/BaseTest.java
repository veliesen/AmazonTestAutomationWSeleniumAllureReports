package BaseTest;

import InterfacePages.Variables;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.thoughtworks.gauge.*;

public class BaseTest extends Variables {
    public static WebDriver driver;
    public static Actions actions;

    @BeforeTest
    public void setUpAmazon() {

        String osName = System.getProperty("os.name");
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "Firefox";
        }

        System.out.println("Initialising Automated Test Runs ");
        System.out.println( osName+" / "+browser);

        if(browser=="Chrome"){
            if(osName=="Mac OS X"){
                System.setProperty("Webdriver.chrome.driver","drivers/chromdriver");
                driver=new ChromeDriver();
            }else{
                System.setProperty("webdriver.chrom.drive","drivers/chromdrive");;
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver=new ChromeDriver(chromeOptions);
            }
        }
        if(browser=="Firefox"){
            if(osName=="Mac OS X"){
                System.setProperty("Webdriver.gecko.drive","drivers/geckodriver");
                driver=new FirefoxDriver();
            }else{
                System.setProperty("Webdriver.geck.drive","drivers/geckdriver");
                driver=new FirefoxDriver();
            }
        }
        String URL="https://www.amazon.com.tr/";

        driver.get(URL);
        driver.manage().window().maximize();


    }
    @AfterTest
    public void closeAmazon(){
        driver.quit();}

}
