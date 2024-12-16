# Library Management System

## Overview

The **Library Management System** is a Java-based application designed to manage a library's core functionalities. It includes features for user and staff creation, book reservations, book management, fine management, and loan processing. The system allows searching books by their title or identification number and ensures seamless operation for both users and administrators.

To ensure maintainability and scalability, the system incorporates **design patterns**:

- **Singleton**: Ensures that certain classes (e.g., `BancoUsuarios`) have only one instance, centralizing user and system data management.
- **Proxy**: Provides controlled access to sensitive or restricted operations, improving security and modularity.
- **Factory**: Simplifies the creation of librarian objects using the `BibliotecarioFactory` class, adhering to the principle of abstraction.

These patterns contribute to cleaner, more maintainable code while promoting good object-oriented design practices.


---

## Features

1. **User and Staff Management**
   - Create and manage **users** and **librarians** in the system.
   - Support for user-specific features (e.g., borrowing books).

2. **Book Management**
   - Add new books to the library catalog.
   - Search for books by **name** or **book ID**.

3. **Book Reservation and Loan**
   - Reserve books for users.
   - Process book loans and manage due dates.

4. **Fine Management**
   - Calculate and track fines for overdue books.

5. **Utility Classes**
   - Logging system for operations.
   - Helper utilities for smoother operations.

---

## Class Structure

| **Class**                   | **Description**                                                                 |
|-----------------------------|---------------------------------------------------------------------------------|
| `BancoUsuarios.java`        | Handles storage and management of library users.                                |
| `Bibliotecario.java`        | Represents a librarian with privileges to manage the system.                   |
| `BibliotecarioFactory.java` | Factory class to create librarian instances.                                   |
| `Cadastro.java`             | Handles user registration and information.                                     |
| `Catalogo.java`             | Manages the library catalog, including book addition and search functionalities.|
| `EmprestimoLivro.java`      | Manages book loans, including start and end of borrowing periods.              |
| `EnumDisponibilidade.java`  | Enum for tracking book availability status.                                    |
| `EnumGeneros.java`          | Enum for classifying books by genre.                                           |
| `GerenciamentoReserva.java` | Handles the management of book reservations.                                   |
| `GerenciarEmprestimo.java`  | Oversees loan management processes.                                            |
| `Livro.java`                | Represents a book entity with relevant attributes.                             |
| `Logger.java`               | Logs system activities for monitoring and debugging.                           |
| `Login.java`                | Manages user authentication and login functionality.                          |
| `Multa.java`                | Calculates and tracks fines for overdue books.                                 |
| `Principal.java`            | Main class to execute and initialize the library system.                       |
| `Proxy.java`                | Implements a proxy for secure access to restricted operations.                 |
| `Reserva.java`              | Represents a book reservation.                                                 |
| `ReservaRecibo.java`        | Generates receipts for book reservations.                                      |
| `Titulo.java`               | Handles book title-related functionalities.                                    |
| `Usuario.java`              | Represents a library user.                                                     |
| `UsuarioBiblioteca.java`    | Extends user functionalities specific to library operations.                   |
| `Utilidade.java`            | Utility class for helper methods.                                              |

---

## How to Run

1. **Clone the Repository**
   ```bash
   git clone https://github.com/PedroMilani04/BibliotecaJava.git
   cd library-management-system

2. **Compile the Code Use javac to compile all Java files**
   ```bash
   javac *.java


1. **Run the Application Execute the Principal class**
   ```bash
   java Principal

