package starter.admin.stepdefinition.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Order.AdminGetAllOrder;

public class AdminGetAllOrderSteps {

    @Steps
    AdminGetAllOrder adminGetAllOrder;

    @Given("i set API admin endpoint for get all order with valid endpoint")
    public void AdminSetApiEndpointGetAllOrder(){
        adminGetAllOrder.AdminSetApiEndpointGetAllOrder();
    }
    @When("i send request to get all order with valid admin endpoint")
    public void AdminSendRequestGetAllOrder(){
        adminGetAllOrder.AdminSendRequestGetAllOrder();
    }
    @And("i receive order history")
    public void ReceiveOrderHistory(){
        adminGetAllOrder.ReceiveOrderHistory();
    }
}
