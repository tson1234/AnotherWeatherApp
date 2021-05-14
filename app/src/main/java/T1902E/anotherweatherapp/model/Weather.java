package T1902E.anotherweatherapp.model;

public class Weather {
    private String Datetime;
    private int WeatherIcon;
    private String IconPhrase;
    private Temperature Temperature;

    public String getDatetime() {
        return Datetime;
    }

    public void setDatetime(String datetime) {
        Datetime = datetime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public T1902E.anotherweatherapp.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(T1902E.anotherweatherapp.model.Temperature temperature) {
        Temperature = temperature;
    }
}
