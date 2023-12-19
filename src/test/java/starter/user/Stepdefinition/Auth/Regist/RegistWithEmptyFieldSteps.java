package starter.admin.stepdefinition.Auth.Regist;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth.Regist.RegistWithEmptyField;

public class RegistWithEmptyFieldSteps {
    @Steps
    RegistWithEmptyField registWithEmptyField;

    @When("i send request to regist with empty field")
    public void SendRequestRegistWithoutHook(){
        registWithEmptyField.SendRequestRegistWithEmptyField();
    }
}
