package edu.pageObject;

import edu.pageWrapper.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {

    public static final By HR_STRATEGY_BUTTON = By.xpath("//a[@aria-labelledby='layout_7']");
    private WebDriver driver;

    public MainPage(WebDriver driver, String login, String pass){
        this.driver=driver;
        Login loginPage = new Login(driver);
        loginPage.doLogin(login, pass);
    }


    public void clickHrStrategyButton() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 3);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(HR_STRATEGY_BUTTON));
//        driver.findElement(HR_STRATEGY_BUTTON).click();

        new Button(driver, HR_STRATEGY_BUTTON).click();
    }


}
