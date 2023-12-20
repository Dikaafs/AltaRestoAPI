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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AdminGetOrderValidId {
    private static String url = "http://13.229.89.154";

    @Step("i set Admin API endpoint for get order with valid id")
    public String setAdminAPIendpointGetOrderById() {
        return url + "/admin/order/12";
    }

    @Step("i send Request Admin to get order with valid id")
    public void sendRequestAdminGetOrderById() {
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAdminAPIendpointGetOrderById());
    }

    @Step("receive data order from valid id")
    public void ReceiveDataOrderById() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.AdminGetOrderById_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'id'", equalTo(12)));
        restAssuredThat(response -> response.body("'results'.'order_items'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'totalPrice'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'status'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
