package smartHome.InterfacesAndAbstractClasses;

public abstract class SmartLight implements SmartDevicesAndSensors {
    public abstract void setLight();
    public abstract void setBrightness(int level);
    public abstract int getBrightness();
    public abstract void increaseBrightness();
    public abstract void decreaseBrightness();
}
