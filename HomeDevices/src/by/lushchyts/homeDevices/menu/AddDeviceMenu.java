package by.lushchyts.homeDevices.menu;

import by.lushchyts.homeDevices.exception.SelectedOptionException;
import by.lushchyts.homeDevices.utils.KeyListener;
import by.lushchyts.homeDevices.utils.InputValues;
import by.lushchyts.homeDevices.deviceManager.DeviceManager;

public class AddDeviceMenu implements Menu {

    DeviceManager manager;

    public AddDeviceMenu(DeviceManager manager){
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

        int key;

        KeyListener enteredMenuOption = new KeyListener();

        InputValues console = new InputValues();

        try {
            switch (key = enteredMenuOption.getPressedKey()) {
                case 1:
                    manager.addRefregerator(console.getDeviceName(), console.getConsumingPower());
                    break;
                case 2:
                    manager.addTVset(console.getDeviceName(), console.getConsumingPower());
                    break;
                case 3:
                    manager.addAirConditioner(console.getDeviceName(), console.getConsumingPower());
                    break;
                case 4:
                    manager.addSmallKitchenDevice(console.getDeviceName(), console.getConsumingPower());
                    break;
                case 5:
                    manager.addOtherSmallDevice(console.getDeviceName(), console.getConsumingPower());
                    break;
                default:
                    break;
            }

        }catch (SelectedOptionException e){

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("");
        }
    }

}
