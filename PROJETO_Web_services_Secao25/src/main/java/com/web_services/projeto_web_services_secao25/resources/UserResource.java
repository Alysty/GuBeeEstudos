package com.web_services.projeto_web_services_secao25.resources;

import com.web_services.projeto_web_services_secao25.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "a", "a@1", "1", "1234");
        return ResponseEntity.ok().body(user);
    }
}
