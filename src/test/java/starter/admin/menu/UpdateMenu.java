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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateMenu {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for update menu")
    public String setAPIendpointUpdateMenu(){
        return url+"admin/update/menu/23";
    }

    @Step("i send request to update menu with valid input")
    public void sendRequestUpdateMenuValidInput(){
        String token = GenerateToken.generateToken();

        File imageMenu = new File("src/test/resources/Tropical-Mocktail.jpg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("image",imageMenu)
                .multiPart("id", 23)
                .multiPart("name", "Tropical Mocktail")
                .multiPart("categoryid", 5)
                .multiPart("description", "Menyegarkan")
                .multiPart("price", 40000)
                .put(setAPIendpointUpdateMenu());

    }

    @Step("i receive valid data for updated menu")
    public void receiveValidDataUpdatedMenu(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.UpdateMenu_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'id'",equalTo(23)));
        restAssuredThat(response -> response.body("'results'.'image'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'name'",equalTo("Tropical Mocktail")));
        restAssuredThat(response -> response.body("'results'.'categoryid'",equalTo(5)));
        restAssuredThat(response -> response.body("'results'.'description'",equalTo("Menyegarkan")));
        restAssuredThat(response -> response.body("'results'.'price'",equalTo(40000)));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
