package com.web_nosql.projeto_web_nosql_secao26.repository;

import com.web_nosql.projeto_web_nosql_secao26.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
