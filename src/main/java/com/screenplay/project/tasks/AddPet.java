package com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddPet implements Task {

    private final String id;
    private final String name;

    public AddPet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static AddPet withDetails(String id, String name) {
        return instrumented(AddPet.class, id, name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = String.format("{\"id\": %s, \"name\": \"%s\", \"status\": \"available\"}", id, name);
        actor.attemptsTo(
                Post.to("/pet").with(request -> request.body(body).header("Content-Type", "application/json"))
        );
    }
}
