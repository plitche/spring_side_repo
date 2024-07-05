package com.example.demo.data.repository;

import com.example.demo.data.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, String> {

    ShortUrlEntity findByUrl(String url);

    ShortUrlEntity findByOrgUrl(String originalUrl);
}
