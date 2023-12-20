package starter.admin.menu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class CreateNewMenu {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for create new menu with valid input")
    public String setApiEndpointForCreateNewMenuValidInput() {
        return url+"admin/create/menu";
    }

    @Step("i send request to create new menu with valid input")
    public void sendRequestCreateNewMenuValidInput() {
        String token = GenerateToken.generateToken();

        File imageMenu = new File("src/test/resources/bihun.jpeg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("image", imageMenu)
                .multiPart("name", "bihun komplit")
                .multiPart("categoryid", 1)
                .multiPart("description", "bihun komplit")
                .multiPart("price", 20000)
                .post(setApiEndpointForCreateNewMenuValidInput());
    }
    @Step("i receive status code 201")
    public void receiveStatusCode201(){
        restAssuredThat(response ->response.statusCode(201));

    }
    @Step("i receive valid data of new menu")
    public void receiveValidDataNewMenu() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.CreateNewMenu_Response_Schema);

        restAssuredThat(response -> response.body("'results'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'image'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'name'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'categoryid'", equalTo(1)));
        restAssuredThat(response -> response.body("'results'.'description'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'price'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'status'", is(true)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}