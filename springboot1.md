We will now structure  REST api 

note: GET, POST, PUT, DELETE

The decorator looking things are called annotations in Java methods, they serve to provide information to a java program

note that mehtod declarations MUST have a return type


We will now write the service layer, the service layer is responsible for the buisness logic

look up  MVC (Model-View-Controller) architecture
A controller is typically responsible for handling incoming HTTP requests, processing them (often with the help of services), and returning a response.

reminder the keyword `final` indicates a constant

not sure about a lot of the concepts related to dependacy injections 

?? what is a sping bean ??
A Spring Bean is an object that is managed by the Spring IoC (Inversion of Control) container. In the Spring Framework, the term "bean" refers to an object that is instantiated, assembled, and otherwise managed by Spring. Beans are the core building blocks of a Spring application, and the container is responsible for their lifecycle, including their creation, dependency injection, initialization, and eventual destruction.

For the next section of the course we will look into the spring Data JPA


the language introduced records, which are a special kind of class designed to hold immutable data

A library called jackson is used to deal with json in java 

# Equals method

1. equals() Method

- The equals() method is used to determine if two objects are meaningfully equivalent.
- By default, the equals() method compares object references, meaning two objects are considered equal only if they are the same instance.
- This behavior can be overridden to compare the content or state of objects rather than their memory addresses

Here is an example 
```java
public class Person {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }
}
```
In this example the equals method compares `name` and  `age` to determine if two objects are equal
### Note that when overwriting equals it is essential to overwrite hashcode so that two objects that are considered equal have the same Hash code
### Concept of Hashcodes
```java
public class Person {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```
# Databases
JPA (jakarta persistence is a specification that allows the managment of relational databases)

# Docker Volumes 

- Docker volumes are ways of persisting the data generated and used by the docker container
- They allow you to decouple the lifecycle of the data from the life cycle of the container
- This allows you to maintain the data across container re-starts, upgrades and re-deployment
- Named volumes are managed by Docker and can be referenced by a name. These volumes are stored in a specific location on the host filesystem (/var/lib/docker/volumes/ by default)
- `host volumes` (also known as bind mounts) these map a specific directory in the container
- Volumes typically perform better I/O operations then bind mounts because docker optimizes this

# Other docker things I am reminding myself of 

- Side note `docker prune` helps you remove containers, volumes, networks that are not currently being used freeing up disk space
- The `Dockerfile` defines the steps to create an image
- while `docker-compose.yml` orchestrates the running of multiple containers based on either pre-built images (like postgres:14.1 in your example) or images that are built from a Dockerfile.


# Notes about using psql.app rather then a docker container
Less Isolated Environment:

- Your PostgreSQL instance runs directly on your host system,
which means it shares the system environment.
This can lead to issues with version conflicts if you need to run different versions of PostgreSQL for different projects.

# Dependency Injection 

- Dependency injection is a design pattern that allows us to **Remove Hardcoded dependencies** and make our systems more loosely coupled



- **Problem:** MyApplication class is responsible to initialize the email service and then use it.

- This leads to hard-coded dependency. If we want to switch to some other advanced email service in the future, it will require code changes in MyApplication class. This makes our application hard to extend and if email service is used in multiple classes then that would be even harder.

### Dependency Injection in java requires at least the following:

1. Service components should be designed with base class or interface. It’s better to prefer interfaces or abstract classes that would define contract for the services.
    This clearly explains the advantages of haivng an interface: 
    
    1. **Flexibility:** By using interfaces, you can easily swap out one implementation for another without changing the dependent classes. For example, you could have multiple implementations of PaymentService (e.g., CreditCardPaymentService, PaypalPaymentService).
    2. **Decoupling:** The consumer classes (which use the service) do not depend on the concrete implementation of the service, only on the interface. This makes your code loosely coupled and more modular.
    3. **Testability:** Using interfaces makes unit testing easier because you can mock or stub the service's behavior without relying on the actual implementation.

2. Consumer classes should be written in terms of service interface.

3. Injector classes that will initialize the services and then the consumer classes.
    NOTE: injetor classes are usally part of frameworks such as spring

# Microservices in Java ... Or how spring boot relates to micro Services


? What is the diffrence between an interface and an abstract class in Java