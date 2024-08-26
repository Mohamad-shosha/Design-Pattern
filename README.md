# Design Pattern in Java

The **Singleton Pattern** is a design pattern that ensures a class has only one instance and provides a global point of access to that instance. This pattern is particularly useful when exactly one instance of a class is required to coordinate actions across the system or to manage resources efficiently.

## 📝 Table of Contents

- [Overview](#overview)
- [Singleton Implementations](#singleton-implementations)
  - [Eager Initialization](#eager-initialization)
  - [Lazy Initialization](#lazy-initialization)
  - [Thread-Safe Singleton](#thread-safe-singleton)
  - [Double-Checked Locking](#double-checked-locking)
- [Factory Pattern Integration](#factory-pattern-integration)
- [Builder Pattern](#builder-pattern)
- [Usage](#usage)
- [Resources](#resources)
- [License](#license)

## Overview

The Singleton Pattern is used to restrict the instantiation of a class to a single object. This pattern is particularly beneficial for managing shared resources and ensuring a consistent state across the application. The Singleton Pattern can be implemented in various ways, including eager initialization, lazy initialization, thread-safe singleton, and double-checked locking.

### Key Concepts

1. **Single Instance**: Guarantees that only one instance of the class is created and managed.
2. **Global Access Point**: Provides a global point of access to the singleton instance.
3. **Controlled Instantiation**: Manages the instantiation process internally to prevent multiple instances.

### Benefits

- **Resource Management**: Efficiently manages resources by limiting the class to a single instance.
- **Consistency**: Ensures a consistent state by using a single instance throughout the application.
- **Global Access**: Simplifies access to the instance through a global method.
- **Loosely Coupled Components**: Reduces coupling by allowing components to interact with the singleton through an interface rather than specific implementations.

## Singleton Implementations

### Eager Initialization

Eager initialization creates the singleton instance when the class is loaded. This approach ensures that the instance is available when needed but may use resources unnecessarily if the instance is not used.

### Lazy Initialization

Lazy initialization creates the singleton instance only when it is first needed. This approach is more resource-efficient but requires careful handling to avoid issues with concurrent access.

### Thread-Safe Singleton

Ensures that the instance creation process is thread-safe by synchronizing the access method. This prevents multiple threads from creating multiple instances simultaneously.

### Double-Checked Locking

Double-Checked Locking is an optimization technique for lazy initialization that reduces the overhead of synchronization. It involves checking if the instance is null before and after acquiring a lock, which improves performance compared to synchronized methods.

- **First Check**: Check if the instance is null before entering synchronized block to avoid unnecessary locking.
- **Synchronized Block**: If the instance is null, enter a synchronized block to ensure only one thread can create the instance.
- **Second Check**: Check if the instance is still null inside the synchronized block to handle race conditions.

## Factory Pattern Integration

To effectively use the Singleton Pattern within a Factory Pattern context, follow these guidelines:

1. **Define the `Couch` Interface**: This interface should include common methods that all concrete couch types will implement, ensuring consistent interaction with different types of couches.

2. **Implement Concrete Classes**: Create specific implementations of the `Couch` interface, such as `FootballCouch`, `BaseballCouch`, and `BasketballCouch`. Each class will provide its own version of the methods defined in the `Couch` interface.

3. **Create a Singleton Factory**: Implement a factory class (`CouchFactory`) that follows the Singleton Pattern. This ensures that only one instance of the factory exists:
   - **Private Constructor**: The factory’s constructor should be private to prevent direct instantiation.
   - **Static Inner Class**: Use a static inner class to hold the singleton instance, which allows for lazy initialization and ensures thread safety.
   - **Global Access Point**: Provide a static method to access the singleton instance of the factory. This method will be used to create instances of the different `Couch` types.

By integrating the Singleton Pattern with the Factory Pattern, you ensure that there is a single, consistent point of access for creating `Couch` objects while managing resource usage efficiently and maintaining application consistency.

## Builder Pattern

The **Builder Pattern** is a design pattern used to construct complex objects step-by-step. It allows for the creation of an object in a controlled manner, separating the construction of the object from its representation. This pattern is especially useful when an object needs to be constructed with multiple optional components or configurations.

### Key Concepts

1. **Step-by-Step Construction**: Breaks down the construction process into manageable steps.
2. **Immutability**: Often used to create immutable objects, ensuring that once an object is constructed, it cannot be modified.
3. **Complex Object Creation**: Simplifies the creation of objects with many parameters or complex configurations.

### Benefits

- **Readable Code**: Makes the code more readable and maintainable by separating the construction logic from the object itself.
- **Flexibility**: Allows for the creation of different representations of an object.
- **Controlled Construction**: Provides control over the construction process, ensuring that the object is built correctly and consistently.

## Usage

To use any of the Singleton or Builder patterns provided in this project:

- **Singleton Pattern**: Retrieve the singleton instance through the appropriate method provided by each implementation to ensure a single instance of the class is used.
- **Builder Pattern**: Utilize the builder to create instances of complex objects in a step-by-step manner.

## Resources

- [Singleton Pattern - Wikipedia](https://en.wikipedia.org/wiki/Singleton_pattern)
- [Effective Java - Item 2: Consider implementing a Singleton pattern](https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997)
- [Builder Pattern - Wikipedia](https://en.wikipedia.org/wiki/Builder_pattern)
- [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)

