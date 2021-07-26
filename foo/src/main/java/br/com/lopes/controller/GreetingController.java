package br.com.lopes.controller;

import br.com.lopes.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController implements Serializable {


    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){

        return new Greeting(counter.incrementAndGet(),String.format(TEMPLATE,name));
    }
}
