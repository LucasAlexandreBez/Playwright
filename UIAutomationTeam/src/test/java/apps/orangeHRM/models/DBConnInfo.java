package apps.orangeHRM.models;

import engine.DatabaseType;

public class DBConnInfo {
    private DatabaseType dbType;
    private String server; 
    private String port;
    private String database; 
    private String username;
    private String password;
    
    public DBConnInfo() {}

    public DBConnInfo(DatabaseType dbType, String server, String port, String database, String username,String password) {
        this.dbType = dbType;
        this.server = server;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public DatabaseType getDbType() {
        return dbType;
    }

    public void setDbType(DatabaseType dbType) {
        this.dbType = dbType;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
