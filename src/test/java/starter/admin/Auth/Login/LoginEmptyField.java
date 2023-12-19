package starter.admin.Auth.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;


import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LoginEmptyField extends Login {
    @Step("i send request to login with emtpy field email {string} and valid password {string}")
    public void sendRequestLoginWithEmptyField(String email,String password){
        JSONObject requestBody = new JSONObject();

        requestBody.put("email", email);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(SetApiEndpointForLogin());
    }

    @Step("i receive status code 500")
    public void receiveStatusCode500(){
        restAssuredThat(response ->response.statusCode(500));
    }
}