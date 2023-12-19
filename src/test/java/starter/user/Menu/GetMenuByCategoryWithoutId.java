package starter.user.Menu;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.User.GenerateTokenUser;

public class GetMenuByCategoryWithoutId {
    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for get menu without input id category on the endpoint")
    public String setAPIendpointGetMenuWithoudIdCategory(){
        return url + "/user/menu/category/";
    }

    @Step("i send request to get menu without input id category on the endpoint")
    public void sendRequestGetMenuWithoutIdCategory(){
        String token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + token)
                .get(setAPIendpointGetMenuWithoudIdCategory());
    }
}
