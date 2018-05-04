package by.lushchyts.homeDevices.menu;

import by.lushchyts.homeDevices.deviceManager.DeviceManager;
import by.lushchyts.homeDevices.exception.SelectedOptionException;
import by.lushchyts.homeDevices.utils.KeyListener;

import java.util.ArrayList;

public class OnOffMenu implements Menu {

    private ArrayList<String> devices;
    private DeviceManager manager;
    private ArrayList<String> refregerators;
    private ArrayList<String> tvsets;
    private ArrayList<String> conditioners;
    private ArrayList<String> kitchenDevices;
    private ArrayList<String> otherDevices;

    private KeyListener listener = new KeyListener();
    private int key;


    public OnOffMenu(DeviceManager manager) {
        this.manager = manager;
    }

    @Override
    public void display() {

        System.out.println("");
        System.out.println("Please, select device category: ");
        System.out.println("1 - Refregerator");
        System.out.println("2 - TVset");
        System.out.println("3 - Air Conditioner");
        System.out.println("4 - Small kitchen devices");
        System.out.println("5 - Other small devices");
        System.out.println("");
        System.out.println("Press any othey key to get back");

    }

    @Override
    public void selectMenuOption() {

        KeyListener enteredMenuOption = new KeyListener();


        try {
            switch (key = enteredMenuOption.getPressedKey()) {
                case 1:
                    getListOfRefregerators();
                    break;
                case 2:
                    getListOfTVsets();

                    break;
                case 3:
                    getListOfConditioners();

                    break;
                case 4:
                    getListOfKitchenDevices();

                    break;
                case 5:
                    getListOfOtherDevices();

                    break;
                default:
                    break;
            }


        } catch (SelectedOptionException e) {

        }
    }

    public void selectDeviceToOnOffPower() {

        int deviceId;

        try {
            switch (key) {
                case 1:
                    deviceId = listener.getPressedKey();
                    manager.powerOnOffRefregerator(deviceId - 1);
                    break;
                case 2:
                    deviceId = listener.getPressedKey();
                    manager.powerOnOffTVset(deviceId - 1);
                    break;
                case 3:
                    deviceId = listener.getPressedKey();
                    manager.powerOnOffAirConditioner(deviceId - 1);
                case 4:
                    deviceId = listener.getPressedKey();
                    manager.powerOnOffKitchenDevice(deviceId - 1);
                    break;
                case 5:
                    deviceId = listener.getPressedKey();
                    manager.powerOnOffOtherDevice(deviceId - 1);
                    break;
                default:
                    break;
            }
        } catch (SelectedOptionException e) {

        } catch (IndexOutOfBoundsException e) {
            System.out.println("");
            System.out.println("Selected option is incorrect");
            System.out.println("");
        }
    }


    public void selectDeviceToOnOff() {
        int deviceId;

        try {
            switch (key) {
                case 1:
                    deviceId = listener.getPressedKey();
                    manager.onOffRefregerator(deviceId - 1);
                    break;
                case 2:
                    deviceId = listener.getPressedKey();
                    manager.onOffTVset(deviceId - 1);
                    break;
                case 3:
                    deviceId = listener.getPressedKey();
                    manager.onOffAirConditioner(deviceId - 1);
                    break;
                case 4:
                    deviceId = listener.getPressedKey();
                    manager.onOffKitchenDevice(deviceId - 1);
                    break;
                case 5:
                    deviceId = listener.getPressedKey();
                    manager.onOffOtherDevice(deviceId - 1);
                    break;
                default:
                    break;
            }
        } catch (SelectedOptionException e) {

        }catch (IndexOutOfBoundsException e) {
            System.out.println("");
            System.out.println("Selected option is incorrect");
            System.out.println("");
        }
    }

    public void getListOfRefregerators() {
        refregerators = manager.getListOfRefregerators();

        if (refregerators.size() == 0) {
            System.out.println("");
            System.out.println("There are no added devices");
            System.out.println("");
        } else {

            System.out.println("");
            System.out.println("Please, enter number of a refregerator");

            for (int i = 0; i < refregerators.size(); i++) {
                System.out.println(i + 1 + " - Power on " + refregerators.get(i));
            }

            System.out.println("");
            System.out.println("Please, press any key to get back");
        }


    }

    public void getListOfTVsets() {
        tvsets = manager.getListOfTVsets();

        if (tvsets.size() == 0) {
            System.out.println("");
            System.out.println("There are no added devices");
            System.out.println("");
        } else {


            System.out.println("");
            System.out.println("Please, enter number of a TV");

            for (int i = 0; i < tvsets.size(); i++) {
                System.out.println(i + 1 + " - Power on/off " + tvsets.get(i));
            }

            System.out.println("");
            System.out.println("Please, press any key to get back");
        }

    }

    public void getListOfConditioners() {
        conditioners = manager.getListOfAirConditioners();

        if (conditioners.size() == 0) {
            System.out.println("");
            System.out.println("There are no added devices");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("Please, enter number of a conditioner");

            for (int i = 0; i < conditioners.size(); i++) {
                System.out.println(i + 1 + " - Power on/off " + conditioners.get(i));
            }

            System.out.println("");
            System.out.println("Please, press any key to get back");
        }

    }

    public void getListOfKitchenDevices() {
        kitchenDevices = manager.getListOfKitchenDevices();

        if (kitchenDevices.size() == 0) {
            System.out.println("");
            System.out.println("There are no added devices");
            System.out.println("");
        } else {

            System.out.println("");
            System.out.println("Please, enter number of a kitchen device");

            for (int i = 0; i < kitchenDevices.size(); i++) {
                System.out.println(i + 1 + " - Power on " + kitchenDevices.get(i));
            }

            System.out.println("");
            System.out.println("Please, press any key to get back");
        }

    }

    public void getListOfOtherDevices() {
        otherDevices = manager.getListOfOtherDevices();

        if (otherDevices.size() == 0) {
            System.out.println("");
            System.out.println("There are no added devices");
            System.out.println("");
        } else {

            System.out.println("");
            System.out.println("Please, enter number of a device");

            for (int i = 0; i < otherDevices.size(); i++) {
                System.out.println(i + 1 + " - Power on " + otherDevices.get(i));
            }

            System.out.println("");
            System.out.println("Please, press any key to get back");
        }

    }


}
