package starter.admin.Order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;
import starter.utils.User.GenerateTokenUser;

public class AdminGetOrderByInvalidId {
    private static String url = "http://13.229.89.154";

    @Step("i set Admin API endpoint for get order with invalid id")
    public String setAdminAPIendpointGetOrderInvalidId() {
        return url + "/admin/order/999";
    }

    @Step("i send request Admin to get order with invalid id")
    public void sendRequestAdminGetOrderInvalidId() {
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAdminAPIendpointGetOrderInvalidId());
    }
}
