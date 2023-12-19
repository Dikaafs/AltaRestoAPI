package starter.user.Stepdefinition.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.order.CreateOrder;

public class CreateOrderSteps {

    @Steps
    CreateOrder createOrder;

    @Given("i set API endpoint for create order with valid menu id")
    public void setAPIendpointCreateOrderValidMenuID(){
        createOrder.setAPIendpointCreateOrderValidMenuID();
    }

    @When("i send request to create order with valid menu id")
    public void sendRequestCreateOrderValidMenuID(){
        createOrder.sendRequestCreateOrderValidMenuID();
    }

    @And("i receive valid data my order")
    public void receiveValidDataMyOrder(){
        createOrder.receiveValidDataMyOrder();
    }
}
