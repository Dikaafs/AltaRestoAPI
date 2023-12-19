package starter.user.Stepdefinition.Auth.Regist;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Auth.Regist.Register;


public class RegisterSteps {
    @Steps
    Register register;

    @Given("i set API endpoint for regist")
    public void SetApiEndpointRegist(){
        register.SetApiEndpointRegist();
    }

    @When("i send request to regist with valid credentials")
    public void SendRequestRegistValidEmailCred(){
        register.SendRequestRegistValidCred();
    }

    @And("i receive valid data from regist")
    public void ReceiveValidDataFromRegist(){
        register.ReceiveValidDataFromRegist();
    }
}
