package smartHome.InterfacesAndAbstractClasses;

public abstract class SmokeDetector implements SmartDevicesAndSensors {
    public abstract String getLocation();
    public abstract void setLocation();
    public abstract int getChargeLevel();
    public abstract void setChargeLevel();
    public abstract boolean detectSmoke();
    public abstract void triggerAlarm();
    public abstract void stopAlarm();

}
