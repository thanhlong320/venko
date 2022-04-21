package com.axonactive.venko.service.impl;

import com.axonactive.venko.controller.request.ItemRequest;
import com.axonactive.venko.entity.Item;
import com.axonactive.venko.entity.Task;
import com.axonactive.venko.mapper.ItemMapper;
import com.axonactive.venko.service.ItemService;
import com.axonactive.venko.service.dto.ItemDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class ItemServiceImpl implements ItemService {

    @PersistenceContext(name = "venko")
    private EntityManager entityManager;

    @Inject
    private ItemMapper itemMapper;

    @Override
    public List<ItemDTO> findAll() {
        return itemMapper.toDTOs(entityManager.createQuery("FROM Item", Item.class).getResultList());
    }

    @Override
    public ItemDTO update(Item item) {
        entityManager.merge(item);
        return itemMapper.toDTO(item);
    }

    @Override
    public ItemDTO add(Item item) {
        entityManager.persist(item);
        return itemMapper.toDTO(item);
    }

    @Override
    public void delete(Integer itemId) {
        Item item = entityManager.find(Item.class, itemId);
        entityManager.remove(item);
    }

}
