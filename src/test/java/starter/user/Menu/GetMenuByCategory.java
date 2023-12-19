package starter.user.Menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetMenuByCategory {
    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for get menu with exist category")
    public String setAPIendpointGetMenuExistCategory(){
        return url + "/user/menu/category/3";
    }

    @Step("i send request to get menu with exist category")
    public void sendRequestGetMenuExistCategory(){
        String token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAPIendpointGetMenuExistCategory());
    }

    @Step("i receive menu by category")
    public void ReceiveMenuByCategory(){
        JsonSchemaHelperUser helperUser = new JsonSchemaHelperUser();
        String schema = helperUser.getResponseSchemaUser(JsonSchemaUser.GetMenuByCategory_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'image'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'name'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'categoryid'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'description'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'price'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'status'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
