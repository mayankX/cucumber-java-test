package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.DatabaseConnection;

/**
 * Created by Mayank Tiwari on 2019-07-04.
 */
public class TransactionGeneratorTest extends DatabaseConnection {

    @Given("^I am connected with the database$")
    public void i_am_connected_with_the_database() throws Throwable {
        createConnection();
    }

    @When("^I run the select query$")
    public void i_run_the_select_query() throws Throwable {
        createQuery();
        executeQuery();
    }

    @Then("^I should see the result as \"([^\"]*)\"$")
    public void i_should_see_the_result_as(String name) throws Throwable {
        assertRecords(name);
    }
}