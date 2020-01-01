package guru.springframework.didemo;

import guru.springframework.didemo.controllers.ConstructorInjectedController;
import guru.springframework.didemo.controllers.MyController;
import guru.springframework.didemo.controllers.PropertyInjectedController;
import guru.springframework.didemo.controllers.SetterInjectedController;
import guru.springframework.didemo.examplebeans.FakeDataSource;
import guru.springframework.didemo.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"guru.springframework"}) //to jest startowe miejsc i bedzie szukal dalej w glab, schodzil nizej
//problem: po przeniesieniu katalogu z servisami o jeden wyzej nie mozna bylo zlapac serwsow, rozwiazaniem jest skanowanie komponetow @ComponentScan
//Parameter 0 of constructor in guru.springframework.didemo.controllers.ConstructorInjectedController required a bean of type 'guru.springframework.didemo.services.GreetingService' that could not be found.
//
//The injection point has the following annotations:
//	- @org.springframework.beans.factory.annotation.Qualifier(value=constructorGreetingService)
//
//
//Action:
//
//Consider defining a bean of type 'guru.springframework.didemo.services.GreetingService' in your configuration.
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

//        controller.hello();

        System.out.println(controller.hello());

        System.out.println("PropertyInjectedController: " + ctx.getBean(PropertyInjectedController.class).sayHello());
        //Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'guru.springframework.didemo.controllers.PropertyInjectedController' available
        // jest wtedy jesli nie zrobimy adnotacji na klasie ze ma byc @Component

        //Exception in thread "main" java.lang.NullPointerException
        // jest wtedy kiedy ZROBIMY adnotacje na klasie ze ma byc @Component
        //zeby to naprawic musimy do pola dodac adnotacje @Autowired, musimy wstrzyknac

        System.out.println("SetterInjectedController: " + ctx.getBean(SetterInjectedController.class).sayHello());

        System.out.println("ConstructorInjectedController: " + ctx.getBean(ConstructorInjectedController.class).sayHello());

        System.out.println("==================================");

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUser());

        FakeJmsBroker fakeJmsBroker = ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUsername());
    }

}
