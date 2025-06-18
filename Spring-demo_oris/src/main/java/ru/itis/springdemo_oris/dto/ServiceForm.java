package ru.itis.springdemo_oris.dto;

import lombok.Data;
import ru.itis.springdemo_oris.models.User;

@Data
public class ServiceForm {


    private String name;
    private String cost;
    private String date;
}
