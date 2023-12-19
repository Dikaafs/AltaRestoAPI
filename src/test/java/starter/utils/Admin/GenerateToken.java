package starter.utils.Admin;

import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

public class GenerateToken {
    public static String generateToken() {
        JSONObject userData = FileUtils.getAdmin();
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", userData.get("email"));
        requestBody.put("password", userData.get("password"));
        ResponseBody loginResponse = SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post("http://13.229.89.154/admin/login")
                .body();
        System.out.println("the token: " + loginResponse.asString());
        JSONObject loginResponseBody = new JSONObject(loginResponse.asString());
        return loginResponseBody.getJSONObject("results").optString("access_token");
    }
}
