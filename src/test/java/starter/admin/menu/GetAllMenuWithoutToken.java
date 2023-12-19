package starter.admin.menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAllMenuWithoutToken extends GetAllMenu {

    @Step("i send request to get all menu without login token")
    public void sendRequestGetAllMenuWithoutToken(){
        SerenityRest.given()
                .header("Content-Type","application/json")
                .get(setAPIendpointGetAllMenu());
    }

    @Step("i receive status code 401")
    public void receiveStatusCode401(){
        restAssuredThat(response ->response.statusCode(401));
    }

    @Step("i receive unauthorized message {string}")
    public void receiveUnauthorizedMessage(String UnauthorizedMessage){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.UnauthorizedMessage_Response_Schema);
        restAssuredThat(response -> response.body("'message'", equalTo(UnauthorizedMessage)));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
