package starter.user.order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllOrder {

    private static String url = "http://13.229.89.154/";
    @Step("i set API endpoint for get all order with valid endpoint")
    public String setAPIendpointGetAllOrderValidEndpoint(){
        return url+ "user/order";
    }

    @Step("i send request to get all order with valid endpoint")
    public void sendRequestGetAllOrderValidEndpoint(){
        String Token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + Token)
                .get(setAPIendpointGetAllOrderValidEndpoint());
    }

    @Step("i receive entire order history")
    public void receiveEntireOrderHistory(){
        JsonSchemaHelperUser helperUser = new JsonSchemaHelperUser();
        String schema = helperUser.getResponseSchemaUser(JsonSchemaUser.GetAllOrder_Response_Schema);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
