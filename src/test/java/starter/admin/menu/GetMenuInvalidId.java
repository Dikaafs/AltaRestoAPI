package starter.admin.menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetMenuInvalidId {

    private static String url = "http://13.229.89.154/";

    @Step("i set API endpoint for get menu invalid id")
    public String setAPIendpointGetMenuInvalidId(){
        return url + "admin/menu/AB01";
    }

    @Step("i send request to get menu invalid id")
    public void sendRequestGetMenuInvalidId(){
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAPIendpointGetMenuInvalidId());
    }

    @Step("i receive status code 400")
    public void ReceiveStatusCode400(){
        restAssuredThat(response ->response.statusCode(400));
    }
}
