package starter.admin.stepdefinition.Order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Order.AdminGetOrderValidId;

public class AdminGetOrderValidIdSteps {

    @Steps
    AdminGetOrderValidId adminGetOrderValidId;

    @Given("i set Admin API endpoint for get order with valid id")
    public void setAdminAPIendpointGetOrderById(){
        adminGetOrderValidId.setAdminAPIendpointGetOrderById();
    }
    @When("i send Request Admin to get order with valid id")
    public void sendRequestAdminGetOrderById(){
        adminGetOrderValidId.sendRequestAdminGetOrderById();
    }
    @And("receive data order from valid id")
    public void ReceiveDataOrderById(){
        adminGetOrderValidId.ReceiveDataOrderById();
    }
}

