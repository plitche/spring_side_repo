package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
@RequestMapping("/api/v1/get-api")
public class HelloController {

    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variabl") String val) {
        return val;
    }

    @GetMapping(value = "request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        // param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n");

        return sb.toString();
    }

    @GetMapping(value = "request3")
    public String getRequestParam3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}
