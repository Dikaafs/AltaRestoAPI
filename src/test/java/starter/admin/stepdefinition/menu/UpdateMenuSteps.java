package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.UpdateMenu;

public class UpdateMenuSteps {
    @Steps
    UpdateMenu updateMenu;

    @Given("i set API endpoint for update menu")
    public void setAPIendpointUpdateMenu(){
        updateMenu.setAPIendpointUpdateMenu();
    }

    @When("i send request to update menu with valid input")
    public void sendRequestUpdateMenuValidInput(){
        updateMenu.sendRequestUpdateMenuValidInput();
    }

    @And("i receive valid data for updated menu")
    public void receiveValidDataUpdatedMenu(){
        updateMenu.receiveValidDataUpdatedMenu();
    }
}
