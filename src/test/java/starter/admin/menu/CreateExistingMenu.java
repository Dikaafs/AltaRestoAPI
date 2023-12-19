package starter.admin.menu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;

import java.io.File;

public class CreateExistingMenu extends CreateNewMenu{

    @Step("i send request to create new menu with existing menu")
    public void sendRequestCreateExistingMenu(){
        String token = GenerateToken.generateToken();

        File imageMenu = new File("src/test/resources/mint choco ice cream.jpg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("image", imageMenu)
                .multiPart("name", "Mint Choco Ice Cream")
                .multiPart("categoryid", 2)
                .multiPart("description", "rasa mint dipadu dengan coklat")
                .multiPart("price", 30000)
                .post(setApiEndpointForCreateNewMenuValidInput());
    }
}
