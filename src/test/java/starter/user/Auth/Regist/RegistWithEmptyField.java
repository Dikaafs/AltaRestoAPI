package starter.user.Auth.Regist;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

public class RegistWithEmptyField extends Register {
    @Step("i send request to regist with empty field")
    public void SendRequestRegistWithEmptyField() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username","user1");
        requestBody.put("email","");
        requestBody.put("password","dika1409");
        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(SetApiEndpointRegist());
    }
}
