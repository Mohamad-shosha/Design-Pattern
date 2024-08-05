# Singleton Pattern in Java

The **Singleton Pattern** is a design pattern that ensures a class has only one instance and provides a global point of access to that instance. This pattern is particularly useful when exactly one instance of a class is required to coordinate actions across the system or to manage resources efficiently.

## 📝 Table of Contents

- [Overview](#overview)
- [Singleton Implementations](#singleton-implementations)
  - [Eager Initialization](#eager-initialization)
  - [Lazy Initialization](#lazy-initialization)
  - [Thread-Safe Singleton](#thread-safe-singleton)
  - [Double-Checked Locking](#double-checked-locking)
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

## Usage

To use any of the Singleton implementations provided in this project, retrieve the singleton instance through the appropriate method provided by each implementation. This pattern ensures that only one instance of the class is created and used throughout the application.

## Resources

* [Singleton Pattern - Wikipedia](https://en.wikipedia.org/wiki/Singleton_pattern)
* [Effective Java - Item 2: Consider implementing a Singleton pattern](https://www.amazon.com/Effective-Java-Joshua-Bloch/dp/0134685997)


