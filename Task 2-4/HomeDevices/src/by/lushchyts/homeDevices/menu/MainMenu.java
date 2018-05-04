package by.lushchyts.homeDevices.menu;

import by.lushchyts.homeDevices.dataExport.FromXML;
import by.lushchyts.homeDevices.exception.SelectedOptionException;
import by.lushchyts.homeDevices.utils.KeyListener;
import by.lushchyts.homeDevices.deviceManager.DeviceManager;
import by.lushchyts.homeDevices.menu.ReadFileMenu;
import by.lushchyts.homeDevices.dataExport.FromDataBase;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.xml.sax.SAXException;

public class MainMenu implements Menu {

    public DeviceManager manager = new DeviceManager();
    private AddDeviceMenu addDevce = new AddDeviceMenu(manager);
    private AllDevicesMenu allDevices = new AllDevicesMenu(manager);
    private OnOffMenu onOff = new OnOffMenu(manager);
    private FindDeviceMenu find = new FindDeviceMenu(manager);
    private ReadFileMenu read = new ReadFileMenu(manager);
    private FromDataBase dataBase = new FromDataBase(manager);
    private FromXML xml = new FromXML(manager);

    @Override
    public void display() {
        System.out.println("Please, select one of the available options:");
        System.out.println("1 - Display the list of all devices");
        System.out.println("2 - Power on/off a device");
        System.out.println("3 - Turn on/off a device");
        System.out.println("4 - Add a device");
        System.out.println("5 - Calculate total current consuming power");
        System.out.println("6 - Sort devices by Power Consumption");
        System.out.println("7 - Find a device");
        System.out.println("8 - Restore data from file");
        System.out.println("9 - Save data to file");
        System.out.println("10 - Import Data from DataBase");
        System.out.println("11 - Import Data from XML file");
        System.out.println("0 - exit");
    }

    @Override
    public void selectMenuOption() {

        int key;

        KeyListener enteredMenuOption = new KeyListener();

        try {


            switch (key = enteredMenuOption.getPressedKey()) {
                case 1:
                    allDevices.display();
                    break;
                case 2:
                    onOff.display();
                    onOff.selectMenuOption();
                    onOff.selectDeviceToOnOffPower();
                    break;
                case 3:
                    onOff.display();
                    onOff.selectMenuOption();
                    onOff.selectDeviceToOnOff();
                    break;
                case 4:
                    addDevce.display();
                    addDevce.selectMenuOption();
                    break;
                case 5:
                    manager.getTotalCurrentConsumption();
                    break;
                case 6:
                    manager.sortDevicesByPower();
                    break;
                case 7:
                    find.display();
                    find.selectMenuOption();
                    break;
                case 8:
                    read.readFiles();
                    break;
                case 9:
                    read.writeFiles();
                    break;
                case 10:
                    dataBase.establichConection();
                    dataBase.importData();
                    break;
                case 11:
                    xml.importData();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("");
                    System.out.println("Unknown option. Please, re-try");
                    System.out.println("");
                    break;
            }

        } catch (SelectedOptionException e) {
            System.out.println(e.getMessage());
            System.out.println("");
        }


    }
}
