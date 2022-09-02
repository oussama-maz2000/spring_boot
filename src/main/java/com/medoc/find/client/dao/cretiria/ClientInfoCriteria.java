package com.medoc.find.client.dao.cretiria;

import lombok.Data;

@Data
public class ClientInfoCriteria {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
