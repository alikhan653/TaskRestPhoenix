package kz.iitu.taskrestphoenix.dto;

import lombok.Data;

@Data
public class UserRegisterDto {

        private String username;
        private String password;
        private String passwordConfirm;
        private String fio;
        private String avatarLink;
}
