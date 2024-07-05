package com.example.demo.data.dao;

import com.example.demo.data.entity.ShortUrlEntity;

public interface ShortUrlDAO {

    ShortUrlEntity getShortUrl(String originalUrl);

    void saveShortUrl(ShortUrlEntity shortUrlEntity);
}
