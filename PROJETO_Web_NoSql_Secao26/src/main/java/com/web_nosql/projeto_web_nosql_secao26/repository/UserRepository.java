package com.web_nosql.projeto_web_nosql_secao26.repository;

import com.web_nosql.projeto_web_nosql_secao26.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
