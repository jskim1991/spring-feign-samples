package io.jay.client;

import io.jay.client.client.RequestParameters;
import io.jay.client.client.URLUserClient;
import io.jay.client.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final URLUserClient userClient;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        RequestParameters requestParameters = new RequestParameters();
        requestParameters.setName("user1");
        requestParameters.setEmail("test@domain.com");
        return userClient.getAllUsers(requestParameters);
    }

    @GetMapping("/api/user/{index}")
    public Map<String, Object> getUserMap(@PathVariable int index) {
        Map<String, Object> map = userClient.getUserMap(index);
        System.out.println("id : " + map.get("id"));
        System.out.println("name : " + map.get("name"));
        System.out.println("username : " + map.get("username"));
        System.out.println("email : " + map.get("email"));
        System.out.println("phone : " + map.get("phone"));
        System.out.println("website : " + map.get("website"));

        System.out.println("== For address object ==");
        LinkedHashMap<String, Object> addressMap = (LinkedHashMap<String, Object>) map.get("address");
        System.out.println("address::street : " + addressMap.get("street"));
        System.out.println("address::suite : " + addressMap.get("suite"));
        System.out.println("address::city : " + addressMap.get("city"));
        System.out.println("address::zipcode : " + addressMap.get("zipcode"));
        System.out.println("==== For address::geo ====");
        LinkedHashMap<String, Object> geoMap = (LinkedHashMap<String, Object>) addressMap.get("geo");
        System.out.println("address::geo::lat : " + geoMap.get("lat"));
        System.out.println("address::geo::lng : " + geoMap.get("lng"));

        System.out.println("== For company object ==");
        LinkedHashMap<String, Object> companyMap = (LinkedHashMap<String, Object>) map.get("company");
        System.out.println("company::name : " + companyMap.get("name"));
        System.out.println("company::catchPhrase : " + companyMap.get("catchPhrase"));
        System.out.println("company::bs : " + companyMap.get("bs"));
        return map;
    }
}
