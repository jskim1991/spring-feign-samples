package io.jay.user;

import io.jay.user.dto.RequestDTO;
import io.jay.user.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RestTemplate restTemplate;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(RequestDTO request) {
        System.out.println("name :" + request.getName());
        System.out.println("email :" + request.getEmail());

        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/users",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        return responseEntity;
    }

    @GetMapping("/user/{index}")
    public User getUserMap(@PathVariable int index) {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/users",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        List<User> users = responseEntity.getBody();

        return users.get(index);
    }
}
