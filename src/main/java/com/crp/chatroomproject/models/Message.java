package com.crp.chatroomproject.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    private String message;
    private String receiver;
    @CreationTimestamp
    private Timestamp date;

    public Message(User sender, String receiver, String message) {
        this.sender = sender;
        this.receiver =receiver;
        this.message = message;
    }
}
