package com.example.demo.service;

import com.example.demo.data.dto.ShortUrlResponseDto;

public interface ShortUrlService {

    ShortUrlResponseDto generateSHortUrl(String client_id, String client_secret, String originalUrl);

    ShortUrlResponseDto getShortUrl(String client_id, String client_secret, String originalUrl);

    ShortUrlResponseDto updateShortUrl(String client_id, String client_secret, String originalUrl);

    ShortUrlResponseDto deleteByShortUrl(String shortUrl);

    ShortUrlResponseDto deleteByOriginalUrl(String originalUrl);

}
