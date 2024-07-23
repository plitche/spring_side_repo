package com.example.demo.controller;

import com.example.demo.common.annotation.FieldAnnotation;
import com.example.demo.common.annotation.MethodAnnotation;
import com.example.demo.common.annotation.TypeAnnotation;
import com.example.demo.common.valid.TempDto;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@TypeAnnotation(name = "Hello?", value = "World")
public class HelloController {

    @FieldAnnotation(name = "returnValue", value = "Bye World!")
    public String returnValue = "Hello World!";

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/hello1")
    @MethodAnnotation(name = "Hello1", value = "World1")
    public String hello1() throws NoSuchMethodException {
        Method method = this.getClass().getMethod("hello1");
        Annotation[] annotations = method.getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof MethodAnnotation) {
                MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;
                return methodAnnotation.name() + ", " + methodAnnotation.value();
            }
        }

        return "Hello World!";
    }

    @RequestMapping("/hello2")
    public String hello2(@RequestBody @Valid TempDto dto) {
        return "Valid value : " + dto.getValue();
    }

}
