package StepDefinations;

import Pages.Scenarios;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.UnsupportedEncodingException;

public  class ScenariosStepDefinations {

    Page page=Scenarios.initDriver("chrome");

    public ScenariosStepDefinations() throws UnsupportedEncodingException {
        this.page=page;
    }

    @Given("^user opens page \"([^\"]*)\"$")
    public void userOpensPage(String arg0)  {

        page.navigate(arg0);


    }

    @When("^user searches with \"([^\"]*)\"$")
    public void userSearchesWith(String arg0) {
        page.fill("//textarea[@title='Search']",arg0);

    }
}