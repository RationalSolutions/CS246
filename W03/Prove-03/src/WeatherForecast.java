import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class WeatherForecast {
    final static String APIKEY = "REPLACE WITH YOUR API KEY";
    final static String WEATHER_FORECAST_API_URL = "https://api.openweathermap.org/data/2.5/forecast";

    String city;
    String data;
    URL url;
    WeatherForcastItem weatherForcastItem;

    public WeatherForecast(String city) throws MalformedURLException {
        this.city = city;
        this.url = new URL(WEATHER_FORECAST_API_URL);
        this.weatherForcastItem = new WeatherForcastItem();
    }

    public String getCity() {
        return city;
    }

    public URL getUrl() {
        return url;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void sendRequest() throws IOException {
        String charset = "UTF-8";
        String units = "imperial";
        String query = String.format("q=%s&units=%s&APIKEY=%s", URLEncoder.encode(getCity(), charset),
                URLEncoder.encode(units, charset), URLEncoder.encode(APIKEY, charset));

        URLConnection connection = new URL(getUrl() + "?" + query).openConnection();
        connection.setRequestProperty("Accept-charset", charset);
        InputStream response = connection.getInputStream();

        try(Scanner scanner = new Scanner(response)){
            setData(scanner.useDelimiter("//A").next());
        }

        deserialize();
    }

    private void deserialize(){
        Gson gson = new Gson();
        weatherForcastItem = gson.fromJson(data, WeatherForcastItem.class);
    }
}
