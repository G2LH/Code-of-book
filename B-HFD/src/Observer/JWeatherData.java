package Observer;

import java.util.Observable;
import java.util.Observer;

//内置的观察者模式
public class JWeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public JWeatherData() { }
    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    public float getTemperature(){
        return temperature;
    }
    public float getHumidity(){
        return humidity;
    }
    public float getPressure(){
        return pressure;
    }
}