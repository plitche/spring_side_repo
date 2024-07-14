package com.example.demo.data.repository;

import com.example.demo.data.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, String> {

    ShortUrl findByUrl(String url);

    ShortUrl findByOrgUrl(String originalUrl);
}
