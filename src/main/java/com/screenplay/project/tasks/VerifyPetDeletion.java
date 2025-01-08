package com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class VerifyPetDeletion implements Task {

    public static VerifyPetDeletion success() {
        return instrumented(VerifyPetDeletion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThatResponse("Verify pet is deleted",
                        response -> response.statusCode(200)
                                .body("message", Matchers.equalTo("12345")) // El ID de la mascota eliminada
                )
        );
    }
}
