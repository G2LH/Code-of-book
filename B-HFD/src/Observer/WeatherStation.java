package Observer;

public class WeatherStation {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDislay currentDisplay = new CurrentConditionsDislay(weatherData);
        //StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        //ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);

        //Java内置的观察者模式
        JWeatherData jweatherData = new JWeatherData();
        JCurrentConditionsDislay jcurrentDisplay = new JCurrentConditionsDislay(jweatherData);
        //StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        //ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        jweatherData.setMeasurements(80,65,30.4f);
        jweatherData.setMeasurements(82,70,29.2f);
        jweatherData.setMeasurements(78,90,29.2f);
    }
}
