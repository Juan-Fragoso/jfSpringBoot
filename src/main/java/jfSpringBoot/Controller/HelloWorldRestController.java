package jfSpringBoot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldRestController {

    @GetMapping({"/hello", "/hl"})
    public String HelloWorld() {
        System.out.println("solicitud");
        return "Hello";
    }
}
