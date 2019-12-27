package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {

    private GreetingService greetingService;

    // problem - znaleznione 3 takie same beany co robic?:
    // Description:
    //Parameter 0 of constructor in guru.springframework.didemo.controllers.ConstructorInjectedController required a single bean, but 3 were found:
    //	- constructorGreetingService: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\ConstructorGreetingService.class]
    //	- getterGreetingService: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\GetterGreetingService.class]
    //	- greetingServiceImpl: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\GreetingServiceImpl.class]
    // TRZEBA UZYC QULIFAIEROW! 1. usuwamy Autowired! 2. dodajemy adnotacje @Qualifier

//    @Autowired   //ale nie trzeba robic na construktorze @Autowired bo jest dodawany automatycznie od Springa 4.2
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) { //nazwa klasy serwisowej pisana z malej litery
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
