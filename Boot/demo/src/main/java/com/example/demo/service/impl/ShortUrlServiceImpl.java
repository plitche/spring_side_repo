package com.example.demo.service.impl;

import com.example.demo.data.dao.ShortUrlDAO;
import com.example.demo.data.dto.NaverUriDto;
import com.example.demo.data.dto.ShortUrlResponseDto;
import com.example.demo.data.entity.ShortUrlEntity;
import com.example.demo.service.ShortUrlService;
import java.net.URI;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlServiceImpl.class);

    private final ShortUrlDAO shortUrlDAO;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlDAO shortUrlDAO) {
        this.shortUrlDAO = shortUrlDAO;
    }

    @Override
    public ShortUrlResponseDto generateShortUrl(String client_id, String client_secret, String originalUrl) {
        LOGGER.info("[generateShortUrl] request data : {}", originalUrl);
        ResponseEntity<NaverUriDto> responseEntity = requestShortUrl(client_id, client_secret, originalUrl);

        String orgUrl = responseEntity.getBody().getResult().getOrgUrl();
        String shortUrl = responseEntity.getBody().getResult().getUrl();
        String hash = responseEntity.getBody().getResult().getHash();

        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        shortUrlEntity.setOrgUrl(orgUrl);
        shortUrlEntity.setUrl(shortUrl);
        shortUrlEntity.setHash(hash);

        shortUrlDAO.saveShortUrl(shortUrlEntity);

        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);
        LOGGER.info("[generateShortUrl] Response DTO : {}", shortUrlResponseDto.toString());
        return shortUrlResponseDto;
    }

    @Override
    public ShortUrlResponseDto getShortUrl(String client_id, String client_secret, String originalUrl) {
        LOGGER.info("[getShortUrl] request data : {}", originalUrl);
        ShortUrlEntity getShortUrlEntity = shortUrlDAO.getShortUrl(originalUrl);

        String orgUrl;
        String shortUrl;

        if (getShortUrlEntity == null){
            LOGGER.info("[getShortUrl] No Entity in Database.");
            ResponseEntity<NaverUriDto> responseEntity = requestShortUrl(client_id, client_secret, originalUrl);

            orgUrl = responseEntity.getBody().getResult().getOrgUrl();
            shortUrl = responseEntity.getBody().getResult().getUrl();
        } else {
            orgUrl = getShortUrlEntity.getOrgUrl();
            shortUrl = getShortUrlEntity.getUrl();
        }

        ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);
        LOGGER.info("[getShortUrl] Response DTO : {}", shortUrlResponseDto.toString());
        return shortUrlResponseDto;
    }

    @Override
    public ShortUrlResponseDto updateShortUrl(String client_id, String client_secret, String originalUrl) {
        return null;
    }

    @Override
    public ShortUrlResponseDto deleteByShortUrl(String shortUrl) {
        return null;
    }

    @Override
    public ShortUrlResponseDto deleteByOriginalUrl(String originalUrl) {
        return null;
    }

    private ResponseEntity<NaverUriDto> requestShortUrl(String client_id, String client_secret, String originalUrl) {
        LOGGER.info("[requestShortUrl] client ID : ***, client Secret : ***, original Url : {}", originalUrl);

        URI uri = UriComponentsBuilder
            .fromUriString("https://openapi.naver.com")
            .path("v1/util/shorturl")
            .queryParam("url", originalUrl)
            .encode()
            .build()
            .toUri();

        LOGGER.info("[requestShortUrl] set HTTP Request Header");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id", client_id);
        headers.set("X-Naver-Client-Secret", client_secret);

        HttpEntity<String> entity = new HttpEntity<>("", headers);

        RestTemplate restTemplate = new RestTemplate();

        LOGGER.info("[requestShortUrl] request by restTemplate");
        ResponseEntity<NaverUriDto> responseEntity = restTemplate
            .exchange(uri, HttpMethod.GET, entity, NaverUriDto.class
            );

        LOGGER.info("[requestShortUrl] request has been successfully complete.");
        return responseEntity;
    }
}
