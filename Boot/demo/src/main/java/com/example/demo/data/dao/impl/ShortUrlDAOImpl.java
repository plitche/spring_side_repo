package com.example.demo.data.dao.impl;

import com.example.demo.data.dao.ShortUrlDAO;
import com.example.demo.data.entity.ShortUrlEntity;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlDAOImpl implements ShortUrlDAO {

    @Override
    public ShortUrlEntity getShortUrl(String originalUrl) {
        return null;
    }

    @Override
    public void saveShortUrl(ShortUrlEntity shortUrlEntity) {

    }
}
