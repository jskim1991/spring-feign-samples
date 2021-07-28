package io.jay.client.client;

import io.jay.client.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(contextId = "client-context-eureka", name = "user-service")
public interface UserClient {

    @GetMapping(value = "/all")
    List<User> getAllUsers(@SpringQueryMap RequestParameters requestParameters);

    @GetMapping(value = "/user/{index}")
    Map<String, Object> getUserMap(@PathVariable(value = "index") int index);
}
