package starter.user.order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.User.GenerateTokenUser;

public class GetOrderInvalidId {
    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for get order with invalid id")
    public String setAPIendpointGetOrderInvalidId() {
        return url + "/user/order/999";
    }

    @Step("i send request to get order with invalid id")
    public void sendRequestGetOrderInvalidId() {
        String token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAPIendpointGetOrderInvalidId());
    }
}
