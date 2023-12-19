package starter.admin.menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetMenubyCategory {

    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for get menu by exist category")
    public String setAPIendpointGetMenuCategory(){
        return url + "/admin/menu/category/3";
    }

    @Step("i send request to get menu by exist category")
    public void sendRequestGetMenuCategory(){
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAPIendpointGetMenuCategory());
    }

    @Step("i receive menu by category")
    public void receiveMenuByCategory(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.GetMenuByCategory_Response_Schema);
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
