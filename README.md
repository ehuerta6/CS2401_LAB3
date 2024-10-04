---

# Skibidi Shop Inventory Management System

## Overview
The **Skibidi Shop Inventory Management System** is a Java-based console application that allows users to interact with an in-game shop, view their inventory, buy and sell items, and check item statistics. The project reads item data from a CSV file and manages the inventory using a linked list data structure.

## Features
- **View Shop**: Displays available items from the shop.
- **View Inventory**: Displays items currently in the user's inventory.
- **Buy Item**: Allows the user to purchase an item from the shop and add it to their inventory.
- **Sell Item**: Allows the user to sell an item from their inventory.
- **View Item Stats**: Displays detailed information about a specific item in the user's inventory.
- **Inventory Management**: Implements linked list operations to manage the items in the player's inventory.
  
## Inventory Restrictions
- Inventory size is limited to 5 items.
- Users cannot purchase items already in their inventory.
- Shop data is read from a CSV file (`itemList.csv`) and loaded at the start of the program.

## Files
- **`Lab3_EmiHuerta.java`**: The main class responsible for running the application and providing the menu-driven interface.
- **`InventoryLL.java`**: Implements a linked list to manage the inventory items.
- **`Node.java`**: Represents an individual item in the inventory, storing data such as item name, description, and stats.
- **`itemList.csv`**: Contains the list of items available for purchase in the shop (loaded when the program starts).

## How to Run
1. Clone the repository and navigate to the project directory.
2. Make sure you have `itemList.csv` in the same directory as the `.java` files.
3. Compile and run the Java program:
    ```bash
    javac Lab3_EmiHuerta.java InventoryLL.java Node.java
    java Lab3_EmiHuerta
    ```
4. Interact with the shop through the console to buy, sell, and view items.

## CSV File Format
The CSV file (`itemList.csv`) should have the following structure:

| ID | Item Name | Type | Rarity | Price | Description |
|----|-----------|------|--------|-------|-------------|
| 1  | Sword     | Melee| Rare   | 150   | A sharp blade|

Ensure the CSV file follows this structure for proper functionality.

## Requirements
- Java 8 or higher

## Future Enhancements
- Expand the inventory size.
- Add a saving/loading feature for persistent inventories.
- Implement more detailed shop categories and sorting options.

## License
This project is open-source and available under the [MIT License](LICENSE).

---
