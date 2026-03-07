package apps.orangeHRM;

import apps.orangeHRM.models.DBConnInfo;
import engine.DatabaseType;
import helper.PropertiesConfigLoader;

/**
 * This class is responsible for providing the database connection information for the OrangeHRM application.
 * It retrieves the necessary details such as server, port, database name, username, and password from the properties file using the PropertiesConfigLoader. 
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class OrangeHRMDBInfo {
    
    public static DBConnInfo getOrangeHRMDBConnInfo() {
        String server = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.server");
        String port = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.port");
        String database = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.database");
        String username = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.username");
        String password = PropertiesConfigLoader.getPropertyValue("db.mysql.orangehrm.password");
        return new DBConnInfo(DatabaseType.MYSQL, server, port, database, username, password);
    }
    
}
