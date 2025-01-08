package com.screenplay.project.hooks;

import com.screenplay.project.utils.ApiConfig;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void setupApi() {
        ApiConfig.setup();
    }

}
