package edu.pageObject;

import edu.driver.DriverSingleton;
import edu.pageWrapper.Button;
import edu.pageWrapper.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    public static final By LOGIN_INPUT = By.id("_58_login");
    public static final By PASSWORD_INPUT = By.id("_58_password");
    public static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit' and contains(text(),' Войти ')]");
    public static final By ERROR_MESSAGE = By.xpath("//form[@id='_58_fm']//div[contains(@class,'alert-error')]");
    public static final By CHECK_BOX = By.className("checkbox");

    WebDriver driver;
    InputField inputField = new InputField();

    public Login(WebDriver driver) {
        this.driver = driver;
    }


    public void typeLogin(String login) {
        inputField.sendInput(driver, LOGIN_INPUT, login);
    }

    public void typePassword(String password) {
        inputField.sendInput(driver, PASSWORD_INPUT, password);
    }

    public void clickSubmit() {
        Button submitButton = new Button(driver, SUBMIT_BUTTON);
        submitButton.click();
    }

    public void clickCheckBox() {
        driver.findElement(CHECK_BOX).click();
    }

    public void doLogin(String login, String password) {
        typeLogin(login);
        typePassword(password);
        clickSubmit();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }




//    public void doLogin(String url, String login, String pass) {
//
//        driver.get(url);
//        WebElement loginField = driver.findElement(By.name("_58_login"));
//        WebElement passField = driver.findElement(By.name("_58_password"));
//        loginField.sendKeys(login);
//        passField.sendKeys(pass);
//        driver.findElement(By.xpath("//button[@type='submit' and contains(text(),' Войти ')]")).click();
//    }

}
