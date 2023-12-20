package starter.admin.stepdefinition.Order;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Order.AdminGetAllOrderWithoutToken;

public class AdminGetAllOrderWithoutTokenSteps {
    @Steps
    AdminGetAllOrderWithoutToken adminGetAllOrderWithoutToken;

    @When("i send request to get all order without login token admin")
    public void AdminSendRequestGetAllOrderWithoutToken(){
        adminGetAllOrderWithoutToken.AdminSendRequestGetAllOrderWithoutToken();
    }
}
