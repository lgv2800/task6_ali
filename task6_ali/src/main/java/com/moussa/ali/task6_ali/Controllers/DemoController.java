package com.moussa.ali.task6_ali.Controllers;

import com.moussa.ali.task6_ali.Models.Greeting;
import com.moussa.ali.task6_ali.Models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController {

    // Building a RESTful Web Service - https://spring.io/guides/gs/rest-service/
    // Setting Up Swagger 2 with a Spring REST API - https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/person")
    public Person person(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "age", defaultValue = "20") int age) {
        return new Person(age, name);
    }

}
