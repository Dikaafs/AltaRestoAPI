package starter.user.Payment;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.User.GenerateTokenUser;
import starter.utils.User.JsonSchemaHelperUser;
import starter.utils.User.JsonSchemaUser;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class CreatePayment {
    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for create payment")
    public String setAPIendpointCreatePaymentValidId() {
        return url+"user/create/payment";
    }

    @Step("i send request to create payment with valid order id")
    public void sendRequestCreatePaymentValidId() {
        String token = GenerateTokenUser.generateTokenUser();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("order_ID", 2)
                .post(setAPIendpointCreatePaymentValidId());
    }

    @Step("i receive valid data payment")
    public void receiveValidDataPayment() {
        JsonSchemaHelperUser helperUser = new JsonSchemaHelperUser();
        String schema = helperUser.getResponseSchemaUser(JsonSchemaUser.CreatePayment_Response_Schema);
        restAssuredThat(response -> response.body("'results'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'order_id'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'token'", notNullValue()));
        restAssuredThat(response -> response.body("'results'.'redirect_url'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
