package starter.user.order;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.User.GenerateTokenUser;

public class UpdateItemInvalidInput extends UpdateItem{
    @Step("i send request to update item with invalid input")
    public void sendRequestUpdateItemInvalidInput() {
        String token = GenerateTokenUser.generateTokenUser();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("id", "AB1")
                .multiPart("quantity", "dua")
                .put(setAPIendpointUpdateItemValidInput());
    }
}
