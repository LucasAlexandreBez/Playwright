package apps.orangeHRM.models.database;

import java.sql.Date;

public class HSHREmployee {
    private String emp_number;
    private String employee_id;
    private String emp_lastname;
    private String emp_middle_name;
    private String emp_firstname;
    private String emp_nick_name;
    private Boolean emp_smoker;
    private String ethnic_race_code;
    private Date emp_birthday;
    private Integer nation_code;
    private Integer emp_gender;
    private String emp_marital_status;
    private String emp_ssn_num;
    private String emp_sin_num;
    private String emp_other_id;
    private String emp_dri_lice_num;
    private Date emp_dri_lice_exp_date;
    private String emp_military_service;
    private Integer emp_status;
    private Integer job_title_code;
    private Integer eeo_cat_code;
    private Integer work_station;
    private String emp_street1;
    private String emp_street2;
    private String city_code;
    private String coun_code;
    private String provin_code;
    private String emp_zipcode;
    private String emp_hm_telephone;
    private String emp_mobile;
    private String emp_work_telephone;
    private String emp_work_email;
    private String sal_grd_code;
    private Date joined_date;
    private String emp_oth_email;
    private Integer termination_id;
    private String custom1;
    private String custom2;
    private String custom3;
    private String custom4;
    private String custom5;
    private String custom6;
    private String custom7;
    private String custom8;
    private String custom9;
    private String custom10;
    private Date purged_at;

    public HSHREmployee() {
    }

    public HSHREmployee(String emp_number, String employee_id, String emp_lastname, String emp_firstname, String emp_middle_name,
            String emp_nick_name, Boolean emp_smoker, String ethnic_race_code, Date emp_birthday, Integer nation_code,
            Integer emp_gender, String emp_marital_status, String emp_ssn_num, String emp_sin_num, String emp_other_id,
            String emp_dri_lice_num, Date emp_dri_lice_exp_date, String emp_military_service, Integer emp_status,
            Integer job_title_code, Integer eeo_cat_code, Integer work_station, String emp_street1, String emp_street2,
            String city_code, String coun_code, String provin_code, String emp_zipcode, String emp_hm_telephone,
            String emp_mobile, String emp_work_telephone, String emp_work_email, String sal_grd_code, Date joined_date,
            String emp_oth_email, Integer termination_id, String custom1, String custom2, String custom3,
            String custom4, String custom5, String custom6, String custom7, String custom8, String custom9,
            String custom10, Date purged_at) {
        this.emp_number = emp_number;
        this.employee_id = employee_id;
        this.emp_lastname = emp_lastname;
        this.emp_firstname = emp_firstname;
        this.emp_middle_name = emp_middle_name;
        this.emp_nick_name = emp_nick_name;
        this.emp_smoker = emp_smoker;
        this.ethnic_race_code = ethnic_race_code;
        this.emp_birthday = emp_birthday;
        this.nation_code = nation_code;
        this.emp_gender = emp_gender;
        this.emp_marital_status = emp_marital_status;
        this.emp_ssn_num = emp_ssn_num;
        this.emp_sin_num = emp_sin_num;
        this.emp_other_id = emp_other_id;
        this.emp_dri_lice_num = emp_dri_lice_num;
        this.emp_dri_lice_exp_date = emp_dri_lice_exp_date;
        this.emp_military_service = emp_military_service;
        this.emp_status = emp_status;
        this.job_title_code = job_title_code;
        this.eeo_cat_code = eeo_cat_code;
        this.work_station = work_station;
        this.emp_street1 = emp_street1;
        this.emp_street2 = emp_street2;
        this.city_code = city_code;
        this.coun_code = coun_code;
        this.provin_code = provin_code;
        this.emp_zipcode = emp_zipcode;
        this.emp_hm_telephone = emp_hm_telephone;
        this.emp_mobile = emp_mobile;
        this.emp_work_telephone = emp_work_telephone;
        this.emp_work_email = emp_work_email;
        this.sal_grd_code = sal_grd_code;
        this.joined_date = joined_date;
        this.emp_oth_email = emp_oth_email;
        this.termination_id = termination_id;
        this.custom1 = custom1;
        this.custom2 = custom2;
        this.custom3 = custom3;
        this.custom4 = custom4;
        this.custom5 = custom5;
        this.custom6 = custom6;
        this.custom7 = custom7;
        this.custom8 = custom8;
        this.custom9 = custom9;
        this.custom10 = custom10;
        this.purged_at = purged_at;
    }

    public HSHREmployee(String emp_number, String employee_id, String emp_lastname, String emp_middle_name, String emp_firstname) {
        this.emp_number = emp_number;
        this.employee_id = employee_id;
        this.emp_lastname = emp_lastname;
        this.emp_middle_name = emp_middle_name;
        this.emp_firstname = emp_firstname;
    }

    public String getEmp_number() {
        return emp_number;
    }

    public void setEmp_number(String emp_number) {
        this.emp_number = emp_number;
    }
    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmp_lastname() {
        return emp_lastname;
    }

    public void setEmp_lastname(String emp_lastname) {
        this.emp_lastname = emp_lastname;
    }

    public String getEmp_firstname() {
        return emp_firstname;
    }

    public void setEmp_firstname(String emp_firstname) {
        this.emp_firstname = emp_firstname;
    }

    public String getEmp_middle_name() {
        return emp_middle_name;
    }

    public void setEmp_middle_name(String emp_middle_name) {
        this.emp_middle_name = emp_middle_name;
    }

    public String getEmp_nick_name() {
        return emp_nick_name;
    }

    public void setEmp_nick_name(String emp_nick_name) {
        this.emp_nick_name = emp_nick_name;
    }

    public Boolean getEmp_smoker() {
        return emp_smoker;
    }

    public void setEmp_smoker(Boolean emp_smoker) {
        this.emp_smoker = emp_smoker;
    }

    public String getEthnic_race_code() {
        return ethnic_race_code;
    }

    public void setEthnic_race_code(String ethnic_race_code) {
        this.ethnic_race_code = ethnic_race_code;
    }

    public Date getEmp_birthday() {
        return emp_birthday;
    }

    public void setEmp_birthday(Date emp_birthday) {
        this.emp_birthday = emp_birthday;
    }

    public Integer getNation_code() {
        return nation_code;
    }

    public void setNation_code(Integer nation_code) {
        this.nation_code = nation_code;
    }

    public Integer getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(Integer emp_gender) {
        this.emp_gender = emp_gender;
    }

    public String getEmp_marital_status() {
        return emp_marital_status;
    }

    public void setEmp_marital_status(String emp_marital_status) {
        this.emp_marital_status = emp_marital_status;
    }

    public String getEmp_ssn_num() {
        return emp_ssn_num;
    }

    public void setEmp_ssn_num(String emp_ssn_num) {
        this.emp_ssn_num = emp_ssn_num;
    }

    public String getEmp_sin_num() {
        return emp_sin_num;
    }

    public void setEmp_sin_num(String emp_sin_num) {
        this.emp_sin_num = emp_sin_num;
    }

    public String getEmp_other_id() {
        return emp_other_id;
    }

    public void setEmp_other_id(String emp_other_id) {
        this.emp_other_id = emp_other_id;
    }

    public String getEmp_dri_lice_num() {
        return emp_dri_lice_num;
    }

    public void setEmp_dri_lice_num(String emp_dri_lice_num) {
        this.emp_dri_lice_num = emp_dri_lice_num;
    }

    public Date getEmp_dri_lice_exp_date() {
        return emp_dri_lice_exp_date;
    }

    public void setEmp_dri_lice_exp_date(Date emp_dri_lice_exp_date) {
        this.emp_dri_lice_exp_date = emp_dri_lice_exp_date;
    }

    public String getEmp_military_service() {
        return emp_military_service;
    }

    public void setEmp_military_service(String emp_military_service) {
        this.emp_military_service = emp_military_service;
    }

    public Integer getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(Integer emp_status) {
        this.emp_status = emp_status;
    }

    public Integer getJob_title_code() {
        return job_title_code;
    }

    public void setJob_title_code(Integer job_title_code) {
        this.job_title_code = job_title_code;
    }

    public Integer getEeo_cat_code() {
        return eeo_cat_code;
    }

    public void setEeo_cat_code(Integer eeo_cat_code) {
        this.eeo_cat_code = eeo_cat_code;
    }

    public Integer getWork_station() {
        return work_station;
    }

    public void setWork_station(Integer work_station) {
        this.work_station = work_station;
    }

    public String getEmp_street1() {
        return emp_street1;
    }

    public void setEmp_street1(String emp_street1) {
        this.emp_street1 = emp_street1;
    }

    public String getEmp_street2() {
        return emp_street2;
    }

    public void setEmp_street2(String emp_street2) {
        this.emp_street2 = emp_street2;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCoun_code() {
        return coun_code;
    }

    public void setCoun_code(String coun_code) {
        this.coun_code = coun_code;
    }

    public String getProvin_code() {
        return provin_code;
    }

    public void setProvin_code(String provin_code) {
        this.provin_code = provin_code;
    }

    public String getEmp_zipcode() {
        return emp_zipcode;
    }

    public void setEmp_zipcode(String emp_zipcode) {
        this.emp_zipcode = emp_zipcode;
    }

    public String getEmp_hm_telephone() {
        return emp_hm_telephone;
    }

    public void setEmp_hm_telephone(String emp_hm_telephone) {
        this.emp_hm_telephone = emp_hm_telephone;
    }

    public String getEmp_mobile() {
        return emp_mobile;
    }

    public void setEmp_mobile(String emp_mobile) {
        this.emp_mobile = emp_mobile;
    }

    public String getEmp_work_telephone() {
        return emp_work_telephone;
    }

    public void setEmp_work_telephone(String emp_work_telephone) {
        this.emp_work_telephone = emp_work_telephone;
    }

    public String getEmp_work_email() {
        return emp_work_email;
    }

    public void setEmp_work_email(String emp_work_email) {
        this.emp_work_email = emp_work_email;
    }

    public String getSal_grd_code() {
        return sal_grd_code;
    }

    public void setSal_grd_code(String sal_grd_code) {
        this.sal_grd_code = sal_grd_code;
    }

    public Date getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(Date joined_date) {
        this.joined_date = joined_date;
    }

    public String getEmp_oth_email() {
        return emp_oth_email;
    }

    public void setEmp_oth_email(String emp_oth_email) {
        this.emp_oth_email = emp_oth_email;
    }

    public Integer getTermination_id() {
        return termination_id;
    }

    public void setTermination_id(Integer termination_id) {
        this.termination_id = termination_id;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public String getCustom5() {
        return custom5;
    }

    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }

    public String getCustom6() {
        return custom6;
    }

    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }

    public String getCustom7() {
        return custom7;
    }

    public void setCustom7(String custom7) {
        this.custom7 = custom7;
    }

    public String getCustom8() {
        return custom8;
    }

    public void setCustom8(String custom8) {
        this.custom8 = custom8;
    }

    public String getCustom9() {
        return custom9;
    }

    public void setCustom9(String custom9) {
        this.custom9 = custom9;
    }

    public String getCustom10() {
        return custom10;
    }

    public void setCustom10(String custom10) {
        this.custom10 = custom10;
    }

    public Date getPurged_at() {
        return purged_at;
    }

    public void setPurged_at(Date purged_at) {
        this.purged_at = purged_at;
    }
    
}
