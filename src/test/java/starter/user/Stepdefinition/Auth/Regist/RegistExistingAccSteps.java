package starter.admin.stepdefinition.Auth.Regist;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth.Regist.RegistExistingAcc;

public class RegistExistingAccSteps {

    @Steps
    RegistExistingAcc registExistingAcc;

    @When("i send request to regist with existing account")
    public void sendRequestRegistExistingAcc(){
        registExistingAcc.sendRequestRegistExistingAcc();
    }
}
