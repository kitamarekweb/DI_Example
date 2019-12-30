package guru.springframework.didemo.services;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepositoryImpl implements GreetingRepository {
    @Override
    public String getEnglishGreeting() {
        return "Hello - ENGLISH";
    }

    @Override
    public String getPolishGreeting() {
        return "Dobry - POSLKI";
    }

    @Override
    public String getSpanishGreeting() {
        return "Hola - SPAIN";
    }
}
