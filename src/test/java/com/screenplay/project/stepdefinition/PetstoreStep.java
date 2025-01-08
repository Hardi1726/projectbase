package com.screenplay.project.stepdefinition;

import com.screenplay.project.tasks.*;
import com.screenplay.project.utils.SetupActor;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class PetstoreStep {

        Actor user = SetupActor.initializeActor();

        @Before
        public void setTheStage() {
            OnStage.setTheStage(new OnlineCast());
        }

        @Given("the Petstore API is available")
        public void thePetstoreAPIIsAvailable() {
            user.attemptsTo();
        }

        @When("I add a new pet with ID {string} and name {string}")
        public void iAddANewPet(String id, String name) {
           user.attemptsTo(AddPet.withDetails("12345", "Fluffy"));
        }

        @Then("I should retrieve the pet with ID {string}")
        public void iShouldRetrieveThePet(String id) {
            user.attemptsTo(GetPet.withId(id));
        }

        @When("I update the pet name to {string}")
        public void iUpdateThePetName(String newName) {
            user.attemptsTo(UpdatePet.withName(newName));
        }

        @Then("I should verify the pet name is updated to {string}")
        public void iShouldVerifyThePetNameIsUpdated(String newName) {
            user.attemptsTo(VerifyPetName.is(newName));
        }

        @When("I delete the pet with ID {string}")
        public void iDeleteThePet(String id) {
            user.attemptsTo(DeletePet.withId(id));
        }

        @Then("I should verify the pet is deleted successfully")
        public void iShouldVerifyThePetIsDeletedSuccessfully() {
            user.attemptsTo(VerifyPetDeletion.success());
        }
}
