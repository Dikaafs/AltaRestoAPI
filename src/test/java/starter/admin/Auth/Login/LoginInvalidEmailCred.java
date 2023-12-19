package starter.admin.Auth.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.admin.Auth.Login.Login;

public class LoginInvalidEmailCred extends Login {

    @Step("i send request to login with invalid email credentials{string} and invalid password{string}")
    public void SendRequestLoginInvalidEmailCredentials(String email,String password){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(SetApiEndpointForLogin());
    }
}
