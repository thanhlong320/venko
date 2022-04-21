package com.axonactive.venko.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemDTO {
    private Integer id;
    private String code;
    private String name;
    private List<TaskDTO> tasks;
}
