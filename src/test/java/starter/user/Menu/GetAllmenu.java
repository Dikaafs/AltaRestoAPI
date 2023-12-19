package starter.user.Menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllmenu {
    private static String url = "http://13.229.89.154/";
    @Step("i set API endpoint for get all menu with valid endpoint")
    public String setAPIendpointGetAllMenuValidEndpoint(){
        return url+ "user/menu";
    }

    @Step("i send request to get all menu with valid endpoint")
    public void sendRequestGetAllMenuValidEndpoint(){
        String Token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + Token)
                .get(setAPIendpointGetAllMenuValidEndpoint());
    }

    @Step("i receive entire menu")
    public void ReceiveEntireMenu(){
        JsonSchemaHelperUser helperUser = new JsonSchemaHelperUser();
        String schema = helperUser.getResponseSchemaUser(JsonSchemaUser.GetAllMenu_Response_Schema);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
