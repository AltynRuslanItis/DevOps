package ru.itis.springdemo_oris.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    private String email;
    private String password;
    private String firstname;
    private String lastname;

}
