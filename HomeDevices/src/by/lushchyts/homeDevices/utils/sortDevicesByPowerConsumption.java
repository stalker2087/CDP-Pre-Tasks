package by.lushchyts.homeDevices.utils;

import by.lushchyts.homeDevices.devices.ElectronicDevice;

import java.util.Comparator;

public class sortDevicesByPowerConsumption implements Comparator<ElectronicDevice> {

    @Override
    public int compare(ElectronicDevice deviceA, ElectronicDevice deviceB) {
        return deviceA.getConsumingPower() - deviceB.getConsumingPower();
    }
}
