package guru.springframework.didemo.services;

import org.springframework.beans.factory.annotation.Qualifier;

// wylaczamy te 3 annotacje bo robimy plik configuracyjny GreetingServiceConfig
//@Service
//@Profile("es")
//@Primary
public class PrimarySpanishGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimarySpanishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getSpanishGreeting();
    }
}
