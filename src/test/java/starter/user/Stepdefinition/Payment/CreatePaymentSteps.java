package starter.user.Stepdefinition.Payment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Payment.CreatePayment;

public class CreatePaymentSteps {

    @Steps
    CreatePayment createPayment;

    @Given("i set API endpoint for create payment")
    public void setAPIendpointCreatePaymentValidId(){
        createPayment.setAPIendpointCreatePaymentValidId();
    }

    @When("i send request to create payment with valid order id")
    public void sendRequestCreatePaymentValidId(){
        createPayment.sendRequestCreatePaymentValidId();
    }

    @And("i receive valid data payment")
    public void receiveValidDataPayment(){
        createPayment.receiveValidDataPayment();
    }
}
