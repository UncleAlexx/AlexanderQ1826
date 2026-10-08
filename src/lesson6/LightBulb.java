package lesson6;

public class LightBulb extends HomeDevice implements EnergyEfficient{
    public Color color;
    private int brightness;
    private int lastBrightness;
    private Color lastColor;
    public int getBrightness() {
        return brightness;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        boolean wasOn = isOn();
        if(wasOn)
            lastBrightness = brightness;
        this.color = color;
        setValidState(isOn(), wasOn);
    }

    public void setBrightness(int brightness) {
        boolean wasOn = isOn();
        if(wasOn)
            lastBrightness = brightness;
        this.brightness = HomeDeviceExtensions.isBetween(brightness,0,100)? brightness : 0;
        setValidState(isOn(), wasOn);
    }

    public LightBulb (String name, String manufacturer, int year, int requiredPower, int brightness, Color color){
        super(name, manufacturer, year, requiredPower);
        setBrightness(brightness);
        this.color = color;
    }

    @Override
    public double calculateEnergyConsumption() {
        return brightness * 0.1d;
    }

    @Override
    public EnergyClass getEnergyClass() {
        return brightness < 50? EnergyClass.A : EnergyClass.B;
    }

    @Override
    public String getDeviceInfo() {
        return  this +
        "brightness=" + brightness +
                ", color=" + color + "\n}";
    }

    @Override
    public void turnOn() {
        turnStateBase(true);
        if(!isOn())
        {
            brightness = lastBrightness;
            color = Color.colorful;
        }
    }

    @Override
    public void turnOff() {
        turnStateBase(false);
        if(isOn())
        {
            lastBrightness = brightness;
            brightness = 0;
            color = Color.gray;
        }
    }

    @Override
    public boolean isOn() {
        setOn(brightness > 0 && color == Color.colorful);
        return getOn();
    }
}
