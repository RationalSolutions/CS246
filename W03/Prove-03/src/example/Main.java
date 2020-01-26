package example;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Single City Experiments:");
        new SingleCityExperimenter().singleCityForecast();

        System.out.println("\n\nMultiple City Experiments:");
        new MultipleCityExperimenter().compareCityList();
    }

}