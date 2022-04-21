package com.axonactive.venko.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequest {
    private String title;
    private Boolean isDone;
    private LocalDate date;
    private Integer itemId;
}
