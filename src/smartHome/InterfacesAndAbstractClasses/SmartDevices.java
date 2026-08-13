package smartHome.InterfacesAndAbstractClasses;

public interface SmartDevices {
    public void ON();
    public void OFF();
    public boolean isOn();
    public String getName();
    public String getSerialNumber();
    public String getStatus();
}
