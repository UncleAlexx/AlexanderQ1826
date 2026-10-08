package by.itstep.lesson6;

import static java.lang.IO.println;

public class SmartHomeTest {

    static void main() {
        HomeDevice[] devices = {new Thermostat("name", "manu", 1998),
                new LightBulb("name", "manu", 1995,23,100, Color.colorful),
                new SmartTV(" name", "manu", 1993, 34,null, 33)};


        Controllable[] controllables = {new Thermostat("name", "manu", 1998),
                new LightBulb("name", "manu", 1995,23,100, Color.colorful),
                new SmartTV(" name", "manu", 1993, 34,null, 33)};
        Switchable[] switchables = {new Thermostat("name", "manu", 1998),
                new LightBulb("name", "manu", 1995,23,100, Color.colorful),
                new SmartTV(" name", "manu", 1993, 34,null, 33)};
        EnergyEfficient[] energyEfficients = {
                new LightBulb("name", "manu", 1995,23,100, Color.colorful),
                new SmartTV(" name", "manu", 1993, 34,null, 33)};

        for (Controllable controllable : controllables) {
            println(controllable.getStatus());
            println(controllable.getPower());
            println(controllable.getClass());
            controllable.setPower(3);
            println(controllable.getPower());
        }

        for (Switchable switchable : switchables) {
            println(switchable.isOn());
            switchable.turnOff();
            println(switchable.isOn());
            switchable.turnOn();
            println(switchable.isOn());
        }
        for (EnergyEfficient energyEfficient : energyEfficients){
            println(energyEfficient.calculateEnergyConsumption());
            println(energyEfficient.getEnergyClass());
        }


        for (HomeDevice device : devices) {
            if(device instanceof Switchable switchable){
                switchable.turnOn();
                println(switchable.isOn());
                switchable.turnOff();
                println(switchable.isOn());
            }
            if(device instanceof LightBulb bulb){
                bulb.setBrightness(3);
                println(bulb.getBrightness());
            }
            if(device instanceof SmartTV tv){
                tv.setVolume(33);
                println(tv.getVolume());
            }
            if(device instanceof  Thermostat thermostat){
                thermostat.setTemperature(33);
                println(thermostat.getTemperature());
            }
            if(device instanceof EnergyEfficient energyEfficient){
                println(energyEfficient.calculateEnergyConsumption());
            }
            if(device instanceof Controllable controllable)
                println(controllable.getStatus());
        }
    }
}
