package base_tests;

import Pages.Homepage;
import Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class basetests {
    private WebDriver driver;
    protected Homepage home ;
    @BeforeClass
    public void setup(){
        this.driver= new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        go_home();
        home= new Homepage(driver);


    }

    @BeforeMethod
    private void go_home() {
        driver.get("http://transmission-dev.azurewebsites.net/login ");
        Login login = new Login(driver);
        login.enter_username("testbotitb2@dist.com");
        login.enter_pass("123456");
        login.click_login();
    }
//    @AfterClass
//    public void  tear_down(){
//        driver.quit();
//    }
}
