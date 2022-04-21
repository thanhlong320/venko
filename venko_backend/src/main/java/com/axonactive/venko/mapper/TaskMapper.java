package com.axonactive.venko.mapper;

import com.axonactive.venko.controller.request.TaskRequest;
import com.axonactive.venko.entity.Task;
import com.axonactive.venko.service.dto.TaskDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    Task toEntity(TaskRequest taskRequest);
    TaskDTO toDTO(Task task);
    List<TaskDTO> toDTOs(List<Task> tasks);
}
