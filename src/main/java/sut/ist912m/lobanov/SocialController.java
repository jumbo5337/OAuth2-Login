/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sut.ist912m.lobanov;

import sut.ist912m.lobanov.logger.Log;
import sut.ist912m.lobanov.pojo.Data;
import sut.ist912m.lobanov.pojo.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;

@RestController
public class SocialController {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Log
    @RequestMapping(path = "/posts", method = RequestMethod.GET, produces = "application/json")
    public Collection<Data> posts(Model model) {
        JacksonJsonParser parser = new JacksonJsonParser();
        Posts postsList = restTemplate.getForObject("https://graph.facebook.com/me/posts", Posts.class);
        return Arrays.asList(postsList.getData());
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }


}
