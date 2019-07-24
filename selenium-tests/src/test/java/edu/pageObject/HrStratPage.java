package edu.pageObject;

import edu.pageWrapper.Button;
import edu.pageWrapper.OrgPotentialCard;
import edu.pageWrapper.OrgPotentialFilterCard;
import edu.pageWrapper.PDAPost;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HrStratPage {
    private WebDriver driver;
    String login;
    String pass;

    private OrgPotentialFilterCard filterCard;
    private OrgPotentialCard orgPotentialCard;
    private List<OrgPotentialCard> potentialCards = new ArrayList<>();
    private List<WebElement> elements = new ArrayList<>();
    private Button addBlock;
    private Button addCompetence;

    public HrStratPage(WebDriver driver, String login, String pass) {
        this.driver = driver;
        this.login = login;
        this.pass = pass;

        addBlock = new Button(driver, By.xpath("//a[@href='/web/guest/profiles/blocks']"));
        addCompetence = new Button(driver, By.xpath("//button[@class='tc-btn tc-btn-secondary-primary undefined']"));

    }


    public void goToHrStrat() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, login, pass);
        mainPage.clickHrStrategyButton();

    }

    public void setFilterOption(int optionID, String optionValue) {

        filterCard = new OrgPotentialFilterCard(driver);
        filterCard.selectValue(optionValue, optionID);
    }

    public List<OrgPotentialCard> loadPotentialCards() throws InterruptedException {
        Thread.sleep(500);
        elements = driver.findElements(By.xpath("//div[@class='tc-orgpotential_wrapper-card margin-right-16 margin-bottom-16 ']"));

        for (int i=0; i<elements.size(); i++) {
            potentialCards.add(new OrgPotentialCard(elements.get(i)));
        }
        System.out.println(potentialCards);
        return potentialCards;
    }

    public OrgPotentialCard getPotentialCard(int cardNumber){
        System.out.println(potentialCards.get(cardNumber));

        return potentialCards.get(cardNumber);
    }

    public void clickAddBlock() {
        addBlock.click();
    }

    public void clickAddCompetence(){
        addCompetence.click();
    }





}
