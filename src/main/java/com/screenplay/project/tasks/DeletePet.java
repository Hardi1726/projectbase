package com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletePet implements Task {
    private final String id;

    public DeletePet(String id) {
        this.id = id;
    }

    public static DeletePet withId(String id) {
        return instrumented(DeletePet.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/pet/" + id)
        );
    }
}