package Observer;

public class CurrentConditionsDislay implements Observer, DisplayElement{ //实现Observer 和 DisplayElement接口
    private float temperature;
    private float humidity;
    private Subject weatherData;
    public CurrentConditionsDislay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    public void display(){
        System.out.println("Current conditions: " + temperature + " F degrees and " + humidity + "% humidity");
    }
}
