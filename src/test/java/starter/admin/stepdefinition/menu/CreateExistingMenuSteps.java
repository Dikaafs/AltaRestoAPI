package starter.admin.stepdefinition.menu;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.menu.CreateExistingMenu;

public class CreateExistingMenuSteps {

    @Steps
    CreateExistingMenu createExistingMenu;

    @When("i send request to create new menu with existing menu")
    public void sendRequestCreateExistingMenu(){
        createExistingMenu.sendRequestCreateExistingMenu();
    }
}
