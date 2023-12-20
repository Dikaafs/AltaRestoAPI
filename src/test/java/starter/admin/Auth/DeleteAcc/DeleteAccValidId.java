package starter.admin.Auth.DeleteAcc;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAccValidId {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for delete account with valid id")
    public String setApiEndpointDeleteAccValidId(){
        return url+"admin/delete/9";
    }

    @Step("i send request to delete account with valid id")
    public void SendRequestDeleteAccValidId(){
        JSONObject requestBody = new JSONObject();
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .delete(setApiEndpointDeleteAccValidId());
    }

    @Step("i receive message {string}")
    public void receiveMessage(String message){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.DeleteAccValidId_Response_Schema);
        restAssuredThat(response -> response.body("'response'.'message'", equalTo(message)));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
