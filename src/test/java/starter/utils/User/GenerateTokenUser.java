package starter.utils.User;

import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.Admin.FileUtils;

public class GenerateTokenUser {
    public static String generateTokenUser() {
        JSONObject userData = FileUtilsToken.getTokenUser();
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", userData.get("email"));
        requestBody.put("password", userData.get("password"));

        ResponseBody loginUserResponse = SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post("http://13.229.89.154/user/login")
                .body();

        System.out.println("the token: " + loginUserResponse.asString());

        JSONObject loginUserResponseBody = new JSONObject(loginUserResponse.asString());

        return loginUserResponseBody.getJSONObject("results").optString("access_token");
    }
}
