# Food Delivery App (LLD Project)

A simple Java-based Low-Level Design (LLD) project simulating a food delivery application. This project demonstrates core OOP concepts, design patterns (Factory, Singleton, Strategy), and modular code organization.

## Features

- **User Management:** Create users with unique IDs, names, and addresses.
- **Restaurant Management:** Add and search restaurants by location, each with a customizable menu.
- **Cart Functionality:** Users can select a restaurant, add menu items to their cart, and view the cart.
- **Order Placement:** Supports both immediate ("Now") and scheduled orders, with delivery or pickup options.
- **Payment Strategies:** Pay using UPI or Credit Card (Strategy Pattern).
- **Order Notification:** Notifies users upon successful order placement.
- **Extensible Design:** Easily add new payment methods, order types, or restaurant features.


## Design Patterns Used

- **Factory Pattern:** For creating different types of orders ([`factories/OrderFactory`](src/factories/OrderFactory.java), [`factories/NowOrderFactory`](src/factories/NowOrderFactory.java), [`factories/ScheduledOrderFactory`](src/factories/ScheduledOrderFactory.java))
- **Singleton Pattern:** For managing restaurants and orders ([`managers/RestaurantManager`](src/managers/RestaurantManager.java), [`managers/OrderManager`](src/managers/OrderManager.java))
- **Strategy Pattern:** For payment methods ([`strategies/PaymentStrategy`](src/strategies/PaymentStrategy.java), [`strategies/UpiPaymentStrategy`](src/strategies/UpiPaymentStrategy.java), [`strategies/CreditCardPaymentStrategy`](src/strategies/CreditCardPaymentStrategy.java))

## How to Run

1. **Clone the repository** and open in [Visual Studio Code](https://code.visualstudio.com/).
2. **Build the project** (VS Code will use the `src` folder as the source and `bin` as the output, as set in [.vscode/settings.json](.vscode/settings.json)).
3. **Run the main class:**  
   - `App.java` ([`src/App.java`](src/App.java)) contains the entry point.
   - You can run it using the VS Code Java extension or from the terminal:
     ```sh
     javac -d bin src/*.java src/*/*.java
     java -cp bin App
     ```

## Example Usage

- The main method in [`App.java`](src/App.java) demonstrates:
  - Creating a user
  - Searching for restaurants by location
  - Selecting a restaurant and adding items to the cart
  - Placing an order with UPI payment
  - Processing payment and receiving a notification

## Extending the Project

- **Add new payment methods:** Implement the [`PaymentStrategy`](src/strategies/PaymentStrategy.java) interface.
- **Add new order types:** Extend the [`Order`](src/models/Order.java) class and update factories.
- **Enhance restaurant features:** Modify the [`Restaurant`](src/models/Restaurant.java) class.

## License

This project is for educational purposes.

---

*Developed as a Low-Level Design (LLD)


# Food Delivery App (LLD Project)

![UML Diagram](https://github.com/PankajKumarAgrawal1729/Food-Delivery-App-LLD-Project-/blob/main/UML.png)
