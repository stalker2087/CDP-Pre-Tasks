package by.lushchyts.homeDevices.utils;

public class StringToBoolean {

    public boolean convertToBoolean(String value) {
        switch (value) {
            case "Off":
                return false;

            case "On":
                return true;

            case "off":
                return false;

            case "on":
                return true;

            default:
                return false;

        }
    }

}
