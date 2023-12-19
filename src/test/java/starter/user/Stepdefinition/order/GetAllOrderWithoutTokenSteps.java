package starter.user.Stepdefinition.order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.order.GetAllOrderWithoutToken;

public class GetAllOrderWithoutTokenSteps {

    @Steps
    GetAllOrderWithoutToken GetAllOrderWithoutToken;

    @Given("i set API endpoint for get all order without login token")
    public void setAPIendpointGetAllOrderWithoutToken(){
        GetAllOrderWithoutToken.setAPIendpointGetAllOrderWithoutToken();
    }

    @When("i send request to get all order without login token")
    public void sendRequestGetAllOrderWithoutToken(){
        GetAllOrderWithoutToken.sendRequestGetAllOrderWithoutToken();
    }
}
