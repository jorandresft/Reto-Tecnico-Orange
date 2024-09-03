package co.com.orange.stepdefinitions;

import co.com.orange.questions.ValidateText;
import co.com.orange.tasks.Rejected;
import co.com.orange.tasks.SaveShortlist;
import co.com.orange.tasks.rejectCandidate;
import co.com.orange.utils.SearchCandidate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.orange.ui.HomePage.*;
import static co.com.orange.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.equalTo;

public class RejectedStep {

    private static final Logger LOGGER = LoggerFactory.getLogger(RejectedStep.class);

    @And("click on Reject and Save")
    public void clickOnRejectAndSave() {
        theActorCalled(ACTOR).attemptsTo(
                rejectCandidate.shortlistReject(),
                SaveShortlist.clickOnSaveShortlistButton(),
                Rejected.getRejectedStatus()
        );
        LOGGER.info("click on Reject and Save");
    }

    @Then("should see the status is Rejected")
    public void shouldSeeTheStatusIsRejected() {
        String textName = theActorCalled(ACTOR).recall(REMEMBER_NAME);
        String textVacancy = theActorCalled(ACTOR).recall(REMEMBER_VACANCY);
        String textStatus = theActorCalled(ACTOR).recall(REMEMBER_STATUS);

        theActorCalled(ACTOR).attemptsTo(
                SearchCandidate.search()
        );

        OnStage.theActorCalled(ACTOR).should(
                seeThat(ValidateText.validateText(VACANCY_VALUE),
                        equalTo(textVacancy)),
                seeThat(ValidateText.validateText(CANDIDATE_VALUE),
                        equalTo(textName)),
                seeThat(ValidateText.validateText(REJECT_STATUS_VALUE),
                        equalTo(textStatus.substring(8)))
        );
        LOGGER.atInfo()
                .setMessage("should see the status is Rejected, Name: {} Vacancy: {} Status: {}")
                .addArgument(textName)
                .addArgument(textVacancy)
                .addArgument(textStatus.substring(8))
                .log();
    }
}
