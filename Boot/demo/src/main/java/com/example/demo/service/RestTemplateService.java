package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {
    String getPlitce();

    String getName();

    String getName2();

    ResponseEntity<MemberDTO> postDto();

    ResponseEntity<MemberDTO> addHeader();
}
