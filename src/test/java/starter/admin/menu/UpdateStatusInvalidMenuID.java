package starter.admin.menu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;

public class UpdateStatusInvalidMenuID {

    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for update status with invalid menu id")
    public String setAPIendpointUpdateStatusInvalidMenuID(){
        return url+"admin/status/A01";
    }

    @Step("i send request to update status with invalid menu id")
    public void sendRequestUpdateStatusInvalidMenuID() {
        String token = GenerateToken.generateToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("status", "ready")
                .put(setAPIendpointUpdateStatusInvalidMenuID());
    }
}
