package com.web_nosql.projeto_web_nosql_secao26.services;

import com.web_nosql.projeto_web_nosql_secao26.domain.Post;
import com.web_nosql.projeto_web_nosql_secao26.repository.PostRepository;
import com.web_nosql.projeto_web_nosql_secao26.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String title){
        return postRepository.findByTitleContaining(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        return postRepository.fullSearch(text, minDate, new Date(maxDate.getTime() + 24 * 60 * 60 * 1000));
    }
}
