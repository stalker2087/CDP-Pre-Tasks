package by.lushchyts.homeDevices.deviceManager;

import by.lushchyts.homeDevices.devices.*;
import by.lushchyts.homeDevices.utils.sortDevicesByPowerConsumption;

import java.util.ArrayList;
import java.util.List;

import by.lushchyts.homeDevices.exception.NoResultsFoundException;

public class DeviceManager {

    private List<Refregerator> refregerators = new ArrayList<>();
    private List<TVset> tvsets = new ArrayList<>();
    private List<AirConditioner> conditioners = new ArrayList<>();
    private List<SmallKitchenDevices> kitchenDevices = new ArrayList<>();
    private List<OtherSmallDevices> otherSmallDevices = new ArrayList<>();
    private List<ElectronicDevice> devices = new ArrayList<>();

    public void getAllDevices() {

        if (refregerators.size() > 0) {

            for (Refregerator refregerator : refregerators) {
                devices.add(refregerator);
            }
        }

        if (tvsets.size() > 0) {

            for (TVset tv : tvsets) {
                devices.add(tv);
            }
        }

        if (conditioners.size() > 0) {

            for (AirConditioner conditioner : conditioners) {
                devices.add(conditioner);
            }

        }

        if (kitchenDevices.size() > 0) {

            for (SmallKitchenDevices kitchenDevice : kitchenDevices) {
                devices.add(kitchenDevice);
            }
        }

        if (otherSmallDevices.size() > 0) {

            for (OtherSmallDevices device : otherSmallDevices) {
                devices.add(device);

            }
        }

    }

    public void sortDevicesByPower() {
        getAllDevices();
        devices.sort(new sortDevicesByPowerConsumption());
        printAllDevices(devices);
    }

    public void printAllDevices(List<ElectronicDevice> devicesList) {
        if (devicesList.size() == 0) {
            System.out.println("");
            System.out.println("There are no deivces");
        } else

        {
            int i = 1;
            System.out.println("");

            for (ElectronicDevice device : devicesList) {
                System.out.println(i + ". " + device.getDeviceName() + "(Power Supply: " + device.getDevicePowerSupplyState() + ", " + "State: " + device.getDeviceOnOffState() + ", power: " + device.getConsumingPower() + ")");
                i++;
            }

            System.out.println("");
        }
    }

    public void findDeviceByName(String name) throws NoResultsFoundException {

        getAllDevices();

        ArrayList<ElectronicDevice> suitableDevices = new ArrayList<ElectronicDevice>();

        for (ElectronicDevice device : devices) {
            if (device.getDeviceName().contains(name)) {
                suitableDevices.add(device);
            }
        }

        if (suitableDevices.size() == 0) {
            throw new NoResultsFoundException("There are no devices with name \"" + name + "\"");

        } else {
            printAllDevices(suitableDevices);
        }
    }

    public void findDeviceByPower(int minpower, int maxPower) throws NoResultsFoundException{

        getAllDevices();

        ArrayList<ElectronicDevice> suitableDevices = new ArrayList<ElectronicDevice>();

        for (ElectronicDevice device : devices) {
            if (device.getConsumingPower() <= maxPower && device.getConsumingPower() >= minpower) {
                suitableDevices.add(device);
            }
        }

        if (suitableDevices.size() == 0) {
            throw new NoResultsFoundException("There are no devices with consuming power betwen " + String.valueOf(minpower) + " and " + String.valueOf(maxPower) + " W");
        } else {
            printAllDevices(suitableDevices);
        }

    }

    public void displayAllDevices() {
        getAllDevices();
        printAllDevices(devices);
    }


    public void addRefregerator(String deviceName, int consumingPower) {
        refregerators.add(new Refregerator(deviceName, consumingPower));
        System.out.println("Refregerator successfully added");
        System.out.println("");
    }

    public void addTVset(String deviceName, int consumingPower) {
        tvsets.add(new TVset(deviceName, consumingPower));
        System.out.println("TVset successfully added");
        System.out.println("");
    }

    public void addAirConditioner(String deviceName, int consumingPower) {
        conditioners.add(new AirConditioner(deviceName, consumingPower));
        System.out.println("Air Conditioner successfully added");
        System.out.println("");
    }

    public void addSmallKitchenDevice(String deviceName, int consumingPower) {
        kitchenDevices.add(new SmallKitchenDevices(deviceName, consumingPower));
        System.out.println("Kitchen device successfully added");
        System.out.println("");
    }

    public void addOtherSmallDevice(String deviceName, int consumingPower) {
        otherSmallDevices.add(new OtherSmallDevices(deviceName, consumingPower));
        System.out.println("Device successfully added");
        System.out.println("");
    }

    public boolean validateParameters(boolean socketStatus,boolean onOff){
        if(socketStatus==false && onOff==true){
            return false;
        }
        return onOff;
    }

    public void importRefregerator(String deviceName, int consumingPower, boolean socketStatus, boolean onOff) {
        onOff = validateParameters(socketStatus, onOff);
        refregerators.add(new Refregerator(deviceName, consumingPower, socketStatus, onOff));
        System.out.println(deviceName + " successfully added");
        System.out.println("");
    }

    public void importTVset(String deviceName, int consumingPower, boolean socketStatus, boolean onOff) {
        onOff = validateParameters(socketStatus, onOff);
        tvsets.add(new TVset(deviceName, consumingPower, socketStatus, onOff));
        System.out.println(deviceName + " successfully added");
        System.out.println("");
    }

    public void importAirConditioner(String deviceName, int consumingPower, boolean socketStatus, boolean onOff) {
        onOff = validateParameters(socketStatus, onOff);
        conditioners.add(new AirConditioner(deviceName, consumingPower, socketStatus, onOff));
        System.out.println(deviceName + " successfully added");
        System.out.println("");
    }

    public void importSmallKitchenDevice(String deviceName, int consumingPower, boolean socketStatus, boolean onOff) {
        onOff = validateParameters(socketStatus, onOff);
        kitchenDevices.add(new SmallKitchenDevices(deviceName, consumingPower, socketStatus, onOff));
        System.out.println(deviceName + " successfully added");
        System.out.println("");
    }

    public void importOtherSmallDevice(String deviceName, int consumingPower, boolean socketStatus, boolean onOff) {
        onOff = validateParameters(socketStatus, onOff);
        otherSmallDevices.add(new OtherSmallDevices(deviceName, consumingPower, socketStatus, onOff));
        System.out.println(deviceName + " successfully added");
        System.out.println("");
    }

    public void powerOnOffRefregerator(int deviceId) {
        if (refregerators.get(deviceId).getDevicePowerSupplyState() == "Off") {
            refregerators.get(deviceId).powerOn();
        } else {
            refregerators.get(deviceId).powerOff();
        }
    }

    public void powerOnOffTVset(int deviceId) {
        if (tvsets.get(deviceId).getDevicePowerSupplyState() == "Off") {
            tvsets.get(deviceId).powerOn();
        } else {
            tvsets.get(deviceId).powerOff();
        }
    }

    public void powerOnOffAirConditioner(int deviceId) {
        if (conditioners.get(deviceId).getDevicePowerSupplyState() == "Off") {
            conditioners.get(deviceId).powerOn();
        } else {
            conditioners.get(deviceId).powerOff();
        }
    }

    public void powerOnOffKitchenDevice(int deviceId) {
        if (kitchenDevices.get(deviceId).getDevicePowerSupplyState() == "Off") {
            kitchenDevices.get(deviceId).powerOn();
        } else {
            kitchenDevices.get(deviceId).powerOff();
        }
    }

    public void powerOnOffOtherDevice(int deviceId) {
        if (otherSmallDevices.get(deviceId).getDevicePowerSupplyState() == "Off") {
            otherSmallDevices.get(deviceId).powerOn();
        } else {
            otherSmallDevices.get(deviceId).powerOff();
        }
    }

    public void onOffRefregerator(int deviceId) {
        if (refregerators.get(deviceId).getDeviceOnOffState() == "Off") {
            refregerators.get(deviceId).turnOnDevice();
        } else {
            refregerators.get(deviceId).turnOffDevice();
        }
    }

    public void onOffTVset(int deviceId) {
        if (tvsets.get(deviceId).getDeviceOnOffState() == "Off") {
            tvsets.get(deviceId).turnOnDevice();
        } else {
            tvsets.get(deviceId).turnOffDevice();
        }
    }

    public void onOffAirConditioner(int deviceId) {
        if (conditioners.get(deviceId).getDeviceOnOffState() == "Off") {
            conditioners.get(deviceId).turnOnDevice();
        } else {
            conditioners.get(deviceId).turnOffDevice();
        }
    }

    public void onOffKitchenDevice(int deviceId) {
        if (kitchenDevices.get(deviceId).getDeviceOnOffState() == "Off") {
            kitchenDevices.get(deviceId).turnOnDevice();
        } else {
            kitchenDevices.get(deviceId).turnOffDevice();
        }
    }

    public void onOffOtherDevice(int deviceId) {
        if (otherSmallDevices.get(deviceId).getDeviceOnOffState() == "Off") {
            otherSmallDevices.get(deviceId).turnOnDevice();
        } else {
            otherSmallDevices.get(deviceId).turnOffDevice();
        }
    }


    public int countCurrenntRefregeratorsConsumption() {
        int consumption = 0;
        for (Refregerator refregerator : refregerators) {
            consumption += refregerator.getCurrentConsumption();
        }

        return consumption;
    }

    public int countCurrenntTVsetsConsumption() {
        int consumption = 0;
        for (TVset tv : tvsets) {
            consumption += tv.getCurrentConsumption();
        }

        return consumption;
    }

    public int countCurrenntAitConditionerConsumption() {
        int consumption = 0;
        for (AirConditioner conditioner : conditioners) {
            consumption += conditioner.getCurrentConsumption();
        }

        return consumption;
    }

    public int countCurrenntKitchenDevicesConsumption() {
        int consumption = 0;
        for (SmallKitchenDevices kitchenDevice : kitchenDevices) {
            consumption += kitchenDevice.getCurrentConsumption();
        }

        return consumption;
    }

    public int countCurrenntOtherDevicesConsumption() {
        int consumption = 0;
        for (OtherSmallDevices device : otherSmallDevices) {
            consumption += device.getCurrentConsumption();
        }

        return consumption;
    }

    public void getTotalCurrentConsumption() {
        System.out.println("");
        System.out.format("Current total power consumption: %d W",
                countCurrenntRefregeratorsConsumption() + countCurrenntTVsetsConsumption() + countCurrenntAitConditionerConsumption() + countCurrenntKitchenDevicesConsumption() + countCurrenntOtherDevicesConsumption());
        System.out.println("");
        System.out.println("");
    }


    public ArrayList<String> getListOfRefregerators() {

        ArrayList<String> devices = new ArrayList<String>();

        if (refregerators.size() > 0) {

            for (Refregerator refregerator : refregerators) {
                devices.add(refregerator.getDeviceName() + " (Power Supply: " + refregerator.getDevicePowerSupplyState() + ", " + "State: " + refregerator.getDeviceOnOffState() + ")");
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfTVsets() {

        ArrayList<String> devices = new ArrayList<String>();

        if (tvsets.size() > 0) {

            for (TVset tv : tvsets) {
                devices.add(tv.getDeviceName() + " (Power Supply: " + tv.getDevicePowerSupplyState() + ", " + "State: " + tv.getDeviceOnOffState() + ")");
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfAirConditioners() {

        ArrayList<String> devices = new ArrayList<String>();

        if (conditioners.size() > 0) {

            for (AirConditioner conditioner : conditioners) {
                devices.add(conditioner.getDeviceName() + " (Power Supply: " + conditioner.getDevicePowerSupplyState() + ", " + "State: " + conditioner.getDeviceOnOffState() + ")");
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfKitchenDevices() {

        ArrayList<String> devices = new ArrayList<String>();

        if (kitchenDevices.size() > 0) {

            for (SmallKitchenDevices kitchenDevice : kitchenDevices) {
                devices.add(kitchenDevice.getDeviceName() + " (Power Supply: " + kitchenDevice.getDevicePowerSupplyState() + ", " + "State: " + kitchenDevice.getDeviceOnOffState() + ")");
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfOtherDevices() {

        ArrayList<String> devices = new ArrayList<String>();

        if (otherSmallDevices.size() > 0) {

            for (OtherSmallDevices device : otherSmallDevices) {
                devices.add(device.getDeviceName() + " (Power Supply: " + device.getDevicePowerSupplyState() + ", " + "State: " + device.getDeviceOnOffState() + ")");
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfRefregeratorsData() {

        ArrayList<String> devices = new ArrayList<String>();

        if (refregerators.size() > 0) {

            for (Refregerator refregerator : refregerators) {
                devices.add(refregerator.getDeviceName() + " | " + refregerator.getDeviceConsumption()+ " | " + refregerator.getDevicePowerSupplyState() + " | "  + refregerator.getDeviceOnOffState());
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfTVsetsData() {

        ArrayList<String> devices = new ArrayList<String>();

        if (tvsets.size() > 0) {

            for (TVset tv : tvsets) {
                devices.add(tv.getDeviceName() + " | " + tv.getDeviceConsumption() + " | " + tv.getDevicePowerSupplyState() + " | " + tv.getDeviceOnOffState() );
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfAirConditionersData() {

        ArrayList<String> devices = new ArrayList<String>();

        if (conditioners.size() > 0) {

            for (AirConditioner conditioner : conditioners) {
                devices.add(conditioner.getDeviceName() + " | " + conditioner.getConsumingPower()+ " | " + conditioner.getDevicePowerSupplyState() + " | " + conditioner.getDeviceOnOffState() );
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfKitchenDevicesData() {

        ArrayList<String> devices = new ArrayList<String>();

        if (kitchenDevices.size() > 0) {

            for (SmallKitchenDevices kitchenDevice : kitchenDevices) {
                devices.add(kitchenDevice.getDeviceName() + " | " + kitchenDevice.getConsumingPower() + " | " + kitchenDevice.getDevicePowerSupplyState() + " | "  + kitchenDevice.getDeviceOnOffState()  );
            }
        }

        return devices;
    }

    public ArrayList<String> getListOfOtherDevicesData() {

        ArrayList<String> devices = new ArrayList<String>();

        if (otherSmallDevices.size() > 0) {

            for (OtherSmallDevices device : otherSmallDevices) {
                devices.add(device.getDeviceName() + " | " + device.getConsumingPower()+ " | "  + device.getDevicePowerSupplyState() + " | " + device.getDeviceOnOffState());
            }
        }

        return devices;
    }

}
