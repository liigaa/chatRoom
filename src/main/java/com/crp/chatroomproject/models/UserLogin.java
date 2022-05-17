package com.crp.chatroomproject.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLogin {
    private String userName;
    private String password;
}
