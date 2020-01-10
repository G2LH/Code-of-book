package Observer;
import java.util.Observable;
import java.util.Observer;
//内置的观察者模式
public class JCurrentConditionsDislay implements Observer, DisplayElement{
    Observable observable;
    private float temprature;
    private float humidity;
    public JCurrentConditionsDislay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    public void update(Observable obs, Object arg){
        if(obs instanceof JWeatherData){
            JWeatherData jweatherData = (JWeatherData) obs;
            this.temprature = jweatherData.getTemperature();
            this.humidity = jweatherData.getHumidity();
            display();
        }
    }
    public void display(){
        System.out.println("Current conditions: " + temprature + " F degrees and " + humidity + "% humidity");
    }

}
