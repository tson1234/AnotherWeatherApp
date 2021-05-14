package T1902E.anotherweatherapp.network;

import java.util.List;

import T1902E.anotherweatherapp.model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    public static String BASE_URL = "http://dataservice.accuweather.com/";

    @GET("/forecasts/v1/hourly/12hour/425639?apikey=353412&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();

    @GET("/forecasts/v1/daily/5day/353412?apikey=oHxjrezmWVb7EFb80Ad6kxxQ3Lv4Sl2r&language=vi-vn&metric=true")
    Call<List<Weather>> getDay();
}
