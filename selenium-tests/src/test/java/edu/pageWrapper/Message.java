package edu.pageWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class Message {

    public void checkMessageCorrect (WebDriver driver, By MESSAGE_ID, String message){

        String actualMessage = driver.findElement(MESSAGE_ID).getText();
        assertThat(actualMessage).isEqualTo(message);

    }


}
