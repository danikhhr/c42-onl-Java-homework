package smartHome.Devices;

import smartHome.InterfacesAndAbstractClasses.AbstractDevices;

public class SmartCamera extends AbstractDevices  {

    private boolean wifiIsOn;
    private final String PASSWORD = "1111";
    private final String ANOTHER_PASSWORD = "1981412";
    private final String wifiName;
    private boolean isRecord;

    public SmartCamera(String name, boolean isOn, String serialNumber, String wifiName) {
        super(name, isOn, serialNumber);
        wifiIsOn = false;
        this.wifiName = wifiName;
        isRecord = true;
    }


    @Override
    public void connectToAnotherWIFI(String password) {
        if (password.equals(ANOTHER_PASSWORD)) {
            System.out.println("Вы успешно подключились к другой сети wifi");
            wifiIsOn = true;
        } else {
            System.out.println("Вы ввели неверный пароль, повторите попытку");
            wifiIsOn = false;
        }
    }

    @Override
    public void OnRecording() {
        isRecord = true;
    }

    @Override
    public void OffRecording() {
        isRecord = false;
    }

    @Override
    public String getStatus() {
        return String.format("устройство %s, wifi %s, запись идет %b\n",
                isOn? "включено": "выключено", wifiIsOn? "включен" : "выключен", isRecord) ;
    }


    @Override
    public void connectToWiFi(String password) {
        if(wifiIsOn) {
            System.out.println("Вы уже подключены к этой сети");
        } else if(PASSWORD.equals(password)) {
            wifiIsOn = true;
            System.out.println("Вы успешно подключились");
        } else System.out.println("Вы ввели неверный пароль");
    }


    @Override
    public String toString() {
        return String.format("имя устройства: %s (%s)", name, serialNumber);
    }
}
