package starter.admin.Auth.UpdatePassword;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UpdatePasswordInvalidId {

    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for update password with invalid id")
    public String SetApiEndpointUpdatePasswordInvalidId(){
        return url+"admin/password/A";
    }
    @Step("i send request to update password with invalid id")
    public void SendRequestUpdatePasswordInvalidId(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("Password", "$2a$10$ACjBoai06L9ItAP4oS.yl..h2.xqlzVuEyG9nPcqKoIsM1vN.a7n6");
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(SetApiEndpointUpdatePasswordInvalidId());
    }
    @Step("i receive error message {string}")
    public void ReceiveErrorMessage(String message){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.ErrorMessage_Response_Schema);
        restAssuredThat(response -> response.body("'response'.'message'", equalTo(message)));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
