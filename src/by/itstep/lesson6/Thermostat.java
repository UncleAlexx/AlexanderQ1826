package by.itstep.lesson6;

public class Thermostat extends HomeDevice implements Switchable, Controllable{
    private double temperature;
    private double targetTemperature;
    private  double power;
    private  double lastTemperature;
    private  double lastTargetTemperature;

    public double getTargetTemperature() {
        return targetTemperature;
    }



    public Thermostat (String name, String manufacturer, int year){
        super(name, manufacturer, year, 200);
    }

    public void setTargetTemperature(double targetTemperature) {
        boolean wasOn = isOn();
        if(wasOn)
        {
            lastTargetTemperature = targetTemperature;
            lastTemperature = temperature;
        }
        this.targetTemperature = HomeDeviceExtensions.isBetween(targetTemperature,0,100)? targetTemperature : 0;
        setValidState(isOn(), wasOn);

    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        boolean wasOn = isOn();
        if(wasOn)
        {
            lastTargetTemperature = targetTemperature;
            lastTemperature = temperature;
        }
        this.temperature =  HomeDeviceExtensions.isBetween(temperature,0,100)? temperature : 0;
        setValidState(isOn(), wasOn);
    }

    @Override
    public String getDeviceInfo() {
        return this +
                "temperature=" + temperature +
                ", targetTemperature=" + targetTemperature +
                '}';
    }

    @Override
    public void setPower(int power) {
        this.power = HomeDeviceExtensions.isBetween(power, 0, 100)? power : this.power;
    }

    @Override
    public int getPower() {
        return (int)(targetTemperature - temperature);
    }


    @Override
    public void turnOn() {
        turnStateBase(true);
        if(!isOn())
        {
            temperature = lastTemperature;
            targetTemperature = lastTargetTemperature;
        }

    }

    @Override
    public void turnOff() {
        turnStateBase(false);
        if(isOn()){
            lastTargetTemperature = targetTemperature;
            lastTemperature = temperature;
            temperature = 0;
            targetTemperature = 0;
        }
    }

    @Override
    public boolean isOn() {
        return this.targetTemperature >= 80 && this.temperature >= 0;
    }
}
