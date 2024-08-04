package com.airbnb.airbnb_assignment.Payload;


import com.airbnb.airbnb_assignment.Dto.UserDto;
import com.airbnb.airbnb_assignment.Model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class AuthenticationResponse {
    private String token;
    private String message;
    private UserDto user;



    public AuthenticationResponse(String token, String message , User employeeDto) {
        this.token = token;
        this.message = message;
        this.user = employeeDto;
    }

//    public String getToken() {
//        return token;
//    }
//
//    public String getMessage() {
//        return message;
//    }
}
