package com.example.demo.data.entity.listener;

import com.example.demo.data.entity.Listener;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomListener {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomListener.class);

    @PostLoad
    public void postLoad(Listener listener) {
        LOGGER.info("[postLoad] called!!");
    }

    @PrePersist
    public void prePersist(Listener listener) {
        LOGGER.info("[prePersist] called!!");
    }

    @PostPersist
    public void postPersist(Listener listener) {
        LOGGER.info("[postPersist] called!!");
    }

    @PreUpdate
    public void preUpdate(Listener listener) {
        LOGGER.info("[preUpdate] called!!");
    }

    @PostUpdate
    public void postUpdate(Listener listener) {
        LOGGER.info("[postUpdate] called!!");
    }

    @PreRemove
    public void preRemove(Listener listener) {
        LOGGER.info("[preRemove] called!!");
    }

    @PostRemove
    public void PostRemove(Listener listener) {
        LOGGER.info("[PostRemove] called!!");
    }
}
