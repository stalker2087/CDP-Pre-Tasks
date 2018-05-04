package by.lushchyts.homeDevices.devices;

import by.lushchyts.homeDevices.exception.PowerSupplyException;

public abstract class ElectronicDevice {

    private boolean switchToSocketStatus;
    private boolean onOffStatus;
    private String deviceName;
    private int consumingPower;

    public ElectronicDevice(String deviceName, int consumingPower) {
        switchToSocketStatus = false;
        onOffStatus = false;
        this.deviceName = deviceName;
        this.consumingPower = consumingPower;
    }

    public ElectronicDevice(String deviceName, int consumingPower, boolean socketStatus, boolean onOffStatus) {
        switchToSocketStatus = socketStatus;
        this.onOffStatus = onOffStatus;
        this.deviceName = deviceName;
        this.consumingPower = consumingPower;
    }

    public String powerOnDevice() throws PowerSupplyException{

        if (switchToSocketStatus == false) {
            switchToSocketStatus = true;
            return deviceName + " is powered on";
        } else {
            throw new PowerSupplyException(deviceName + " is already powered on" );
        }
    }

    public String powerOffDevice() throws PowerSupplyException{

        if (switchToSocketStatus == true) {
            switchToSocketStatus = false;
            return deviceName + " is powered off";
        } else {
            throw new PowerSupplyException(deviceName + " is already powered off");
        }
    }

    public String onDevice() throws PowerSupplyException{

        if (switchToSocketStatus == false) {
            throw new PowerSupplyException(deviceName + " is not powered on");
        } else {

            if (onOffStatus == false) {
                onOffStatus = true;
                return deviceName + " is on";
            } else {
                throw new PowerSupplyException(deviceName + " is already on");
            }
        }
    }

    public String offDevice() throws PowerSupplyException{

        if (onOffStatus == true) {
            onOffStatus = false;
            return deviceName + " is off";
        } else {
            throw new PowerSupplyException(deviceName + " is already off");
        }
    }

    public String getDeviceOnOffState() {
        if (onOffStatus == false) {
            return "Off";
        } else {
            return "On";
        }
    }

    public String getDevicePowerSupplyState() {
        if (switchToSocketStatus == true) {
            return "On";
        } else {
            return "Off";
        }
    }

    public String getDeviceName(){
        return deviceName;
    }

    public int getConsumingPower(){
        return consumingPower;
    }

    public abstract String getDeviceInfo();

    public abstract int getCurrentConsumption();

}
