package com.example.demo.service.impl;

import com.example.demo.data.entity.Listener;
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
    public Listener getEntity(Long id) {
        return listenerRepository.findById(id).get();
    }

    @Override
    public void saveEntity(Listener listener) {
        listenerRepository.save(listener);
    }

    @Override
    public void updateEntity(Listener listener) {
        Listener entity = listenerRepository.findById(listener.getId()).get();
        entity.setName(listener.getName());

        listenerRepository.save(entity);
    }

    @Override
    public void removeEntity(Listener entity) {
        listenerRepository.delete(entity);
    }
}
