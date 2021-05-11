package com.web_services.projeto_web_services_secao25.repositories;

import com.web_services.projeto_web_services_secao25.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
