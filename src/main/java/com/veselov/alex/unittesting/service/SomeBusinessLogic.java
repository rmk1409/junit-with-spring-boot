package com.veselov.alex.unittesting.service;

public class SomeBusinessLogic {
    private SomeDataService service;

    public int calculateSum(int[] ar) {
        int sum = 0;
        for (int cur :
                ar) {
            sum += cur;
        }
        return sum;
    }

    public int calculateSumUsingService() {
        int sum = 0;
        int[] ar = service.retrieveData();
        for (int cur :
                ar) {
            sum += cur;
        }
        return sum;
    }
}
