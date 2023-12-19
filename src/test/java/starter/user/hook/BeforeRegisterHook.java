package starter.user.hook;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class BeforeRegisterHook {
    @Before(value = "@Register")
    public static void beforeTest() {
        Faker faker = new Faker();

        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password(8,12);
        String username = faker.name().name();

        JSONObject requestBody = new JSONObject();

        requestBody.put("username", username);
        requestBody.put("email", email);
        requestBody.put("password", password);

        String filePath = "src/test/resources/sample/admin.json";

        try {
            String jsonString = requestBody.toString();

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jsonString);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}