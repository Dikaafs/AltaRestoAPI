package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.UpdateStatus;

public class UpdateStatusSteps {

    @Steps
    UpdateStatus updateStatus;

    @Given("i set API endpoint for update status with valid menu id")
    public void setAPIendpointUpdateStatusValidMenuId(){
        updateStatus.setAPIendpointUpdateStatusValidMenuId();
    }

    @When("i send request to update status with valid menu id")
    public void sendRequestUpdateStatusValidMenuId(){
        updateStatus.sendRequestUpdateStatusValidMenuId();
    }

    @And("status is updated")
    public void statusUpdated(){
        updateStatus.statusUpdated();
    }
}
