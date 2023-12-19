package starter.admin.Order;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.Admin.JsonSchemaAdmin;
import starter.utils.Admin.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.is;

public class UpdateOrderStatus {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for update order status with valid input")
    public String setAPIendpointUpdateOrderStatusValidInput(){
        return url+"admin/order/status/2";
    }

    @Step("i send request to update order status with valid input")
    public void sendRequestUpdateOrderStatusValidInput() {
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("status", "Accepted")
                .put(setAPIendpointUpdateOrderStatusValidInput());
    }

    @Step("i receive success message {string}")
    public void receiveSuccessMessage(String message){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchemaAdmin.UpdateOrderStatus_Response_Schema);
        restAssuredThat(response -> response.body("'response'.'message'", is(message)));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
