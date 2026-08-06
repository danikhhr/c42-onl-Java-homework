package smartHome.InterfacesAndAbstractClasses;

public abstract class SmartCamera implements SmartDevicesAndSensors {
    public abstract void connectWifi();
    public abstract boolean isConnectWifi();
    public abstract void startRecording();
    public abstract void stopRecording();
    public abstract boolean isRecording();
    public abstract void setRecordingAutomatically(boolean enable);
}
