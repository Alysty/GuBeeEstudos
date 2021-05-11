package com.web_services.projeto_web_services_secao25.repositories;

import com.web_services.projeto_web_services_secao25.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
