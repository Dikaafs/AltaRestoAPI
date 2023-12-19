package starter.user.Auth.Regist;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class RegistExistingAcc extends Register {

    @Step("i send request to regist with existing account")
    public void sendRequestRegistExistingAcc(){
        String username = "user";
        String email = "user@gmail.com";
        String password = "user1234";

        JSONObject requestBody = new JSONObject();
        requestBody.put("username",username);
        requestBody.put("email",email);
        requestBody.put("password",password);

        String filePath = "src/test/resources/sample/registUser.json";

        try {
            String jsonString = requestBody.toString();

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(requestBody.toString())
                .post(SetApiEndpointRegist());
    }
}
