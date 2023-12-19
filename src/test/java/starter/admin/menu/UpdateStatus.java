package starter.admin.menu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class UpdateStatus {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for update menu")
    public String setAPIendpointUpdateStatusValidMenuId(){
        return url+"admin/status/1";
    }

    @Step("i send request to update menu with valid input")
    public void sendRequestUpdateStatusValidMenuId() {
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("status", "ready")
                .put(setAPIendpointUpdateStatusValidMenuId());
    }

    @Step("status is updated")
    public void statusUpdated() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.UpdateStatus_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'id'", equalTo(1)));
        restAssuredThat(response -> response.body("'results'.'image'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'name'", equalTo("Tropical Mocktail")));
        restAssuredThat(response -> response.body("'results'.'categoryid'", equalTo(5)));
        restAssuredThat(response -> response.body("'results'.'description'", equalTo("Menyegarkan")));
        restAssuredThat(response -> response.body("'results'.'price'", equalTo(40000)));
        restAssuredThat(response -> response.body("'results'.'status'", is(true)));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}


