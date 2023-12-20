package starter.admin.stepdefinition.Order;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Order.AdminGetOrderByInvalidId;

public class AdminGetOrderByInvalidIdSteps {

    @Steps
    AdminGetOrderByInvalidId adminGetOrderByInvalidId;

    @Given("i set Admin API endpoint for get order with invalid id")
    public void setAdminAPIendpointGetOrderInvalidId(){
        adminGetOrderByInvalidId.setAdminAPIendpointGetOrderInvalidId();
    }
    @When("i send request Admin to get order with invalid id")
    public void sendRequestAdminGetOrderInvalidId(){
        adminGetOrderByInvalidId.sendRequestAdminGetOrderInvalidId();
    }
}
