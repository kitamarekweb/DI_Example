package guru.springframework.didemo.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

    //problem:
    //Could not autowire. There is more than one bean of 'GreetingService' type.
    //Beans:
    //constructorGreetingService   (ConstructorGreetingService.java)
    //getterGreetingService   (GetterGreetingService.java)
    //greetingServiceImpl   (GreetingServiceImpl.java)
    //primaryGreetingService   (PrimaryGreetingService.java)
    //Rozwiazanie:
    //dajemy anotacje @Primary na klasie serwisowej PrimaryGreetingService

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String hello() {
        System.out.println("Hello! ");

        return greetingService.sayGreeting();
    }
}
