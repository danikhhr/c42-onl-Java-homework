package smartHome.InterfacesAndAbstractClasses;

public abstract class AbstractSensors implements BatteryPower{
    protected boolean isOn;
    protected int batteryLevel;
    protected String location;
    protected boolean AlarmActive;

    public AbstractSensors(boolean isOn, boolean alarmActive, String location, int batteryLevel) {
        this.isOn = isOn;
        AlarmActive = alarmActive;
        this.location = location;
        this.batteryLevel = batteryLevel;
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    public String getDiagnosticSenor() {
        if(isBatteryLow()) return String.format("ВНИМАНИЕ: низкий заряд батареи (%s): %d%%", location, batteryLevel);
        else return String.format("Локация: (%s), заряд батареи: %d%%", location, batteryLevel);
    }

    public String getLocation() {
        return location;
    }


    @Override
    public boolean isBatteryLow() {
        return batteryLevel <= 20;
    }


}
