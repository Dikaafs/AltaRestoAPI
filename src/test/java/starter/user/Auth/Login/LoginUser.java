package starter.user.Auth.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class LoginUser {

    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for login user")
    public String setApiEndpointLoginUser(){
        return url+"user/login";
    }
    @Step("i send request to login user with valid email {string} and valid password {string}")
    public void sendRequestLoginUser(String email,String password){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointLoginUser());
    }
    @Step("i receive access token from login user")
    public void receiveAccessTokenLoginUser(){
        JsonSchemaHelperUser helper = new JsonSchemaHelperUser();
        String schema = helper.getResponseSchemaUser(JsonSchemaUser.LoginUser_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'access_token'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
