package by.lushchyts.homeDevices.dataExport;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;

import org.xml.sax.SAXException;
import by.lushchyts.homeDevices.deviceManager.DeviceManager;
import by.lushchyts.homeDevices.utils.StringToBoolean;

public class FromXML implements ImportData{

    private DeviceManager manager;
    StringToBoolean convert = new StringToBoolean();


    public FromXML(DeviceManager manager) {
        this.manager = manager;

    }

    @Override
    public void importData() {

        String filePath = "C:\\Users\\Uladzimir\\IdeaProjects\\HomeDevices\\src\\files\\Devices.xml";

        try {

            NodeList devices = openXMLDocument(filePath);
            parseXMLFile(devices);

        } catch (ParserConfigurationException e) {
            System.out.println("Parser configuration error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX Ecxeption: " + e.getMessage());
        }


    }

    public NodeList openXMLDocument(String filePath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(filePath));
        document.normalizeDocument();
        Element root = document.getDocumentElement();
        NodeList deviceList = root.getElementsByTagName("Device");
        return deviceList;
    }

    public void parseXMLFile(NodeList deviceList) {

        String name="";
        int consumingPower=0;
        boolean powerSupply=false;
        boolean state=false;
        String deviceType="";


        for (int i = 0; i < deviceList.getLength(); i++) {

            Element device = (Element) deviceList.item(i);

            NodeList deviceProperties = device.getChildNodes();

            for (int j = 0; j < deviceProperties.getLength(); j++) {

                deviceType = device.getAttribute("type");
                String property = deviceProperties.item(j).getNodeName();


               switch (property) {
                    case "Name":
                        name = deviceProperties.item(j).getTextContent();

                        break;
                    case "ConsumingPower":
                        try {
                            consumingPower = Integer.valueOf(deviceProperties.item(j).getTextContent());
                        }catch (NumberFormatException e){
                            System.out.println("Consuming power can't be converted to a number: " + deviceProperties.item(j).getTextContent());
                        }

                        break;
                    case "PowerSupply":
                        powerSupply = convert.convertToBoolean(deviceProperties.item(j).getTextContent());

                        break;
                    case "State":

                        state = convert.convertToBoolean(deviceProperties.item(j).getTextContent());

                        break;

                    default:
                        break;

                }


            }
            if(validateDeviceParameters(name, consumingPower)==true) {
                importDevice(deviceType, name, consumingPower, powerSupply, state);
            }
        }
    }

    public boolean validateDeviceParameters(String name, int consumingPower){
        if(name!="" && consumingPower>0){
            return true;
        } else {
            if(name==""){
                System.out.println("Name of the device is incorrect: " + name);
            }
            if(consumingPower<0){
                System.out.println("Consuming power is negative: " + consumingPower);
            }
            return false;
        }
    }

   public void importDevice(String type, String name, int consumingPower, boolean powerSupplyState, boolean state) {


        switch (type) {
            case "Refregerator":
                manager.importRefregerator(name,consumingPower,powerSupplyState,state);
                break;

            case "AirConditioner":
                manager.importAirConditioner(name,consumingPower,powerSupplyState,state);
                break;

            case "TVset":
                manager.importTVset(name,consumingPower,powerSupplyState,state);
                break;

            case "OtherSmallDevice":
                manager.importOtherSmallDevice(name,consumingPower,powerSupplyState,state);
                break;

             case "SmallKitchenDevice":
                 manager.importSmallKitchenDevice(name,consumingPower,powerSupplyState,state);
                break;

            default:
                System.out.println("Unknown device type: " + type);
        }
    }
}
