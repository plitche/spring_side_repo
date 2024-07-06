package com.example.demo.data.dao;

import com.example.demo.data.entity.ShortUrlEntity;

public interface ShortUrlDAO {

    ShortUrlEntity getShortUrl(String originalUrl);

    ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity);

    ShortUrlEntity getOriginalUrl(String shortUrl);

    ShortUrlEntity updateShortUrl(ShortUrlEntity newShortUrlEntity);

    void deleteByShortUrl(String shortUrl);

    void deleteByOriginalUrl(String originalUrl);
}
