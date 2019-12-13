package com.veselov.alex.unittesting.service;

import java.util.Arrays;

public class SomeBusinessLogic {
    private SomeDataService service;

    public int calculateSumUsingService() {
        return Arrays.stream(this.service.retrieveData())
                .reduce(Integer::sum).orElse(0);
    }

    public void setService(SomeDataService service) {
        this.service = service;
    }
}
