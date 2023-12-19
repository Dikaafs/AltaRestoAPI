package starter.admin.menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetMenuUncreatedName {
    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for get menu uncreated Name")
    public String setAPIendpointGetMenuUncreated(){
        return url + "/admin/menu/name/nasi bakar";
    }

    @Step("i send request to get menu uncreated Name")
    public void sendRequestGetMenuUncreated(){
        String token = GenerateToken.generateToken();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAPIendpointGetMenuUncreated());
    }

    @Step("i receive status code 404")
    public void receiveStatusCode404(){
        restAssuredThat(response ->response.statusCode(404));
    }
}
