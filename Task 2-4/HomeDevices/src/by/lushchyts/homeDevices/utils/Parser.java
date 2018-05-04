package by.lushchyts.homeDevices.utils;

import java.util.ArrayList;

import by.lushchyts.homeDevices.deviceManager.DeviceManager;
import by.lushchyts.homeDevices.utils.StringToBoolean;


public class Parser {

    DeviceManager manager;
    StringToBoolean convert = new StringToBoolean();

    public Parser(DeviceManager manager) {
        this.manager = manager;
    }

    void ParseDevice(String rawDeviceInfo, int deviceType) {
        String name;
        int consumingPower;
        String[] deviceParameters = new String[4];

        deviceParameters = rawDeviceInfo.split(" \\| ", 4);


        switch (deviceType) {
            case 1:
                manager.importRefregerator(deviceParameters[0], Integer.valueOf(deviceParameters[1]), convert.convertToBoolean(deviceParameters[2]), convert.convertToBoolean(deviceParameters[3]));
                break;
            case 2:
                manager.importTVset(deviceParameters[0], Integer.valueOf(deviceParameters[1]), convert.convertToBoolean(deviceParameters[2]), convert.convertToBoolean(deviceParameters[3]));
                break;
            case 3:
                manager.importAirConditioner(deviceParameters[0], Integer.valueOf(deviceParameters[1]), convert.convertToBoolean(deviceParameters[2]), convert.convertToBoolean(deviceParameters[3]));
                break;
            case 4:
                manager.importSmallKitchenDevice(deviceParameters[0], Integer.valueOf(deviceParameters[1]), convert.convertToBoolean(deviceParameters[2]), convert.convertToBoolean(deviceParameters[3]));
                break;
            case 5:
                manager.importOtherSmallDevice(deviceParameters[0], Integer.valueOf(deviceParameters[1]), convert.convertToBoolean(deviceParameters[2]), convert.convertToBoolean(deviceParameters[3]));
                break;
            default:
                break;
        }


    }


}
