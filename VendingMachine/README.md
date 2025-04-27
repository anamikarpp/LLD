🚀 Vending Machine - Low Level Design (LLD)
This project demonstrates the Low-Level Design of a Vending Machine System in Java using Object-Oriented Programming (OOPS) principles and Design Patterns.

📋 Features
Insert Money

Select Item

Dispense Item

Return Change

Cancel Transaction

Show Available Inventory

Handle Insufficient Funds

Singleton-based Inventory Management

State-driven Machine Behavior

🛠️ Design Patterns & OOPS Concepts Used
State Design Pattern: Different machine behaviors based on state (IdleState, MoneyInsertedState, DispensingState).

Singleton Design Pattern: Single instance of Inventory shared across the system.

Encapsulation: Properly encapsulated models like Item.

Abstraction: Interface State abstracts common operations.

Polymorphism: Different states override common behaviors (insertMoney, selectItem, etc.).

Inheritance: States implement the common State interface.

📂 Folder Structure
less
Copy
Edit
src/
├── main/
│   └── Main.java  // Entry point
├── model/
│   └── Item.java  // Item model class
├── service/
│   ├── Inventory.java  // Inventory Singleton
│   └── VendingMachine.java  // Vending Machine logic
├── state/
│   ├── IdleState.java  // Idle state class
│   ├── MoneyInsertedState.java  // Money inserted state class
│   ├── DispensingState.java  // Dispensing state class
│   └── State.java  // Interface for all states
📜 How to Run
Clone the repository

Open it in your favorite IDE (IntelliJ, Eclipse, VS Code)

Run Main.java to start the simulation!

🧠 What I Learned
Real-world system design using OOPS

Practical usage of State Pattern and Singleton Pattern

Transitioning between states based on user actions

Clean code practices: abstraction, modularization, separation of concerns

📈 Future Improvements
Add a Coin Enum to manage different coin denominations

Handle Out of Stock cases properly

Improve user interface (e.g., console or web UI)

Integrate database for persistent inventory

Implement multi-currency support

Add admin mode for restocking items
