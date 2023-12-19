package starter.user.Auth.UpdatePassword;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class UpdatePasswordUser {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for update password user")
    public String setApiEndpointUpdatePasswordUser() {
        return url + "user/password/3";
    }

    @Step("i send request to update password with valid input")
    public void sendRequestUpdatePasswordUserValidInput() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("Password", "$2a$10$7SMdtJbNjxez3COAsebulOS2dN2RqhSWu67DSSiipMSBiBhS3kKJi");
        String token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setApiEndpointUpdatePasswordUser());
    }

    @Step("password user has been changed")
    public void passwordUserChanged() {
        JsonSchemaHelperUser helperUser = new JsonSchemaHelperUser();
        String schema = helperUser.getResponseSchemaUser(JsonSchemaUser.UpdatePasswordUser_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'Username'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'Password'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'CreateAt'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'UpdateAt'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'DeleteAt'", nullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
