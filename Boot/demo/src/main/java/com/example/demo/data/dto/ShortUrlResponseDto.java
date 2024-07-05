package com.example.demo.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShortUrlResponseDto {

    private String orgUrl;
    private String shortUrl;

}
