package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/pist-api")
public class PostController {

    @PostMapping(value = "/default")
    public String postMethod() {
        return "Hello World!";
    }

    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postDate) {
        StringBuilder sb = new StringBuilder();

        postDate.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

}
