package by.lushchyts.homeDevices.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

import by.lushchyts.homeDevices.utils.Parser;

import java.io.IOException;

import by.lushchyts.homeDevices.deviceManager.DeviceManager;

public class Reader {
    private FileReader reader;
    private FileWriter writer;
    private Scanner file;
    private Parser parser;
    private DeviceManager manager;

    public Reader(DeviceManager manager) {
        this.manager = manager;
    }

    public void readFile(String filePath, int deviceType) throws FileNotFoundException {
        int fileLine = 0;
        reader = new FileReader(filePath);
        file = new Scanner(reader);
        parser = new Parser(manager);

        if (!file.hasNextLine())
        {
            System.out.println("There is no device info in the file: " + filePath);
            System.out.println("");
        }
        else {


            while (file.hasNextLine()) {
                try {
                    fileLine++;
                    parser.ParseDevice(file.nextLine(), deviceType);
                } catch (NumberFormatException e) {
                    System.out.println("Line " + fileLine + " contains incorrect parameters. This device won't be created");
                    System.out.println("");
                }
            }
        }

    }

    public void writeFile(String filePath, int deviceType) throws IOException {
        writer = new FileWriter(filePath);
        ArrayList<String> devices = new ArrayList();
        switch (deviceType) {
            case 1:
                devices = manager.getListOfRefregeratorsData();
                break;
            case 2:
                devices = manager.getListOfTVsetsData();
                break;
            case 3:
                devices = manager.getListOfAirConditionersData();
                break;
            case 4:
                devices = manager.getListOfKitchenDevicesData();
                break;
            case 5:
                devices = manager.getListOfOtherDevicesData();
                break;
            default:
                break;

        }

        for(String device: devices){
            writer.write(device);
            writer.write("\n");
            writer.flush();
        }
        writer.close();
    }


}
