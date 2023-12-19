package starter.admin.menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllMenu {

    private static String url = "http://13.229.89.154/";
    @Step("i set API endpoint for get all menu")
    public String setAPIendpointGetAllMenu(){

        return url+ "admin/menu";
    }

    @Step("i send request to get all menu")
    public void sendRequestGetAllMenu(){
        String Token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + Token)
                .get(setAPIendpointGetAllMenu());
    }

    @Step("i receive valid data all menu")
    public void receiveValidDataAllMenu(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.GetAllMenu_Response_Schema);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
