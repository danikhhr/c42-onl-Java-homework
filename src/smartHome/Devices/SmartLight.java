package smartHome.Devices;

import smartHome.InterfacesAndAbstractClasses.AbstractDevices;

public class SmartLight extends AbstractDevices {

    private int brightness;

    public SmartLight(String name, boolean isOn, String serialNumber, int brightness) {
        super(name, isOn, serialNumber);
        this.brightness = brightness;
    }

    public void setBrightness(int brightness) {
        if(brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
            System.out.println("Яркость успешна изменена");
        } else System.out.println("Не удалось изменить яркость");

    }


    @Override
    public String getStatus() {
        return String.format("устройство %s, уровень яркости %d%%\n",
                isOn? "включено": "выключено", brightness) ;
    }


    @Override
    public String toString() {
        return String.format("имя устройства: %s (%s), уровень яркости %d%%", name, serialNumber, brightness);
    }
}
