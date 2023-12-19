package starter.admin.Auth.FindAccount;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class FindAcc {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for find acc user")
    public String setApiEndpointFindAccUser(){
        return url+"admin";
    }

    @Step("i send request to find acc user")
    public void SendRequestFindAccUser(){
        JSONObject requestBody = new JSONObject();
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .get(setApiEndpointFindAccUser());
    }

    @Step("i receive valid data user acc")
    public void receiveValidDataUserAcc() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.FindAcc_Response_Schema);

        restAssuredThat(response -> response.body("'results'.'Username'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'Password'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'CreateAt'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'UpdateAt'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'DeleteAt'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
