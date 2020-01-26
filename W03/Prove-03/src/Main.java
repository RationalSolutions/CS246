import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Please enter the city: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        WeatherConditionsAPIRequest weatherConditionsAPIRequest = new WeatherConditionsAPIRequest(userInput);
        weatherConditionsAPIRequest.sendRequest();

        System.out.println("Current Weather Conditions:");
        System.out.println("City id: " + weatherConditionsAPIRequest.weatherConditions.id);
        System.out.println("City name: " + weatherConditionsAPIRequest.weatherConditions.name);
        System.out.println("Current Temp: " + weatherConditionsAPIRequest.weatherConditions.measurements.get("temp") +" F");


        WeatherForecast weatherForecast = new WeatherForecast(userInput);
        weatherForecast.sendRequest();
        System.out.println("-------");
        System.out.println("5 day Forecast");
    }
}
