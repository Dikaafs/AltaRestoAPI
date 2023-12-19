package starter.admin.menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetMenuInvalidCategoryId {

    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for get menu with invalid category id")
    public String setAPIendpointGetMenuInvalidCategoryId(){
        return url + "/admin/menu/category/AB12";
    }

    @Step("i send request to get menu with invalid category id")
    public void sendRequestGetMenuWithInvalidId(){
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAPIendpointGetMenuInvalidCategoryId());
    }

    @Step("i receive {string} message")
    public void receiveResponseMessage(String message){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.BadRequest_Response_Schema);
        restAssuredThat(response -> response.body("'response'.'message'", equalTo(message)));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
