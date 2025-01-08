package com.screenplay.project.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class SetupActor {

    public static Actor initializeActor() {
        return Actor.named("User").whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));
    }

}
