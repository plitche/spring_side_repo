package com.example.demo.service.impl;

import com.example.demo.data.entity.ListenerEntity;
import com.example.demo.data.repository.ListenerRepository;
import com.example.demo.service.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListenerServiceImpl implements ListenerService {

    private ListenerRepository listenerRepository;

    @Autowired
    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public ListenerEntity getEntity(Long id) {
        return listenerRepository.findById(id).get();
    }

    @Override
    public void saveEntity(ListenerEntity listenerEntity) {
        listenerRepository.save(listenerEntity);
    }

    @Override
    public void updateEntity(ListenerEntity listenerEntity) {
        ListenerEntity entity = listenerRepository.findById(listenerEntity.getId()).get();
        entity.setName(listenerEntity.getName());

        listenerRepository.save(entity);
    }

    @Override
    public void removeEntity(ListenerEntity entity) {
        listenerRepository.delete(entity);
    }
}
