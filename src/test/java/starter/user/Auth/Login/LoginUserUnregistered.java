package starter.user.Auth.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

public class LoginUserUnregistered extends LoginUser {
    @Step("i send request to login user with invalid email{string} and invalid password{string}")
    public void SendRequestUserUnregistered(String email,String password){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(setApiEndpointLoginUser());
    }
}
