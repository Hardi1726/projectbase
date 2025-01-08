package com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class VerifyPetName implements Task {
    private final String expectedName;

    public VerifyPetName(String expectedName) {
        this.expectedName = expectedName;
    }

    public static VerifyPetName is(String expectedName) {
        return instrumented(VerifyPetName.class, expectedName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThatResponse("Verify pet name",
                        response -> response.statusCode(200)
                                .body("name", Matchers.equalTo(expectedName))
                )
        );
    }
}
