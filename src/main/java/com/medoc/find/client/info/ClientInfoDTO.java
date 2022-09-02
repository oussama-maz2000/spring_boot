package com.medoc.find.client.info;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientInfoDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String fullName;

}
