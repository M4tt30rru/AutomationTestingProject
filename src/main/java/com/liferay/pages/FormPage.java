package com.liferay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {

    private final WebDriver webDriver;

    public FormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillInTheFoundationDateField(String date) {
        webDriver.findElement(By.xpath("//div[@class='date-picker']//input[@dir='ltr']")).sendKeys(date);
    }

    public void fillsInTheFootballPlayerField(String footBallPlayerName) throws InterruptedException {
        // TODO temporary, to be change into a waiting condition
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//input[@dir='ltr' and contains(@class,'ddm-field-text')]")).sendKeys(footBallPlayerName);
    }

    public void clickOnSubmitButton() {
        webDriver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Submit')]")).click();
    }

    public void getTo() {
        webDriver.navigate().to("https://forms.liferay.com/web/forms/shared/-/form/122548");
    }
}
