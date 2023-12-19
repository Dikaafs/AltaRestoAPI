package starter.admin.Auth.UpdatePassword;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdatePassword {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for update password")
    public String setApiEndpointUpdatePassword(){
        return url+"admin/password/1";
    }

    @Step("i send request to update password with valid id")
    public void sendRequestUpdatePassword(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("Password", "$2a$10$c14GQjBbD3G0wrpi6AuNtOKBaOGrTv5E2sAT/JrnB/HL251cs4SPm");
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setApiEndpointUpdatePassword());
    }

    @Step("i receive status code 200")
    public void ReceiveStatusCode200(){
        restAssuredThat(response ->response.statusCode(200));
    }

    @Step("password has been changed")
    public void PasswordChanged(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.UpdatePassword_Respone_Schema);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
