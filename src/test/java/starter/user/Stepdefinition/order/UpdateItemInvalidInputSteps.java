package starter.user.Stepdefinition.order;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.order.UpdateItemInvalidInput;

public class UpdateItemInvalidInputSteps {

    @Steps
    UpdateItemInvalidInput UpdateItemInvalidInput;

    @When("i send request to update item with invalid input")
    public void sendRequestUpdateItemInvalidInput(){
        UpdateItemInvalidInput.sendRequestUpdateItemInvalidInput();
    }
}
