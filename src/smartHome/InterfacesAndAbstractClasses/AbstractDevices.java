package smartHome.InterfacesAndAbstractClasses;

public abstract class AbstractDevices implements SmartDevices, Wifi{
    protected String name;
    protected String serialNumber;
    protected boolean isOn;

    public AbstractDevices(String name, boolean isOn, String serialNumber) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.isOn = isOn;
    }


    @Override
    public void connectToAnotherWIFI(String password) {

    }

    @Override
    public void connectToWiFi(String password) {

    }

    public void OnRecording() {
    }

    public void OffRecording() {
    }

    @Override
    public void ON() {
        isOn = true;
    }

    @Override
    public void OFF() {
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String getStatus() {
        return "";
    }

}
