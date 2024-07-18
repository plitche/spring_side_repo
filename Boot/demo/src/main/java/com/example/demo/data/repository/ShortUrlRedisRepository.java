package com.example.demo.data.repository;

import com.example.demo.data.dto.ShortUrlResponseDto;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDto, String> {

}
