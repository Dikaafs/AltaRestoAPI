package starter.user.order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetOrderById {

    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for get order with valid id")
    public String setAPIendpointGetOrderValidId() {
        return url + "/user/order/2";
    }

    @Step("i send Request to get order with valid id")
    public void sendRequestGetOrderValidId() {
        String token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAPIendpointGetOrderValidId());
    }

    @Step("i receive data order from valid id")
    public void receiveDataOrderValidId() {
        JsonSchemaHelperUser helperUser = new JsonSchemaHelperUser();
        String schema = helperUser.getResponseSchemaUser(JsonSchemaUser.GetOrderById_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'id'", equalTo(2)));
        restAssuredThat(response -> response.body("'results'.'order_items'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'totalPrice'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'status'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}