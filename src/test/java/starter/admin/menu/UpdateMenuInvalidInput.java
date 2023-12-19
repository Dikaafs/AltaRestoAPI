package starter.admin.menu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Admin.GenerateToken;

import java.io.File;

public class UpdateMenuInvalidInput extends UpdateMenu{
    @Step("i send request to update menu with invalid input")
    public void sendRequestUpdateMenuInvalidInput(){
        String token = GenerateToken.generateToken();

        File imageMenu = new File("src/test/resources/nasi-kuning.jpg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("image",imageMenu)
                .multiPart("id", 2)
                .multiPart("name", "nasi tumpeng")
                .multiPart("categoryid", 2)
                .multiPart("description", "Makanan unik dengan design berbentuk kerucut")
                .multiPart("price", "dua puluh ribu")
                .put(setAPIendpointUpdateMenu());
    }
}
