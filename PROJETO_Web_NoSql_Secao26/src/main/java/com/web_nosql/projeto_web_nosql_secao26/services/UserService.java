package com.web_nosql.projeto_web_nosql_secao26.services;

import com.web_nosql.projeto_web_nosql_secao26.domain.User;
import com.web_nosql.projeto_web_nosql_secao26.dto.UserDTO;
import com.web_nosql.projeto_web_nosql_secao26.repository.UserRepository;
import com.web_nosql.projeto_web_nosql_secao26.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    public User insert(User user){
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(), userDTO.getEmail());
    }

}
