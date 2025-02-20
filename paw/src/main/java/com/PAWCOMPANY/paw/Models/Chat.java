package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int chatId;

    int senderId;
    int receiverId;
    String message;
    Date timeStamp;
}
