package by.lushchyts.homeDevices.menu;

import by.lushchyts.homeDevices.exception.SelectedOptionException;
import by.lushchyts.homeDevices.utils.KeyListener;
import by.lushchyts.homeDevices.utils.InputValues;
import by.lushchyts.homeDevices.deviceManager.DeviceManager;
import by.lushchyts.homeDevices.exception.NoResultsFoundException;

public class FindDeviceMenu implements Menu {

    DeviceManager manager;
    InputValues console = new InputValues();

    public FindDeviceMenu(DeviceManager manager) {

        this.manager = manager;
    }

    @Override
    public void display() {
        System.out.println("");
        System.out.println("Please, select one of the available options:");
        System.out.println("1 - Find by Name");
        System.out.println("2 - Find by consuming power");
        System.out.println("");
        System.out.println("Press any othey key to get back");
    }

    @Override
    public void selectMenuOption(){

        int key;

        KeyListener enteredMenuOption = new KeyListener();

        try {
            switch (key= enteredMenuOption.getPressedKey()) {

                case 1:
                    manager.findDeviceByName(console.getDeviceName());
                    break;
                case 2:
                    manager.findDeviceByPower(console.getMinPower(), console.getMaxPower());
                    break;
                default:
                    break;

            }
        }
        catch(NoResultsFoundException e) {
            System.out.println(e.getMessage());
        }

            catch (SelectedOptionException e){

            }
        }
    }



