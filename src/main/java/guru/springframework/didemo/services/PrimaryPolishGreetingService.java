package guru.springframework.didemo.services;

import org.springframework.beans.factory.annotation.Qualifier;

// wylaczamy te 3 annotacje bo robimy plik configuracyjny GreetingServiceConfig
//@Service
//@Profile({"pl", "default"})
//@Primary
public class PrimaryPolishGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimaryPolishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getPolishGreeting();
    }
}
