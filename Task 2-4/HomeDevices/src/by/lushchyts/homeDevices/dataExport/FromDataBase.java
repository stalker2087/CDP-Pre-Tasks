package by.lushchyts.homeDevices.dataExport;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;

import by.lushchyts.homeDevices.deviceManager.DeviceManager;

public class FromDataBase implements ImportData {

    private String url = ("jdbc:mysql://localhost:3306/HomeDevices?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
    private String login = "DeviceManager";
    private String password = "3552";
    private String sql = "Select DeviceTypeId, Name, ConsumingPower, case when PowerSupplyStatusId = 1 then false else true end as PowerSupplyState, case when SwitchStatusId = 1 then false else true end as SwitchStatus from Device";
    Connection connection;
    ResultSet queryResults;
    private DeviceManager manager;

    public FromDataBase(DeviceManager manager) {
        this.manager = manager;
    }

    public void establichConection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }


        try {
            connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            queryResults = statement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Connection is not established!");
        }

    }

    @Override
    public void importData() {

        try {
            while (queryResults.next()) {

                switch (queryResults.getInt("DeviceTypeId")) {
                    case 1:
                        manager.importRefregerator(queryResults.getString("Name"), queryResults.getInt("ConsumingPower"), queryResults.getBoolean("PowerSupplyState"), queryResults.getBoolean("SwitchStatus"));
                        break;
                    case 2:
                        manager.importTVset(queryResults.getString("Name"), queryResults.getInt("ConsumingPower"), queryResults.getBoolean("PowerSupplyState"), queryResults.getBoolean("SwitchStatus"));
                        break;
                    case 3:
                        manager.importAirConditioner(queryResults.getString("Name"), queryResults.getInt("ConsumingPower"), queryResults.getBoolean("PowerSupplyState"), queryResults.getBoolean("SwitchStatus"));
                        break;
                    case 4:
                        manager.importSmallKitchenDevice(queryResults.getString("Name"), queryResults.getInt("ConsumingPower"), queryResults.getBoolean("PowerSupplyState"), queryResults.getBoolean("SwitchStatus"));
                        break;
                    case 5:
                        manager.importOtherSmallDevice(queryResults.getString("Name"), queryResults.getInt("ConsumingPower"), queryResults.getBoolean("PowerSupplyState"), queryResults.getBoolean("SwitchStatus"));
                        break;
                    default:
                        System.out.println("Device type is not supported");
                }

            }
        } catch (SQLException e) {
            System.out.println("Internal Error accurred when reading data!");
        }

    }
}
