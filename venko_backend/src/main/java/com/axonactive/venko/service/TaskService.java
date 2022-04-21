package com.axonactive.venko.service;

import com.axonactive.venko.controller.request.TaskRequest;
import com.axonactive.venko.service.dto.TaskDTO;


public interface TaskService {
    TaskDTO add(TaskRequest taskRequest, Integer taskId);
    TaskDTO update(TaskRequest taskRequest, Integer taskId, Integer itemId);
    void delete(Integer taskId, Integer itemId);
}
