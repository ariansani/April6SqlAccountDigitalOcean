package vttp2022.nusiss.April6SQLFormDigitalOcean.repositories;

public interface Queries {
    
    public static final String SQL_SELECT_ALL_ACCOUNTS = "SELECT * FROM bff";

    public static final String SQL_CHECK_IF_EMAIL_EXISTS = "SELECT count(*) FROM bff WHERE email = ?";

    public static final String SQL_INSERT_ACCOUNT = "insert into bff(email, name, phone, dob, status, pass_phrase) values (?,?,?,?,?,sha1(?))";

}
