package apps.orangeHRM.models.database;

import java.sql.Date;

public class OHRMUser {
    private int id;
    private int user_role_id;
    private int emp_number;
    private String user_name;
    private String user_password;
    private boolean deleted;
    private boolean status;
    private Date date_entered;
    private Date date_modified;
    private int modified_user_by;
    private int created_by;
    
    public OHRMUser() {
    }

    public OHRMUser(int id, int user_role_id, int emp_number, String user_name, String user_password, boolean deleted,
            boolean status, Date date_entered, Date date_modified, int modified_user_by, int created_by) {
        this.id = id;
        this.user_role_id = user_role_id;
        this.emp_number = emp_number;
        this.user_name = user_name;
        this.user_password = user_password;
        this.deleted = deleted;
        this.status = status;
        this.date_entered = date_entered;
        this.date_modified = date_modified;
        this.modified_user_by = modified_user_by;
        this.created_by = created_by;
    }

    public OHRMUser(int emp_number, String user_name) {
        this.emp_number = emp_number;
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public int getEmp_number() {
        return emp_number;
    }

    public void setEmp_number(int emp_number) {
        this.emp_number = emp_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate_entered() {
        return date_entered;
    }

    public void setDate_entered(Date date_entered) {
        this.date_entered = date_entered;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }

    public int getModified_user_by() {
        return modified_user_by;
    }

    public void setModified_user_by(int modified_user_by) {
        this.modified_user_by = modified_user_by;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

}
