package starter.user.order;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.User.GenerateTokenUser;

public class CreateOrderEmptyField {
    private static String url = "http://13.229.89.154";

    @Step("i set API endpoint for create order with empty field")
    public String setAPIendpointCreateOrderEmptyField() {

        return url + "/user/create/order";
    }

    @Step("i send request to create order with empty field")
    public void sendRequestCreateOrderEmptyField() {
        JSONObject requestBody = new JSONObject();
        JSONArray orderitem = new JSONArray();

        orderitem.put(new JSONObject().put("menu_id","").put("quantity",""));

        requestBody.put("order_items", orderitem);


        String token = GenerateTokenUser.generateTokenUser();
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setAPIendpointCreateOrderEmptyField());
    }
}
