package com.liferay.steps;

import com.liferay.TestContext;
import com.liferay.pages.FormPage;
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
    public FormPage formPage;

    public FormStepdefs(TestContext testContext) {
        this.testContext = testContext;
        this.webDriver = testContext.getWebDriver();
        this.formPage = new FormPage(webDriver);
    }

    @Given("A user landing on the form page")
    public void aUserLandingOnTheFormPage() {
        formPage.getTo();
    }

    @And("the user clicks on the submit button")
    public void theUserClicksOnTheSubmitButton() {
        formPage.clickOnSubmitButton();
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
        formPage.fillsInTheFootballPlayerField(footBallPlayerName);
    }

    @And("the user fills {string} value in the LifeRay foundation input")
    public void theUserFillsLifeRayFoundationDateValueInTheLifeRayFoundationInput(String date) {
        formPage.fillInTheFoundationDateField(date);
    }

    @And("the user fills {string} value in the career question input")
    public void theUserFillsTestFieldValueInTheCareerQuestionInput(String answer) {
        webDriver.findElement(By.xpath("//textarea")).sendKeys(answer);
    }

}
