package guru.springframework.services;

import org.springframework.stereotype.Component;

@Component
//@Service
// jak zapomnimy o servicie to mamy takie bledy
//Description: Parameter 0 of constructor in guru.springframework.didemo.controllers.ConstructorInjectedController required a bean of type 'guru.springframework.services.GreetingService' that could not be found.
//Action: Consider defining a bean of type 'guru.springframework.services.GreetingService' in your configuration.
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO_GURUS = "Hello Gurus!! - ORIGINAL";

    @Override
    public String sayGreeting() {
        return HELLO_GURUS;
    }
}
