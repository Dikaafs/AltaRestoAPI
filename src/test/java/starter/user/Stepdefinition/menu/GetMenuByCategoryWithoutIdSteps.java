package starter.user.Stepdefinition.menu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Menu.GetMenuByCategoryWithoutId;

public class GetMenuByCategoryWithoutIdSteps {
    @Steps
    GetMenuByCategoryWithoutId getMenuByCategoryWithoutId;

    @Given("i set API endpoint for get menu without input id category on the endpoint")
    public void setAPIendpointGetMenuWithoudIdCategory(){
        getMenuByCategoryWithoutId.setAPIendpointGetMenuWithoudIdCategory();
    }

    @When("i send request to get menu without input id category on the endpoint")
    public void sendRequestGetMenuWithoutIdCategory(){
        getMenuByCategoryWithoutId.sendRequestGetMenuWithoutIdCategory();
    }
}
