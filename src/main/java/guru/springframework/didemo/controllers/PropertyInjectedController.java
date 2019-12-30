package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyInjectedController {

//    @Autowired
//    public GreetingServiceImpl greetingService;   //tutaj mamy zmienna typu konkretnej klasy a nie interfejsu dlatego samo dziala i nie potrzeba qualifiera

    //problem:
    //Description:
    //
    //Field greetingService in guru.springframework.didemo.controllers.PropertyInjectedController required a single bean, but 3 were found:
    //	- constructorGreetingService: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\ConstructorGreetingService.class]
    //	- getterGreetingService: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\GetterGreetingService.class]
    //	- greetingServiceImpl: defined in file [D:\git\di-demo\target\classes\guru\springframework\didemo\services\GreetingServiceImpl.class]
//    @Autowired
//    @Qualifier("greetingServiceImpl")
//    public GreetingService greetingService;

    //a TERAZ CZARY MARY!!!!! - jak uzyjemy nazwy zmiennej ktora odpowiada IDEALNIE nazwie klasy serwisowej (nazwie beana) (ten bean rozszerza ten typ interfacu do ktorego go przypisujemy)
    //to przez refleksje spring potrafi sobie to polaczyc i nie trzeba robic qualifajerow!!!!!!!!
    //jest to SKROT MYSLOWY i ktos moze nie rozumiec co sie dzieje wiec qualifiry sa lepsze pod katem czytania kodu
    @Autowired
//    @Qualifier("greetingServiceImpl")
    //jesli wykomentujemy qulifier to mimo ze reflksja pojdzie do GreetingServiceImpl to i tak na wierzchu bedzie serwis z @Primary i to to zostanie wyswietlone
    public GreetingService greetingServiceImpl;

    public String sayHello() {
        return greetingServiceImpl.sayGreeting();
    }

}
