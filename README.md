# Singleton Pattern in Java

The **Singleton Pattern** is a design pattern that ensures a class has only one instance and provides a global point of access to that instance. This project explores different implementations of the Singleton Pattern in Java, highlighting various approaches to achieve a single instance of a class.

## 📝 Table of Contents

- [Overview](#overview)
- [Singleton Implementations](#singleton-implementations)
  - [Eager Initialization](#eager-initialization)
  - [Lazy Initialization](#lazy-initialization)
  - [Thread-Safe Singleton](#thread-safe-singleton)
- [Usage](#usage)
- [Resources](#resources)
- [License](#license)

## Overview

The Singleton Pattern is used to restrict the instantiation of a class to a single object. This pattern is particularly useful when exactly one instance of a class is needed to coordinate actions across the system. In this project, we explore several methods for implementing the Singleton Pattern:

1. **Eager Initialization**: The instance is created at the time of class loading. This approach is straightforward and thread-safe but might lead to resource wastage if the instance is not used.

2. **Lazy Initialization**: The instance is created only when it is needed. This method conserves resources but requires careful handling to ensure thread safety.

3. **Thread-Safe Singleton**: This approach ensures that the instance creation is thread-safe, preventing multiple threads from creating multiple instances. Techniques such as synchronized methods and double-checked locking are used to achieve thread safety.

## Singleton Implementations

### Eager Initialization

Eager initialization creates the singleton instance when the class is loaded. This approach is simple and ensures that the instance is available when needed, but it may use resources unnecessarily if the instance is not used.

### Lazy Initialization

Lazy initialization defers the creation of the singleton instance until it is required. This approach can be more resource-efficient, but it must be handled carefully to avoid issues with concurrent access.

### Thread-Safe Singleton

To ensure thread safety in the lazy initialization approach, synchronization techniques are employed. This guarantees that only one thread can create the instance at a time, preventing issues with multiple threads creating multiple instances.

## Usage

To use any of the Singleton implementations provided in this project, retrieve the singleton instance through the appropriate method provided by each implementation. The Singleton Pattern ensures that only one instance of the class is created, regardless of how many times the retrieval method is called.

## Resources

* [Singleton Pattern - Wikipedia](https://en.wikipedia.org/wiki/Singleton_pattern)
* [Effective Java - Item 2: Consider implementing a Singleton pattern](https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997)

