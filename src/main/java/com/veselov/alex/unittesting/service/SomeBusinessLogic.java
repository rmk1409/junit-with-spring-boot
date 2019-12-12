package com.veselov.alex.unittesting.service;

public class SomeBusinessLogic {
    private SomeDataService service;


    public int calculateSumUsingService() {
        int sum = 0;
        int[] ar = this.service.retrieveData();
        for (int cur :
                ar) {
            sum += cur;
        }
        return sum;
    }

    public void setService(SomeDataService service) {
        this.service = service;
    }
}
