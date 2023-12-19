package starter.user.Stepdefinition.order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.order.CreateOrderEmptyField;

public class CreateOrderEmptyFieldSteps {
    @Steps
    CreateOrderEmptyField CreateOrderEmptyField;

    @Given("i set API endpoint for create order with empty field")
    public void setAPIendpointCreateOrderEmptyField(){
        CreateOrderEmptyField.setAPIendpointCreateOrderEmptyField();
    }

    @When("i send request to create order with empty field")
    public void sendRequestCreateOrderEmptyField(){
        CreateOrderEmptyField.sendRequestCreateOrderEmptyField();
    }
}
