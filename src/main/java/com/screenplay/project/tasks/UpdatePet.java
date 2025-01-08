package com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdatePet implements Task {
    private final String name;

    public UpdatePet(String name) {
        this.name = name;
    }

    public static UpdatePet withName(String name) {
        return instrumented(UpdatePet.class, name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = String.format("{\"id\": 12345, \"name\": \"%s\", \"status\": \"available\"}", name);
        actor.attemptsTo(
                Put.to("/pet").with(request -> request.body(body).header("Content-Type", "application/json"))
        );
    }
}
