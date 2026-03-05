package apps.orangeHRM.flows.models;

public class Employee {
    private String employeeId;
    private String profileImagePath;
    private String firstName; 
    private String middleName;
    private String lastName;
    private String username;
    private String password;

    public Employee() {
    }

    public Employee(String employeeId, String profileImagePath, String firstName, String middleName, String lastName, String username, String password) {
        this.employeeId = employeeId;
        this.profileImagePath = profileImagePath;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Employee(String profileImagePath, String firstName, String middleName, String lastName, String username, String password) {
        this.profileImagePath = profileImagePath;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Employee(String employeeId, String username) {
        this.password = employeeId;
        this.username = username;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
