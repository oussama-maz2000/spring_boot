package com.medoc.find.client.dao.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MED_CLIENT_INFO")
@Data
public class ClientEntity {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "MED_CI_NAME", nullable = false, length = 30)
    public String name;

    @Column(name = "MED_CI_LAST_NAME")
    public String lastName;

    @Column(name = "MED_CI_EMAIL")
    public String email;

    @Column(name = "MED_CI_ADDRESS", nullable = false, length = 30)
    public String address;

    @Column(name = "MED_CI_PHONE", nullable = false)
    public String phone;


}
