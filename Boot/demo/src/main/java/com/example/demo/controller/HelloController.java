package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
@RestController
    - Spring Framework 4버전부터 사용가능한 어노테이션
    - @Controller에 @ResponseBody가 결합된 어노테이션
    - 컨트롤러 클래스 하위 메소드에 @ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송할 수 있음
    - View를 거치지 않고 HTTP ResponseBody에 직접 Return값을 담아 보내게 됨

@RequestMapping
    - MVC의 핸들러 매핑(Handler Mapping)을 위해서 DefaultAnnotationHandlerMapping을 사용
    - DefaultAnnotationHandlerMapping 매핑정보로 @RequestMapping 어노테이션을 활용
    - 클래스와 메소드의 RequestMapping을 통해 URL을 매핑하여 경로를 설정하여 해당 메소드에서 처리
    - GET, POST, DELETE, PUT, PATCH
*/

@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("log-test")
    public void logTest() {
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");
    }

}
