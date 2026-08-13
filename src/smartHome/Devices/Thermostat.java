package smartHome.Devices;


import smartHome.InterfacesAndAbstractClasses.AbstractDevices;

public class Thermostat extends AbstractDevices {
    private boolean isOnWIFI;
    private final String PASSWORD = "Thermostat67425";
    private String wifiName;
    private int currentTemperature;

    public Thermostat(String name, boolean isOn, String serialNumber, int currentTemperature,  String wifiName) {
        super(name, isOn, serialNumber);
        this.wifiName = wifiName;
        this.currentTemperature = currentTemperature;
        isOnWIFI = false;
    }

    @Override
    public void connectToWiFi(String password) {
        if(isOnWIFI) {
            System.out.println("Вы уже подключены к этой сети");
        } else if(PASSWORD.equals(password)) {
            isOnWIFI = true;
            System.out.println("Вы успешно подключились");
        } else System.out.println("Вы ввели неверный пароль");
    }


    @Override
    public String getStatus() {
        return String.format("Термостат текущая температура %d градусов, имя wifi сети %s\n",
                currentTemperature, wifiName) ;
    }

    @Override
    public String toString() {
        return String.format("Термостат текущая температура %d градусов, имя wifi сети %s",
                currentTemperature, wifiName) ;
    }
}
