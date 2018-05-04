package by.lushchyts.homeDevices.devices;

import by.lushchyts.homeDevices.exception.PowerSupplyException;

public class AirConditioner extends ElectronicDevice {

    public AirConditioner(String deviceName, int consumingPower) {

        super(deviceName,consumingPower);

    }

    public AirConditioner(String deviceName, int consumingPower, boolean socketStatus, boolean onOff) {

        super(deviceName,consumingPower, socketStatus, onOff);

    }

    public void powerOn() {

        try {
            System.out.println(super.powerOnDevice());
        }catch (PowerSupplyException e){
            System.out.println(e.getMessage());
        }
        System.out.println("");
    }

    public void powerOff() {

        try {
            System.out.println(super.powerOffDevice());
        }catch(PowerSupplyException e){
            System.out.println(e.getMessage());
        }
        System.out.println("");

    }

    public void turnOnDevice() {

        try {
            System.out.println(super.onDevice());
        }catch(PowerSupplyException e){
            System.out.println(e.getMessage());
        }
        System.out.println("");
    }

    public void turnOffDevice() {

        try {
            System.out.println(super.offDevice());
        }catch (PowerSupplyException e){
            System.out.println(e.getMessage());
        }
        System.out.println("");
    }

    public String getDeviceName() {
        return super.getDeviceName();
    }

    public String getDeviceOnOffState() {
        return super.getDeviceOnOffState();
    }

    public String getDevicePowerSupplyState() {
        return super.getDevicePowerSupplyState();
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceName() + ": " + "/n" + "Power consumption: " + super.getConsumingPower()+ "/n" + "Current state: " + super.getDeviceOnOffState();
    }

    @Override
    public int getCurrentConsumption() {
        if (super.getDeviceOnOffState() == "On") {
            return super.getConsumingPower();
        } else {
            return 0;
        }
    }

}
