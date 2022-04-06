package vttp2022.nusiss.April6SQLFormDigitalOcean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.nusiss.April6SQLFormDigitalOcean.models.Account;
import vttp2022.nusiss.April6SQLFormDigitalOcean.repositories.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accRepo;

    public List<Account> getAccounts(){
        
        return accRepo.getAccounts();

    }

    public boolean InsertAccount(String email, String name, String phone, String dob, String status,String pass_phrase){

        return accRepo.InsertAccount(email, name, phone, dob, status, pass_phrase);
    }

    public boolean isEmailIdExists(String email){
        return accRepo.isEmailIdExists(email);
    }

}
