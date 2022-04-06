package vttp2022.nusiss.April6SQLFormDigitalOcean.models;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Account {
    private String email;
    private String phone;
    private String name;
    private Date dob;
    private String status;
    private String pass_phrase;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPass_phrase() {
        return pass_phrase;
    }

    public void setPass_phrase(String pass_phrase) {
        this.pass_phrase = pass_phrase;
    }

    public static Account create(SqlRowSet rs) {
        Account acc = new Account();

        acc.email = rs.getString("email");
        acc.name = rs.getString("name");
        acc.phone = rs.getString("phone");
        acc.dob = rs.getDate("dob");
        acc.status = rs.getString("status");
        acc.pass_phrase = rs.getString("pass_phrase");

        return acc;
    }

}
