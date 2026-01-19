# Thunder Delivery System

This project is a functional, interactive terminal application designed for a food delivery service. It moves beyond a simple simulation by allowing real-time user input and dynamic data management.

## Project Functionality

### Interactive User Interface

The application features a user-driven menu system that requires manual selection and input, fulfilling the requirement for a functional tool rather than a pre-scripted simulation.

### Dual-Role Management

* **Manager Role**: Managers can access the system to add new food items to existing restaurant menus during runtime, updating the application state immediately.
* **Customer Role**: Customers can create a personal profile, browse available restaurants, and build a multi-item order cart.

### Data Persistence

To ensure records are maintained after the program closes, the system generates a detailed CSV file (receipt_2026.csv) for every processed order.

## Object-Oriented Programming (OOP) Implementation

### Inheritance

The project utilizes inheritance through the Customer class, which extends the User class to reuse core identity attributes like name and phone number.

### Polymorphism

Polymorphism is implemented using the PaymentMethod interface, allowing the system to process different types of payments, such as Cash or Credit Card, through a unified method call.

### Encapsulation

The system follows strict encapsulation principles by using private access modifiers for all data fields, ensuring data integrity through public getter and setter methods.

## Logic Verification (JUnit Testing)

The core logic of this application is verified by five distinct JUnit 4 test suites to ensure 100% accuracy:

1. **ThunderTest**: Validates the end-to-end integration of the ordering process.
2. **OrderTest**: Confirms the accuracy of cart calculations and total amounts.
3. **MenuItemTest**: Ensures all food items and their respective prices are initialized correctly.
4. **RestaurantTest**: Verifies that menu displays and item management are functioning as expected.
