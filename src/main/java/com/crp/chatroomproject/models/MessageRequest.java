package com.crp.chatroomproject.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageRequest {
    private String message;
    private Long userId;
    private String receiver;
}
