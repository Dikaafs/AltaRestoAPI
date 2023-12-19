package starter.user.Stepdefinition.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.collections4.Get;
import starter.user.order.GetAllOrder;

public class GetAllOrderSteps {

    @Steps
    GetAllOrder getAllOrder;

    @Given("i set API endpoint for get all order with valid endpoint")
    public void setAPIendpointGetAllOrderValidEndpoint(){
        getAllOrder.setAPIendpointGetAllOrderValidEndpoint();
    }

    @When("i send request to get all order with valid endpoint")
    public void sendRequestGetAllOrderValidEndpoint(){
        getAllOrder.sendRequestGetAllOrderValidEndpoint();
    }

    @And("i receive entire order history")
    public void receiveEntireOrderHistory(){
        getAllOrder.receiveEntireOrderHistory();
    }
}
