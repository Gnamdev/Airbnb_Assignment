package com.airbnb.airbnb_assignment.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;


    private String password;


    private String email;


    private String fullName;

    private String phoneNumber;
}
