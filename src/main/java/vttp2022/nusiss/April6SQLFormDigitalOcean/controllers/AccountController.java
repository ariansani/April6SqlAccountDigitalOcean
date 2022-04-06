package vttp2022.nusiss.April6SQLFormDigitalOcean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.nusiss.April6SQLFormDigitalOcean.models.Account;
import vttp2022.nusiss.April6SQLFormDigitalOcean.repositories.AccountRepository;

@Controller
@RequestMapping("/")
public class AccountController {
    
    @Autowired
    private AccountRepository accRepo;

    @GetMapping
    public String loadIndex(Model model){
        List<Account> accountList = accRepo.getAccounts();
        

        model.addAttribute("accounts", accountList);
        return "index";
    }

    @PostMapping(path="/createAcc", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createAcc(@RequestBody MultiValueMap<String,String> form ,Model model){
       String email = form.getFirst("email");
       String name = form.getFirst("name");
       String phone = form.getFirst("phone");
       String dob = form.getFirst("dob");
       String status = form.getFirst("status");
       String password = form.getFirst("pass_phrase");
       
       Boolean emailExists = accRepo.isEmailIdExists(email);
       if (!emailExists){

        Boolean accountAdded = accRepo.InsertAccount(email,name, phone, dob,status, password);
        System.out.println("Account added is 1 if success"+ accountAdded);
       }

       System.out.println("Account added is 0, already exists");

        List<Account> accountList = accRepo.getAccounts();
        model.addAttribute("accounts", accountList);
        return "index";
    }


}
