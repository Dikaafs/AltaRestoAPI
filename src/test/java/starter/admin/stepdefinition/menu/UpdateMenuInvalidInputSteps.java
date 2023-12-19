package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.UpdateMenuInvalidInput;

public class UpdateMenuInvalidInputSteps {

    @Steps
    UpdateMenuInvalidInput updateMenuInvalidInput;

    @When("i send request to update menu with invalid input")
    public void sendRequestUpdateMenuInvalidInput(){
        updateMenuInvalidInput.sendRequestUpdateMenuInvalidInput();
    }
}
