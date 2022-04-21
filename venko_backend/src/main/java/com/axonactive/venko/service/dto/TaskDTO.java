package com.axonactive.venko.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDTO {
    private Integer id;
    private String title;
    private Boolean isDone;
    private LocalDate date;
    private Integer itemId;
}
