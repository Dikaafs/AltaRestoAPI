package starter.user.Stepdefinition.order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.order.CreateOrderNoExistMenuId;

public class CreateOrderNoExistMenuIdSteps {

    @Steps
    CreateOrderNoExistMenuId CreateOrderNoExistMenuId;

    @Given("i set API endpoint for create order with no exist menu id")
    public void setAPIendpointCreateOrderNoExistMenuId(){
        CreateOrderNoExistMenuId.setAPIendpointCreateOrderNoExistMenuId();
    }

    @When("i send request to create order with no exist menu id")
    public void sendRequestCreateOrderNoExistMenuId(){
        CreateOrderNoExistMenuId.sendRequestCreateOrderNoExistMenuId();
    }
}
