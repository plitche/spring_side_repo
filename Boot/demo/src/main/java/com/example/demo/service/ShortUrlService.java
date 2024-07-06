package com.example.demo.service;

import com.example.demo.data.dto.ShortUrlResponseDto;

public interface ShortUrlService {

    ShortUrlResponseDto getShortUrl(String client_id, String client_secret, String originalUrl);

    ShortUrlResponseDto generateShortUrl(String client_id, String client_secret, String originalUrl);

    ShortUrlResponseDto updateShortUrl(String client_id, String client_secret, String originalUrl);

    void deleteShortUrl(String shortUrl);

}
