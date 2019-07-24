package edu.pageWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownSelectList {

    private WebDriver driver;
    private By LIST_ID;

    public DropDownSelectList(WebDriver driver, By LIST_ID) {
        this.driver = driver;
        this.LIST_ID = LIST_ID;
    }

    public void clickOption(String optionName) {
        //Wait for spinner animation
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(LIST_ID));

        Select selectList;


        selectList = new Select(driver.findElement(LIST_ID));
        selectList.selectByVisibleText(optionName);


    }
}
