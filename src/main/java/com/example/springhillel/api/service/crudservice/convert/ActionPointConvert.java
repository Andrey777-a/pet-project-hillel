package com.example.springhillel.api.service.crudservice.convert;

import com.example.springhillel.model.dto.ActionPointDTO;
import com.example.springhillel.model.entity.ActionPoint;
import org.springframework.stereotype.Component;

@Component
public class ActionPointConvert implements AbstractConvert<ActionPoint, ActionPointDTO> {

    @Override
    public ActionPoint convertToEntity(ActionPointDTO actionPointDTO) {
        return new ActionPoint(actionPointDTO.getName());
    }

    @Override
    public ActionPointDTO covertToDTO(ActionPoint actionPoint) {
        return new ActionPointDTO(actionPoint.getName());
    }
}
