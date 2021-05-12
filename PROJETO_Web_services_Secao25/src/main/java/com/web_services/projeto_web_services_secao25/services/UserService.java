package com.web_services.projeto_web_services_secao25.services;

import com.web_services.projeto_web_services_secao25.entities.User;
import com.web_services.projeto_web_services_secao25.repositories.UserRepository;
import com.web_services.projeto_web_services_secao25.services.exceptions.DatabaseException;
import com.web_services.projeto_web_services_secao25.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new ResouceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try{
            userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResouceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        try {
            User entity = userRepository.getOne(id);
            updateData(entity, user);
            return userRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResouceNotFoundException(id);
        }

    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
