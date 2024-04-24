package kz.iitu.taskrestphoenix.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "fio")
    private String fio;


    @Column(name = "avatar_link")
    private String avatarLink;

}