package edu.pageWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrgPotentialCard {

   private String cardTitle;
   private String priority;
   private String averageLevel;
   private String employeeNumber;
   private String CARD_PATH = "//div[@class='tc-orgpotential_wrapper-card margin-right-16 margin-bottom-16 ']";
   private int CARD_ID;


   private WebDriver driver;



    public OrgPotentialCard(WebElement element) {

        cardTitle = element.findElement(By.xpath(".//div[@class='tc-orgpotential_card-header']/div[1]/span")).getText();

        priority = element.findElement(By.xpath(".//div[@class='block set-pointer']//span")).getText();

        averageLevel = element.findElement(By.xpath(".//div[@class='point-donut font-donut-diagram']/div")).getText();

        employeeNumber = element.findElement(By.xpath(".//div[@class='set-pointer block'][2]/div[1]/span")).getText();

//        WebElement cardTitleWeb = driver.findElement(By.xpath(CARD_PATH + "//div[@class='tc-orgpotential_card-header']/div[1]/span"));
//        cardTitle = cardTitleWeb.getText();
//
//        WebElement priorityWeb = driver.findElement(By.xpath(CARD_PATH + "//div[@class='block set-pointer']//span"));
//        priority = priorityWeb.getText();
//
//        WebElement averageLevelWeb = driver.findElement(By.xpath(CARD_PATH + "//div[@class='point-donut font-donut-diagram']/div"));
//        averageLevel = averageLevelWeb.getText();
//
//        WebElement employeeNumberWeb = driver.findElement(By.xpath(CARD_PATH + "//div[@class='set-pointer block'][2]/div[1]/span"));
//        employeeNumber = employeeNumberWeb.getText();


    }

    public OrgPotentialCard(String cardTitle, String priority, String averageLevel, String employeeNumber) {
        this.cardTitle = cardTitle;
        this.priority = priority;
        this.averageLevel = averageLevel;
        this.employeeNumber = employeeNumber;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public String getPriority() {
        return priority;
    }

    public String getAverageLevel() {
        return averageLevel;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public String toString() {
        return "OrgPotentialCard{" +
                "cardTitle='" + cardTitle + '\'' +
                ", priority='" + priority + '\'' +
                ", averageLevel='" + averageLevel + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", CARD_PATH='" + CARD_PATH + '\'' +
                ", CARD_ID=" + CARD_ID +
                '}'+"\n";
    }
}
