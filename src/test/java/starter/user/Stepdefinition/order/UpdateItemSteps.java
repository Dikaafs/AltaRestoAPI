package starter.user.Stepdefinition.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.order.UpdateItem;

public class UpdateItemSteps {

    @Steps
    UpdateItem updateItem;

    @Given("i set API endpoint for update item")
    public void setAPIendpointUpdateItemValidInput(){
        updateItem.setAPIendpointUpdateItemValidInput();
    }

    @When("i send request to update item with valid input")
    public void sendRequestUpdateItemValidInput(){
        updateItem.sendRequestUpdateItemValidInput();
    }

    @And("i receive valid data updated item")
    public void receiveValidDataUpdatedItem(){
        updateItem.receiveValidDataUpdatedItem();
    }
}
