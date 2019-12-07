package sut.ist912m.lobanov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sut.ist912m.lobanov.logger.Log;
import sut.ist912m.lobanov.pojo.Data;
import sut.ist912m.lobanov.pojo.Posts;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;

@RestController
public class SocialController {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Log
    @RequestMapping(path = "/posts", method = RequestMethod.GET, produces = "application/json")
    public Collection<Data> posts() {
        Posts postsList = restTemplate.getForObject("https://graph.facebook.com/me/posts", Posts.class);
        return Arrays.asList(postsList.getData());
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }


}
