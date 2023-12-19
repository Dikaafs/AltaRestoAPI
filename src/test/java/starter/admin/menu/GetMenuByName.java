package starter.admin.menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetMenuByName {

    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for get menu by name")
    public String setApiEndpointGetMenuByName(){
        return url + "/admin/menu/name/caramel macchiato";
    }

    @Step("i send request to get menu by name")
    public void sendRequestGetMenuByName(){
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setApiEndpointGetMenuByName());
    }

    @Step("i receive valid data menu by name")
    public void receiveValidDataMenuByName(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.GetMenuByName_Response_Schema);

        restAssuredThat(response -> response.body("'results'.'id'", equalTo(4)));
        restAssuredThat(response -> response.body("'results'.'image'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'name'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'categoryid'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'description'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'price'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'status'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
