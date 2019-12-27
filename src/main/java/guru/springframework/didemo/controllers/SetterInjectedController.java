package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

    // problem - znaleznione 3 takie same beany co robic?:
    // Description:
    //Parameter 0 of method setGreetingService in guru.springframework.didemo.controllers.SetterInjectedController required a single bean, but 3 were found:
    //	- constructorGreetingService: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\ConstructorGreetingService.class]
    //	- getterGreetingService: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\GetterGreetingService.class]
    //	- greetingServiceImpl: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\GreetingServiceImpl.class]
    @Autowired
    @Qualifier("getterGreetingService") //qualifajery mozna uzyc przed nazwa metody lub przed nazwa zmiennej w metodzie
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
