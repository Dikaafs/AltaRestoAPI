package starter.admin.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AdminGetAllOrder {
    private static String url = "http://13.229.89.154/";
    @Step("i set API admin endpoint for get all order with valid endpoint")
    public String AdminSetApiEndpointGetAllOrder(){
        return url+ "admin/order";
    }

    @Step("i send request to get all order with valid admin endpoint")
    public void AdminSendRequestGetAllOrder(){
        String Token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + Token)
                .get(AdminSetApiEndpointGetAllOrder());
    }
    @Step("i receive order history")
    public void ReceiveOrderHistory(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.AdminGetAllOrder_Response_Schema);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
