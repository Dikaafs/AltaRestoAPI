package starter.user.Stepdefinition.order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.order.GetOrderInvalidId;

public class GetOrderInvalidIdSteps {
    @Steps
    GetOrderInvalidId GetOrderInvalidId;

    @Given("i set API endpoint for get order with invalid id")
    public void setAPIendpointGetOrderInvalidId(){
        GetOrderInvalidId.setAPIendpointGetOrderInvalidId();
    }

    @When("i send request to get order with invalid id")
    public void sendRequestGetOrderInvalidId(){
        GetOrderInvalidId.sendRequestGetOrderInvalidId();
    }
}
