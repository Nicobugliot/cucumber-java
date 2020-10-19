package UserCucumber;

import user.User;
import exception.UserAlreadyRegisteredException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber")
public class CucumberTest {

    private User user;
    private RuntimeException exception;

    @Given("^User with registration (true|false)$")
    public void userWithRegister(Boolean isRegistered) {
        user = new User();
        user.setRegistered(isRegistered);
    }

    @When("^User try to register with username (.+) and password (.+)$")
    public void userSignIn(String username, String password) {
        try {
            this.user.signIn(username, password);
        } catch (UserAlreadyRegisteredException e) {
            this.exception = e;
        }
    }

    @Then("User is register")
    public void userIsRegistered() {
        Assert.assertTrue(user.isRegistered());
    }

    @Then("^Operation must throw (.+)$")
    public void operationShouldBeDeniedBecauseItsAlreadyRegistered(String exceptionName) {
        Assert.assertEquals(exceptionName, this.exception.getClass().getSimpleName());
    }

    @When("^User adds (\\d+) dollars to his balance$")
    public void userAddsDollarsToHisBalance(double money) {
        this.user.addBalance(money);
    }

    @Then("^User have (\\d+) dollars$")
    public void userHaveDollars(double balance) {
        Assert.assertEquals(Double.valueOf(balance), user.getBalance());
    }


}
