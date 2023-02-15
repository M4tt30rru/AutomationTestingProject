package com.liferay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {

    private final WebDriver webDriver;

    public FormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillInTheFoundationDateField(String date) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        By datePickerLocator = By.xpath("//div[@class='date-picker']//input[@dir='ltr']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(datePickerLocator));
        webDriver.findElement(datePickerLocator).sendKeys(date);
    }

    public void fillsInTheFootballPlayerField(String footBallPlayerName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        By footballPlayerLocator = By.xpath("//input[@dir='ltr' and contains(@class,'ddm-field-text')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(footballPlayerLocator));
        webDriver.findElement(footballPlayerLocator).sendKeys(footBallPlayerName);
    }

    public void clickOnSubmitButton() {
        webDriver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Submit')]")).click();
    }

    public void getTo() {
        webDriver.navigate().to("https://forms.liferay.com/web/forms/shared/-/form/122548");
    }

    public void fillsInTheCareerField(String answer) {
        webDriver.findElement(By.xpath("//textarea")).sendKeys(answer);
    }
}
