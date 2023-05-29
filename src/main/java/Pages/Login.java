package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    private By username_element= By.name("email");
    private By pass_element= By.name("password");
    private By login_element= By.xpath("//*[@type='submit']");
    public Login(WebDriver driver) {
        this.driver=driver;
    }

    public void enter_username( String user_name) {
        driver.findElement(username_element).sendKeys(user_name);
    }
    public void enter_pass( String password) {
        driver.findElement(pass_element).sendKeys(password);
    }
   public Homepage click_login(){
        driver.findElement(login_element).click();

       return new Homepage(driver);
   }
}
