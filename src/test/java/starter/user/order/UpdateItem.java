package starter.user.order;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class UpdateItem {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for update item")
    public String setAPIendpointUpdateItemValidInput() {
        return url + "user/order/update-item";
    }

    @Step("i send request to update item with valid input")
    public void sendRequestUpdateItemValidInput() {
        String token = GenerateTokenUser.generateTokenUser();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("id", "2")
                .multiPart("quantity", "4")
                .put(setAPIendpointUpdateItemValidInput());
    }

    @Step("i receive valid data updated item")
    public void receiveValidDataUpdatedItem() {
        JsonSchemaHelperUser helperUser = new JsonSchemaHelperUser();
        String schema = helperUser.getResponseSchemaUser(JsonSchemaUser.UpdateItem_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'id'", equalTo(2)));
        restAssuredThat(response -> response.body("'results'.'order_items'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'totalPrice'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'status'", is("Accepted")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}