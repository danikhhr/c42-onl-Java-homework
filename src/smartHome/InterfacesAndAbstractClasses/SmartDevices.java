package smartHome.InterfacesAndAbstractClasses;

public interface SmartDevicesAndSensors {
    public void ON();
    public void OFF();
    public boolean getStatus();
    public String getDeviceType();
    public default String getSerialNumber() {
        System.out.println("Серийный номер у этого датчика отсутствует");
        return "";
    }
    public default String getLocation() {
        System.out.println("Доступ к локации у этого датчика отсутствует");
        return "";
    }
}
