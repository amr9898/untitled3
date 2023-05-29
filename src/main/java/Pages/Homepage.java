package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Homepage {
    private WebDriver driver;
    private By category_element=By.xpath("//*[@class='catalog-icon']");
    public Homepage(WebDriver driver) {
        this.driver=driver;
    }



    public Category select_category() {
        FluentWait waiit = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(ElementClickInterceptedException.class);
        waiit.until(ExpectedConditions.presenceOfElementLocated(category_element));

       driver.findElement(category_element).click();


            return new Category(driver);
    }


}
