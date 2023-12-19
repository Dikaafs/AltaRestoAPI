package starter.user.order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import java.util.ArrayList;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class CreateOrder {

    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for create order with valid menu id")
    public String setAPIendpointCreateOrderValidMenuID() {

        return url + "/user/create/order";
    }

    @Step("i send request to create new order")
    public void sendRequestCreateOrderValidMenuID() {
        JSONObject requestBody = new JSONObject();
        JSONArray orderitem = new JSONArray();

        orderitem.put(new JSONObject().put("menu_id",3).put("quantity",10));

        requestBody.put("order_items", orderitem);


        String token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setAPIendpointCreateOrderValidMenuID());
    }

    @Step("i receive valid data my order")
    public void receiveValidDataMyOrder() {
        JsonSchemaHelperUser helperUser = new JsonSchemaHelperUser();
        String schema = helperUser.getResponseSchemaUser(JsonSchemaUser.CreateOrder_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'order_items'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'totalPrice'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'status'", is("Sent")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
