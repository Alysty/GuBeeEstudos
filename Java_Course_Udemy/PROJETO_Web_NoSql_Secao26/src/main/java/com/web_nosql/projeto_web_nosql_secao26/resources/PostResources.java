package com.web_nosql.projeto_web_nosql_secao26.resources;

import com.web_nosql.projeto_web_nosql_secao26.domain.Post;
import com.web_nosql.projeto_web_nosql_secao26.resources.util.URLUtils;
import com.web_nosql.projeto_web_nosql_secao26.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService postService;



    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @RequestMapping(value = "/title_search",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "")String text){
        return ResponseEntity.ok().body(postService.findByTitle(URLUtils.decodeParam(text)));
    }

    @RequestMapping(value="/full_search", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
                                            @RequestParam(value="text", defaultValue="") String text,
                                            @RequestParam(value="minDate", defaultValue="") String minDate,
                                            @RequestParam(value="maxDate", defaultValue="") String maxDate) {

        text = URLUtils.decodeParam(text);
        Date min = URLUtils.convertDate(minDate, new Date(0L));
        Date max = URLUtils.convertDate(maxDate, new Date());


        List<Post> list = postService.fullSearch(text, min, max);

        return ResponseEntity.ok().body(list);
    }

}
