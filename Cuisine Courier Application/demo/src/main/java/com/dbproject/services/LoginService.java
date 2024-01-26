package com.dbproject.services;

import com.dbproject.Models.Credentials;
import com.dbproject.repository.CredentailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//all logical services here
@Service
public class LoginService {
    CredentailRepository credentailRepository;

    @Autowired
    public LoginService(CredentailRepository credentailRepository) {
        this.credentailRepository = credentailRepository;

    }

    public Credentials getCredentialsByUsername(String username){

        return credentailRepository.findByUsername(username);
    }

//    public List<Credentials> getAllCredentials(){
//
//        return credentailRepository.findAll();
//    }

public Credentials authenticate(String username, String password){
        return credentailRepository.findByUsernameAndPassword(username, password);
}

    public Credentials registerUser(String username, String password, String email) {
        if (credentailRepository.existsByUsername(username)) {
            // Username is not unique
            return null;
        }

        if (credentailRepository.existsByEmail(email)) {
            // Email is not unique
            return null;
        }
        Credentials credentials = new Credentials();
        credentials.setUsername(username);
        credentials.setPassword(password);
        credentials.setEmail(email);

        return credentailRepository.save(credentials);
    }

}
