package edu.test;

import edu.driver.DriverSingleton;
import edu.pageObject.HrStratPage;
import edu.pageObject.Login;
import edu.pageObject.MainPage;
import edu.pageWrapper.Message;
import edu.pageWrapper.FileUploader;
import edu.pageWrapper.OrgPotentialCard;
import edu.pageWrapper.Button;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;

public class ExampleTest {

    WebDriver driver;
    String pass = "welcome";
    String login = "zaitsev@tc.by";
    String url = "http://tc-stage01.k8s.iba/";
    Login loginObject;


    public List<OrgPotentialCard> createDummycardsArray(){
        String cardTitle = "АДАПТИВНОСТЬ ПО ОТНОШЕНИЮ К ЛЮДЯМ";
        String priority = "Низкий приоритет";
        String averageLevel = "0%";
        String employeeNumber = "0";

        OrgPotentialCard dummyCard1 = new OrgPotentialCard (cardTitle, priority, averageLevel, employeeNumber);
        OrgPotentialCard dummyCard2 =
                new OrgPotentialCard ("АНАЛИЗ И ВЫРАБОТКА РЕШЕНИЙ", "Низкий приоритет", "0%", "0");
        OrgPotentialCard dummyCard3 =
                new OrgPotentialCard ("ПРОАКТИВНОСТЬ", "Низкий приоритет", "0%", "0");

        List<OrgPotentialCard> cardList = new ArrayList<>();
        cardList.add(dummyCard1);
        cardList.add(dummyCard2);
        cardList.add(dummyCard3);
        return cardList;
    }

    @BeforeEach
    public void setUp() {

        driver = DriverSingleton.getInstance();
        driver.get(url);
        loginObject = new Login(driver);

    }

    @Test
    public void shouldNOTLogin() {
        // given
        String alert_error = "Не удалось войти в систему.\n" +
                "Email или пароль введены неверно. Пожалуйста, попробуйте еще раз.";
        String pass = "234324";
        String login = "qweqweq";

        // when
        loginObject.doLogin(login, pass);

        // then
        assertThat(loginObject.getErrorMessage()).isEqualTo(alert_error);
    }

    @Test
    public void shouldLogin() {
        // given
        String homePageTitle = "Главная - Конструктор Талантов";
        String pass = "welcome";
        String login = "zaitsev@tc.by";

        // when
        loginObject.doLogin(login, pass);
        String actualTitle = driver.getTitle();

        // then
        assertThat(actualTitle).isEqualTo(homePageTitle);
    }



    @Test
    public void shouldGoToHRStrat() throws InterruptedException {
        // given
        String hrStratTitle = "Организационный потенциал - Конструктор Талантов";

        // when
        new MainPage(driver, login, pass).clickHrStrategyButton();
        String actualTitle = driver.getTitle();

        // then
        assertThat(actualTitle).isEqualTo(hrStratTitle);
    }

    @Test
    public void shouldFilterCorrectly() throws InterruptedException {
        // given
        String optionName1 = "Управление по работе с персоналом";
        String optionName2 = "Низкий";
        String optionName3 = "Компетенция";

        HrStratPage hrStratPage = new HrStratPage(driver, login, pass);
        hrStratPage.goToHrStrat();

        // when
        hrStratPage.setFilterOption(1, optionName1);
        hrStratPage.setFilterOption(2, optionName2);
        hrStratPage.setFilterOption(3, optionName3);

        // then

        hrStratPage.loadPotentialCards();
        for (int i=0; i<3; i++){
            assertThat(hrStratPage.getPotentialCard(i)).isEqualToIgnoringGivenFields(createDummycardsArray().get(i), "driver", "CARD_PATH");

        }
    }

    @Test
    public void uploadFile_withRobot() throws InterruptedException, AWTException {
        String filepath = "D:\\Automation Test course\\selenium-tests\\testfile.txt";
        loginObject.doLogin(login, pass);
        driver.get("http://tc-stage01.k8s.iba/c/portal/layout?p_l_id=20833&p_p_id=TCPositionProfileCatalog_WAR_TCPositionProfileCatalogportlet&p_p_lifecycle=0&_TCPositionProfileCatalog_WAR_TCPositionProfileCatalogportlet_action=getPositionProfilePage&_TCPositionProfileCatalog_WAR_TCPositionProfileCatalogportlet_positionId=242&_TCPositionProfileCatalog_WAR_TCPositionProfileCatalogportlet_specId=267&_TCPositionProfileCatalog_WAR_TCPositionProfileCatalogportlet_isAdd=false&_TCPositionProfileCatalog_WAR_TCPositionProfileCatalogportlet_reserve=false");

        Button button = new Button(driver, By.xpath("//button[contains(@class, 'editSpecializationButton')]"));
        button.click();

        FileUploader fileUploader = new FileUploader(driver);
        fileUploader.uploadFile(filepath);

        WebElement attached_files = driver.findElement(By.xpath("//div[@class='control-group  attachment-file-div']/a[contains(text(),'testfile.txt')]"));
        assertThat(attached_files.getText()).isEqualTo("testfile.txt");

    }


    @AfterEach
    public void tearDown() {
      driver.close();
      DriverSingleton.destroyInstance();
    }

}

