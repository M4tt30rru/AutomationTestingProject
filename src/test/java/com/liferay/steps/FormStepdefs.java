package com.liferay.steps;

import com.liferay.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class FormStepdefs {

    public TestContext testContext;
    public WebDriver webDriver;

    public FormStepdefs(TestContext testContext) {
        this.testContext = testContext;
        this.webDriver = testContext.getWebDriver();
    }

    @Given("A user landing on the form page")
    public void aUserLandingOnTheFormPage() {
        getTo();
    }

    @And("the user clicks on the submit button")
    public void theUserClicksOnTheSubmitButton() {
        clickOnSubmitButton();
    }

    @Then("A message showing the following {string} shows up")
    public void aMessageShowingTheFollowingMessageShowsUp(String message) throws InterruptedException {
        // TODO temporary, to be change into a waiting condition
        Thread.sleep(5000);
        Integer messageOccurrencesNum = webDriver.findElements(By.xpath("//h2[contains(text(),'" +
                message +
                "')]")).size();
        assertThat(messageOccurrencesNum).isEqualTo(1);
    }

    @When("the user fills {string} value in the football player input")
    public void theUserFillsFootballPlayerValueInTheFootballPlayerInput(String footBallPlayerName) throws InterruptedException {
        fillsInTheFootballPlayerField(footBallPlayerName);
    }

    @And("the user fills {string} value in the LifeRay foundation input")
    public void theUserFillsLifeRayFoundationDateValueInTheLifeRayFoundationInput(String date) {
        fillInTheFoundationDateField(date);
    }

    @And("the user fills {string} value in the career question input")
    public void theUserFillsTestFieldValueInTheCareerQuestionInput(String answer) {
        webDriver.findElement(By.xpath("//textarea")).sendKeys(answer);
    }

    private void getTo() {
        webDriver.navigate().to("https://forms.liferay.com/web/forms/shared/-/form/122548");
    }

    private void clickOnSubmitButton() {
        webDriver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Submit')]")).click();
    }

    private void fillsInTheFootballPlayerField(String footBallPlayerName) throws InterruptedException {
        // TODO temporary, to be change into a waiting condition
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//input[@dir='ltr' and contains(@class,'ddm-field-text')]")).sendKeys(footBallPlayerName);
    }

    private void fillInTheFoundationDateField(String date) {
        webDriver.findElement(By.xpath("//div[@class='date-picker']//input[@dir='ltr']")).sendKeys(date);
    }
}
