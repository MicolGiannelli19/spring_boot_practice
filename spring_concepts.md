# Dependency injection 

Dependency ijection is a specielized version of **Inversion of Control** whereby objects define their dependencies **only through constroctor agrguments or aguments to a factory method**
The objective is to create systems that are more loosely coupled therefore more easily testable and maintainable. 

We will need to recreate the car object with a new Yokohama dependency. 
But when using dependency injection (DI), we can change the Wheels at runtime (because dependencies can be injected at runtime rather than at compile time).

    constructor injection: the dependencies are provided through a class constructor.
    setter injection: the client exposes a setter method that the injector uses to inject the dependency.
    interface injection: the dependency provides an injector method that will inject the dependency into any client passed to it. Clients must implement an interface that exposes a setter method that accepts the dependency.

?? but if the dependency 