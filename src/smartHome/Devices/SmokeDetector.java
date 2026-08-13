package smartHome.Devices;

import smartHome.InterfacesAndAbstractClasses.AbstractSensors;

public class SmokeDetector extends AbstractSensors  {

    public SmokeDetector(boolean isOn, boolean alarmActive, String location, int batteryLevel) {
        super(isOn, alarmActive, location, batteryLevel);
    }

    @Override
    public String getDiagnosticSenor() {
        if (isBatteryLow())
            return String.format("ВНИМАНИЕ! Низкий заряд батареи датчика (%s): %d%%. Требуется замена.\n",
                    location, batteryLevel);
        else return String.format("Датчик дыма, уровень батареи %d%%, локация %s\n", batteryLevel, location);

    }

    @Override
    public String toString() {
        return String.format("Датчик дыма, уровень батареи %d%%, локация %s", batteryLevel, location);
    }

}
