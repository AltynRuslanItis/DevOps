package ru.itis.springdemo_oris.services;

import ru.itis.springdemo_oris.dto.ArticleDto;
import ru.itis.springdemo_oris.dto.ServiceDto;
import ru.itis.springdemo_oris.dto.ServiceForm;

import java.util.List;

public interface ServicesService {

    List<ServiceDto> getAllServices();
    ServiceDto addService(ServiceForm serviceForm);
    List<ServiceDto> search(Integer size, Integer page, String query, String sort, String direction);

}
