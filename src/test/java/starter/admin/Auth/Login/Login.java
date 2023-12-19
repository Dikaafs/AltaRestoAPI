package starter.admin.Auth.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class Login {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for login")
    public String SetApiEndpointForLogin(){
        return url+"admin/login";
    }

    @Step("i send request to login with valid email{string} and valid password{string}")
    public void SendLoginRequest(String email,String password){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(SetApiEndpointForLogin());
    }

    @Step("i receive access token from login")
    public void ReceiveAccessToken(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.Login_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'access_token'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
