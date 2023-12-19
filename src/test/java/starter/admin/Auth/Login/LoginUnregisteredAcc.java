package starter.admin.Auth.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

public class LoginUnregisteredAcc extends Login {
    @Step("i send request to login with invalid email{string} and invalid password{string}")
    public void SendRequestUnregisteredAcc(String email,String password){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(SetApiEndpointForLogin());
    }
}
