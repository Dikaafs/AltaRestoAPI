package starter.user.Stepdefinition.Payment;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Payment.CreatePaymentUnExistId;

public class CreatePaymentUnExistIdSteps {

    @Steps
    CreatePaymentUnExistId createPaymentUnExistId;

    @When("i send request to create payment with unexist order id")
    public void sendRequestCreatePaymentUnExistId(){
        createPaymentUnExistId.sendRequestCreatePaymentUnExistId();
    }
}
