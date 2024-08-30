package co.com.orange.stepdefinitions;

import co.com.orange.models.CandidateModel;
import co.com.orange.models.InterviewModel;
import co.com.orange.questions.ValidateText;
import co.com.orange.tasks.*;
import co.com.orange.utils.SearchCandidate;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

import static co.com.orange.ui.HomePage.*;
import static co.com.orange.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.equalTo;

public class HiredStep {

    @DataTableType(replaceWithEmptyString = "[anonymous]")
    public CandidateModel candidateEntryTransformer(Map<String, String> row) {
        return new CandidateModel(
                row.get("contactNumber"),
                row.get("email"),
                row.get("firstName"),
                row.get("keywords"),
                row.get("lastName"),
                row.get("vacancy")
        );
    }

    @DataTableType(replaceWithEmptyString = "[anonymous]")
    public InterviewModel interviewEntryTransformer(Map<String, String> row) {
        return new InterviewModel(
                row.get("date"),
                row.get("interviewer"),
                row.get("interviewTitle")
        );
    }

    @And("init session with his credentials username {string} and password {string}")
    public void initSessionWithHisCredentials(String username, String password) {
        theActorCalled(ACTOR).attemptsTo(
                EnterCredentials.enterCredentials(username, password)
        );
    }

    @And("select Recruitment and click on add")
    public void selectRecruitmentAndAdd() {
        theActorCalled(ACTOR).attemptsTo(
                Recruitment.clickRecruitment()
        );
    }

    @When("fill all field required")
    public void fillAllFieldRequired(List<CandidateModel> candidateInfo) {
        theActorCalled(ACTOR).attemptsTo(
                RecruitmentForm.fillInfo(candidateInfo.get(0))
        );
    }

    @And("click on Shortlist and Save")
    public void clickOnShortlistAndSave() {
        theActorCalled(ACTOR).attemptsTo(
                Shortlist.shortList(),
                SaveShortlist.saveShortlist()
        );
    }

    @And("click on Schedule Interview and fill all field required")
    public void schedulesTheInterview(List<InterviewModel> interviewInfo) {
        theActorCalled(ACTOR).attemptsTo(
                ScheduleInterview.scheduleInterview(),
                InterviewForm.fillInfo(interviewInfo.get(0))
        );
    }

    @And("click on mark interview passed and Save")
    public void clickOnMarkInterviewPassedAndSave() {
        theActorCalled(ACTOR).attemptsTo(
                MarkInterviewPassed.markInterviewPassed(),
                SaveMarkInterviewPassed.saveMarkInterviewPassed()
        );
    }

    @And("click on offer job and Save")
    public void clickOnOfferJobAndSave() {
        theActorCalled(ACTOR).attemptsTo(
                OfferJob.offerJob(),
                SaveOfferJob.saveOfferJob()
        );
    }

    @Then("click on Hire and Save")
    public void clickOnHireAndSave() {
        theActorCalled(ACTOR).attemptsTo(
                Hire.hire(),
                SaveHire.saveHire(),
                Hired.getHiredStatus()
        );
    }

    @And("should see the information is correct")
    public void heShouldSeeTheInformationIsCorrectAndStatusIs() {
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
                seeThat(ValidateText.validateText(STATUS_VALUE),
                        equalTo(textStatus.substring(8)))
        );
    }
}
