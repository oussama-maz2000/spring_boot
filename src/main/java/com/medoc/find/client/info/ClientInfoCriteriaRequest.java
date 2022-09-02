package com.medoc.find.client.info;

import lombok.Data;

@Data
public class ClientInfoCriteriaRequest {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
