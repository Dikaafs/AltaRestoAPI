package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.UpdateStatusInvalidMenuID;

public class UpdateStatusInvalidMenuIDSteps {
    @Steps
    UpdateStatusInvalidMenuID updateStatusInvalidMenuID;

    @Given("i set API endpoint for update status with invalid menu id")
    public void setAPIendpointUpdateStatusInvalidMenuID(){
        updateStatusInvalidMenuID.setAPIendpointUpdateStatusInvalidMenuID();
    }

    @When("i send request to update status with invalid menu id")
    public void sendRequestUpdateStatusInvalidMenuID(){
        updateStatusInvalidMenuID.sendRequestUpdateStatusInvalidMenuID();
    }
}
