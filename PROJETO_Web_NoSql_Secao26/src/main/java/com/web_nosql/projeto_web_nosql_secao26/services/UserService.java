package com.web_nosql.projeto_web_nosql_secao26.services;

import com.web_nosql.projeto_web_nosql_secao26.domain.User;
import com.web_nosql.projeto_web_nosql_secao26.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
