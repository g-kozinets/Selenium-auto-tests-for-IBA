package edu.pageWrapper;

import edu.pageWrapper.DropDownSelectList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrgPotentialFilterCard {

    private boolean checkBox;
    private String firstValue;
    private String secondValue;
    private String thirdValue;
    private String CARD_ID = "//div[@class='tc-orgpotential_filter-container']";
    private String SELECT_LIST_ID = "/div[@class='filter-select margin-bottom-16']";


    WebDriver driver;

    public OrgPotentialFilterCard(WebDriver driver) {
        this.driver = driver;
    }

    public void selectValue (String optionName, int optionID) throws InterruptedException {

        Thread.sleep(500);
        DropDownSelectList dropDown = new DropDownSelectList(driver, By.xpath(CARD_ID + SELECT_LIST_ID + "["+optionID+"]//select[@id='filter-division' ]"));
        dropDown.clickOption(optionName);

    }




}
