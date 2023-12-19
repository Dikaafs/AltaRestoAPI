package starter.admin.stepdefinition.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Order.UpdateOrderStatus;

public class UpdateOrderStatusSteps {

    @Steps
    UpdateOrderStatus updateOrderStatus;

    @Given("i set API endpoint for update order status with valid input")
    public void setAPIendpointUpdateOrderStatusValidInput(){
        updateOrderStatus.setAPIendpointUpdateOrderStatusValidInput();
    }

    @When("i send request to update order status with valid input")
    public void sendRequestUpdateOrderStatusValidInput(){
        updateOrderStatus.sendRequestUpdateOrderStatusValidInput();
    }

    @And("i receive success message {string}")
    public void receiveSuccessMessage(String message){
        updateOrderStatus.receiveSuccessMessage(message);
    }
}
