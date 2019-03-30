package com.haidong.saveJamasBond;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Spot> spots = new ArrayList<>();

    public static void main(String[] args) {
        Application application = new Application();
        spots = application.loadTestSpots();
        Lake lake = new Lake(spots);
        lake.printSpots();

        String result = lake.findRoute();
        System.out.printf("The Result is %s", result);
    }

    private List<Spot> loadTestSpots() {
        return new ArrayList<Spot>() {{
            add(new Spot(1, 2));
            add(new Spot(3, 6));
            add(new Spot(-2, 3));
            add(new Spot(-1, 2));
        }};
    }
}
