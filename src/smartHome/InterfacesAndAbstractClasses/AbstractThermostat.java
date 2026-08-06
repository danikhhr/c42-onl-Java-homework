package smartHome.InterfacesAndAbstractClasses;

public abstract class Thermostat implements SmartDevicesAndSensors {
    public abstract void connectToWiFi(String ssid, String password);
    public abstract boolean isConnectedToWiFi();
    public abstract double getCurrentTemperature();
    public abstract void setCurrentTemperature(double temperature);
}
