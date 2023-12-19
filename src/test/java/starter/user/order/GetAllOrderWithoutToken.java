package starter.user.order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetAllOrderWithoutToken {
    private static String url = "http://13.229.89.154/";
    @Step("i set API endpoint for get all order without login token")
    public String setAPIendpointGetAllOrderWithoutToken(){
        return url+ "user/order";
    }

    @Step("i send request to get all order without login token")
    public void sendRequestGetAllOrderWithoutToken(){
        SerenityRest.given()
                .header("Content-Type","application/json")
                .get(setAPIendpointGetAllOrderWithoutToken());
    }
}
