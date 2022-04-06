package vttp2022.nusiss.April6SQLFormDigitalOcean.repositories;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.nusiss.April6SQLFormDigitalOcean.models.Account;

@Repository
public class AccountRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Account> getAccounts() {

        final List<Account> accountList = new LinkedList<>();

        final SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_ALL_ACCOUNTS);
        while (rs.next()) {
            accountList.add(Account.create(rs));
        }

        return Collections.unmodifiableList(accountList);

    }

    public boolean InsertAccount(String email, String name, String phone, String dob, String status,
            String pass_phrase) {

        int added = template.update(Queries.SQL_INSERT_ACCOUNT, email, name, phone, dob, status, pass_phrase);

        return added > 0;
    }

    public boolean isEmailIdExists(String email) {

        int count = template.queryForObject(Queries.SQL_CHECK_IF_EMAIL_EXISTS, new Object[] { email }, Integer.class);
        

        if (count >= 1) {
            return true;
        }
        return false;
    }

}
