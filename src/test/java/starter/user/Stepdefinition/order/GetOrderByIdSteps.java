package starter.user.Stepdefinition.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.order.GetOrderById;

public class GetOrderByIdSteps {

    @Steps
    GetOrderById getOrderById;

    @Given("i set API endpoint for get order with valid id")
    public void setAPIendpointGetOrderValidId(){
        getOrderById.setAPIendpointGetOrderValidId();
    }

    @When("i send Request to get order with valid id")
    public void sendRequestGetOrderValidId(){
        getOrderById.sendRequestGetOrderValidId();
    }

    @And("i receive data order from valid id")
    public void receiveDataOrderValidId(){
        getOrderById.receiveDataOrderValidId();
    }
}
