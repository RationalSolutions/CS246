package example;

public class WeatherSummary {
    private String city;
    private Float maxTemp;
    private Float maxWind;

    public Float getMaxTemp() {
        return maxTemp;
    }

    public Float getMaxWind() {
        return maxWind;
    }

    /**
     * Load the summary object from a provided Forecast object, by
     * finding the max temperature and wind speed occurring in the forecast.
     */
    public static WeatherSummary loadFromForecast(String city, WeatherForecast forecast) {
        WeatherSummary summary = new WeatherSummary();

        summary.city = city;

        summary.maxTemp = Float.MIN_VALUE;
        summary.maxWind = Float.MIN_VALUE;

        // Go through each item in the forecast and find the max temp and max wind speed
        for (WeatherForecastItem item : forecast.getForecastItems()) {
            if (item.getMeasurements().containsKey("temp") &&
                    item.getMeasurements().get("temp") > summary.maxTemp) {
                // we have the new maxTemp!
                summary.maxTemp = item.getMeasurements().get("temp");
            }

            if (item.getWind().containsKey("speed") &&
                    item.getWind().get("speed") > summary.maxWind) {
                // we have the new max wind speed!
                summary.maxWind = item.getWind().get("speed");
            }
        }

        return summary;
    }

    @Override
    public String toString() {
        return String.format("City: %s, Max Temperature: %.2f, Max Wind Speed: %.2f", city, maxTemp, maxWind);
    }
}
