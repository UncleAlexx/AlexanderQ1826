package lesson6;

public abstract class HomeDevice implements Controllable, Switchable {
    public final String name;
    public final String manufacturer;
    public final int year;

    private boolean isOn;
    private int  requiredPower;
    private final String className = getClass().getName();

    public boolean getOn() {
        return isOn;
    }

    protected void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    public int getRequiredPower() {
        return requiredPower;
    }

    public HomeDevice(String name, String manufacturer, int year, int requiredPower){
        setPower(requiredPower);
        this.isOn = isOn();
        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    protected void setValidState(boolean isOn, boolean wasOn){
        if(!wasOn && isOn()){
            turnOn();
        }
        if(wasOn && !isOn())
        {
            turnOff();
        }
    }
    protected void turnStateBase(boolean state) {
        this.isOn = state;
    }

    public abstract String getDeviceInfo();

    @Override
    public WorkingStatus getStatus() {
        return isOn()? WorkingStatus.Working : WorkingStatus.NotWorking;
    }
    @Override
    public void setPower(int power) {
        requiredPower  = HomeDeviceExtensions.isBetween(power, 0,225)? requiredPower : 100;
        if(power < requiredPower)
            turnOff();
        else {
            if(!isOn())
                turnOn();
        }
    }

    @Override
    public int getPower() {
        return requiredPower;
    }

    @Override
    public String toString() {
        return  className +"{\nname=" + name + '\''+
                ", isOn=" + isOn +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }
}
