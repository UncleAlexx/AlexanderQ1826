package lesson6;

public class SmartTV extends HomeDevice implements EnergyEfficient {

    private int volume;
    private int lastVolume;
    private Channel currentChannel;
    private Channel lastChannel;


    public SmartTV (String name, String manufacturer, int year, int volume, Channel channel, int power){
        super(name, manufacturer, year, power);
        this.currentChannel = channel;
        this.volume = HomeDeviceExtensions.isBetween(volume,0,100)? volume : 0;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        boolean wasOn = isOn();
        this.volume = HomeDeviceExtensions.isBetween(volume,0,100)? volume : this.volume;
        setValidState(isOn(), wasOn);
    }

    public Channel getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(Channel currentChannel) {
        boolean wasOn = isOn();
        if(wasOn)
        {
            lastChannel = currentChannel;
            lastVolume = volume;
        }
        this.currentChannel = currentChannel;
        setValidState(isOn(), wasOn);
    }


    @Override
    public double calculateEnergyConsumption() {
        return Math.max(volume * 0.5 + 10, getPower());
    }

    @Override
    public EnergyClass getEnergyClass() {
        return volume <= 30? EnergyClass.A : volume > 70? EnergyClass.C : EnergyClass.B;
    }

    @Override
    public String getDeviceInfo() {
        return  this +
                "currentChannel=" + currentChannel +
                ", volume=" + volume +
                '}';
    }

    @Override
    public void turnOn() {
        turnStateBase(true);
        if(!isOn()) {
            volume = lastVolume;
            currentChannel = lastChannel ;
        }
    }

    @Override
    public void turnOff() {
        turnStateBase(false);
        if(isOn())
        {
            lastVolume = volume;
            volume = 0;
            lastChannel = currentChannel;
            currentChannel = null;
        }
    }

    @Override
    public boolean isOn() {
        return currentChannel != null && volume >= 0;
    }
}
