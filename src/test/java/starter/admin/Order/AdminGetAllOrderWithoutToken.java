package starter.admin.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AdminGetAllOrderWithoutToken extends AdminGetAllOrder {
    @Step("i send request to get all order without login token admin")
    public void AdminSendRequestGetAllOrderWithoutToken(){
        SerenityRest.given()
                .header("Content-Type","application/json")
                .get(AdminSetApiEndpointGetAllOrder());
    }
}
