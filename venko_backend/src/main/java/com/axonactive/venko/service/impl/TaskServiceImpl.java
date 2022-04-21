package com.axonactive.venko.service.impl;

import com.axonactive.venko.controller.request.TaskRequest;
import com.axonactive.venko.entity.Item;
import com.axonactive.venko.entity.Task;
import com.axonactive.venko.mapper.TaskMapper;
import com.axonactive.venko.service.TaskService;
import com.axonactive.venko.service.dto.TaskDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class TaskServiceImpl implements TaskService {
    @PersistenceContext(name = "venko")
    private EntityManager entityManager;

    @Inject
    private TaskMapper taskMapper;

    @Override
    public TaskDTO add(TaskRequest taskRequest, Integer itemId) {
        Task task = taskMapper.toEntity(taskRequest);
        Item item = entityManager.createQuery("FROM Item i WHERE i.id = :itemId", Item.class)
                .setParameter("itemId", itemId)
                .getSingleResult();
        task.setItem(item);
        entityManager.persist(task);
        TaskDTO taskDTO = taskMapper.toDTO(task);
        taskDTO.setItemId(itemId);
        return taskDTO;
    }

    @Override
    public TaskDTO update(TaskRequest taskRequest, Integer taskId, Integer itemId) {
        Task task = entityManager.find(Task.class, taskId);
        task.setTitle(taskRequest.getTitle());
        task.setDate(taskRequest.getDate());
        task.setIsDone(taskRequest.getIsDone());
        entityManager.merge(task);
        TaskDTO taskDTO = taskMapper.toDTO(task);
        taskDTO.setItemId(itemId);
        return taskDTO;
    }

    @Override
    public void delete(Integer taskId, Integer itemId) {
        Task task = entityManager.find(Task.class, taskId);
        entityManager.remove(task);
    }
}
