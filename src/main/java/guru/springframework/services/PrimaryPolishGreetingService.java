package guru.springframework.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"pl", "default"})
@Primary
public class PrimaryPolishGreetingService implements GreetingService {

    private GreetingService greetingService;

    public PrimaryPolishGreetingService(@Qualifier("getterGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public String sayGreeting() {
        return greetingService.sayGreeting();
    }
}
