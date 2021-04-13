package com.example.springhillel.api.service.crudservice.convert;

import org.springframework.stereotype.Component;

@Component
public interface AbstractConvert <E, D>{

    E convertToEntity(D d);

    D covertToDTO(E e);

}
