package starter.user.Auth.Regist;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.User.FileUtilsUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class Register {

    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for regist")
    public String SetApiEndpointRegist() {
        return url + "user/register";
    }

    @Step("i send request to regist with valid credentials")
    public void SendRequestRegistValidCred() {
        JSONObject requestBody = FileUtilsUser.getUser();

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(SetApiEndpointRegist());
    }
    @Step("i receive valid data from regist")
    public void ReceiveValidDataFromRegist() {
        JsonSchemaHelperUser helper = new JsonSchemaHelperUser();
        String schema = helper.getResponseSchemaUser(JsonSchemaUser.Register_Response_Schema);

        restAssuredThat(response -> response.body("'results'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'username'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'email'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'no_hp'", equalTo("")));
        restAssuredThat(response -> response.body("'results'.'birth_date'", equalTo("")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
