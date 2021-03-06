package com.web_nosql.projeto_web_nosql_secao26.config;

import com.web_nosql.projeto_web_nosql_secao26.domain.Post;
import com.web_nosql.projeto_web_nosql_secao26.domain.User;
import com.web_nosql.projeto_web_nosql_secao26.dto.AuthorDTO;
import com.web_nosql.projeto_web_nosql_secao26.dto.CommentDTO;
import com.web_nosql.projeto_web_nosql_secao26.dto.UserDTO;
import com.web_nosql.projeto_web_nosql_secao26.repository.PostRepository;
import com.web_nosql.projeto_web_nosql_secao26.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();
        userRepository.deleteAll();


        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));



        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));


        maria.getPostList().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);

        post1.getCommentDTOList().add(new CommentDTO("comment", sdf.parse("24/03/2018"), new AuthorDTO(alex)));
        post2.getCommentDTOList().add(new CommentDTO("comment2", sdf.parse("25/03/2018"), new AuthorDTO(bob)));

        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
