package starter.user.Payment;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.User.GenerateTokenUser;

public class CreatePaymentUnExistId extends CreatePayment{

    @Step("i send request to create payment with valid order id")
    public void sendRequestCreatePaymentUnExistId() {
        String token = GenerateTokenUser.generateTokenUser();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("order_ID", 999)
                .post(setAPIendpointCreatePaymentValidId());
    }
}
