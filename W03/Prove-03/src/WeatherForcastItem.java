import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class WeatherForcastItem {
    int id;
    String name;
    @SerializedName("main")
    HashMap<String, Float> measurements;
    String time;
    float temp;
    @SerializedName("weather")
    HashMap<String, String> conditions;
    @SerializedName("wind")
    HashMap<String, Float> wind;
}
