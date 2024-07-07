package com.example.demo.data.entity.listener;

import com.example.demo.data.entity.ListenerEntity;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomListener {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

    @PostLoad
    public void postLoad(ListenerEntity listenerEntity) {
        LOGGER.info("[postLoad] called!!");
    }

    @PrePersist
    public void prePersist(ListenerEntity listenerEntity) {
        LOGGER.info("[prePersist] called!!");
    }

    @PostPersist
    public void postPersist(ListenerEntity listenerEntity) {
        LOGGER.info("[postPersist] called!!");
    }

    @PreUpdate
    public void preUpdate(ListenerEntity listenerEntity) {
        LOGGER.info("[preUpdate] called!!");
    }

    @PostUpdate
    public void postUpdate(ListenerEntity listenerEntity) {
        LOGGER.info("[postUpdate] called!!");
    }

    @PreRemove
    public void preRemove(ListenerEntity listenerEntity) {
        LOGGER.info("[preRemove] called!!");
    }

    @PostRemove
    public void PostRemove(ListenerEntity listenerEntity) {
        LOGGER.info("[PostRemove] called!!");
    }
}
