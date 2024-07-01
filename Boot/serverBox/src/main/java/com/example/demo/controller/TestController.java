package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/plitche")
    public String getTest1() {
        LOGGER.info("getTest1 호출!");
        return "Hello. Plitche!";
    }

    @GetMapping("/name")
    public String getTest2(@RequestParam String name) {
        LOGGER.info("getTest2 호출!");
        return "Hello. " + name + "!";
    }

    @GetMapping("/path-variable/{name}")
    public String getTest3(@PathVariable String name) {
        LOGGER.info("getTest3 호출!");
        return "Hello. " + name + "!";
    }

    @PostMapping("/member")
    public ResponseEntity<MemberDTO> getTest4(
            @RequestBody MemberDTO memberDTO,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        LOGGER.info("getTest4 호출!");



        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }

    @PostMapping("/add-header")
    public ResponseEntity<MemberDTO> getTest5(@RequestHeader("plitche") String header, @RequestBody MemberDTO memberDTO) {
        LOGGER.info("getTest5 호출!");
        LOGGER.info("header 값 : {}", header);

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }
}
