package starter.admin.stepdefinition.Auth.Login;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.Auth.Login.LoginUnregisteredAcc;

public class LoginUnregisteredAccSteps {

    @Steps
    LoginUnregisteredAcc loginUnregisteredAcc;

    @When("i send request to login with invalid email{string} and invalid password{string}")
    public void SendRequestUnregisteredAcc(String email,String password){
        loginUnregisteredAcc.SendRequestUnregisteredAcc(email,password);
    }
}
