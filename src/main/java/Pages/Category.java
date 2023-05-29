package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class Category {
    private  WebDriver driver;
    private By table= By.cssSelector("tr[role='row']");
    private By row= By.tagName("td");

    private By items=By.xpath("//*[@id='tab-2']");
    private By element= By.xpath("//*[@class='desk-p3']");
    private By element_price= By.xpath("//*[@name='mainPrice']");
    private By element_submit=By.xpath("//*[@value='Save & Exit']");
    private By element_edit=By.tagName("a");
    private By element_price2=By.tagName("h2");
    private By category_element=By.xpath("//*[@class='catalog-icon']");
    private String get_price;
    public Category(WebDriver driver) {
        this.driver=driver;
    }

    public  String find(String option ) throws InterruptedException {

        driver.findElement(items).click();
       Thread.sleep(2000);
        String data = null;
        List<WebElement> list_element = driver.findElements(table);

        for (int i = 0; i < list_element.size(); i++) {

            if ((list_element.get(i).getText().contains("Backpack Navy"))) {

                if (option == "edit") {
                    FluentWait waiit = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(StaleElementReferenceException.class);
                    waiit.until(ExpectedConditions.presenceOfElementLocated(element_edit));
                    list_element.get(i).findElement(element_edit).click();
                    break;
                } else if (option == "cheack") {
                    List<WebElement> list_row = list_element.get(i).findElements(row);
                    data = list_row.get(list_row.size() - 2).getText();
                    break;

                }

            }


        }

        return data;
    }

    public void scrolldown() {
        WebElement table_element = driver.findElement(element);
        String scribt="arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(scribt,table_element);


    }

    public void change_price(int price ) throws InterruptedException {
        this.get_price= Integer.toString(price);
        driver.findElement(element_price).clear();
        driver.findElement(element_price).sendKeys(Integer.toString(price));

        driver.findElement(element_submit).click();

    }

    public String cheack_price() throws InterruptedException {
        driver.findElement(category_element).click();

        driver.findElement(items).click();
        Thread.sleep(5000);
       return find("cheack");


    }


}
