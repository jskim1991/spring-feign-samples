package io.jay.client.user;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private Company company;
}