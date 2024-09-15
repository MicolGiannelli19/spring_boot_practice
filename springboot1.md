# Introduction to Spring Boot

## Inversion of Control
"Instead of the programmer deciding the flow of application this is handed over to the spring frame work"
"In dependancy injeciton spring instanciates the object for us"

In simple terms **A bean is an instance of a class that is managed by the spring container**
- some annotations make beans ???
- 
WHAT IS A SPRING CONTAINER?
The spring container creates objects and manages
The Container uses Dependency Injection(DI) to manage the components that make up the application. 
It gets the information about the objects from a configuration file(XML) or Java Code or Java Annotations and Java POJO class.

## Annotations in Java
Annotations in Java methods provide metadata and information to a Java program. In Spring Boot, annotations are widely used to configure and manage the behavior of classes, methods, and fields.

- **Note**: Method declarations MUST have a return type.

## Service Layer in Spring Boot
The service layer is responsible for the business logic of the application. It works in coordination with the controller to process incoming requests.

- Look up MVC (Model-View-Controller) architecture.
- A controller is typically responsible for handling incoming HTTP requests, processing them (often with the help of services), and returning a response.

- **Reminder**: The keyword `final` indicates a constant.

## Dependency Injection
I’m still trying to understand some concepts related to dependency injection.

- I looked at the car engine example, where the dependency (e.g., `Engine`) is passed into the constructor so that `Car` is not tightly coupled to `Engine`.

### What is a Spring Bean?
A Spring Bean is an object that is managed by the Spring IoC (Inversion of Control) container. In the Spring Framework, the term "bean" refers to an object that is instantiated, assembled, and managed by Spring. Beans are core building blocks in a Spring application.

- The container is responsible for the bean lifecycle, including creation, dependency injection, initialization, and destruction.

## Spring Data JPA
<Introduction to Spring Data JPA>

The next section will cover the integration of Spring Boot with Spring Data JPA, a library used for handling database interactions.

## Records in Java
Records are a special kind of class introduced in Java to hold immutable data.

## Working with JSON in Java
Jackson is a popular library used to serialize and deserialize JSON objects in Java.

# Equals Method
### 1. equals() Method
The `equals()` method determines if two objects are meaningfully equivalent. By default, it compares object references (i.e., whether the two references point to the same object in memory). This behavior can be overridden to compare the state or content of objects.

Example:

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


get a better understanding of how microservices work 

# Generic Rest API notes
We will now structure  REST api
note: GET, POST, PUT, DELETE
?? what is this diffrence between patch and put 
