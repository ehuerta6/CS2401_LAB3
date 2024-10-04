/* CS2401
 * Files needed to complete Lab 3:
 * 	- Node.java
 * 	- LinkedList.java
 *  - Lab3_Lastname.java --- the java file of your program. 
 */

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
 
 public class Lab3_EmiHuerta {
 
     public static String[][] eScanItems(String eFileName) {
         // this method creates a String array to store lines from the CSV file
         String[][] eItemsArray = null;
 
         try {
             // this method initializes the scanner to read from the CSV file
             Scanner eScanner = new Scanner(new File(eFileName));
             int eRowCount = 0;
 
             // skip the first line (header)
             if (eScanner.hasNextLine()) {
                 eScanner.nextLine();
             }
 
             // this method first counts the number of lines to initialize the 2D array
             while (eScanner.hasNextLine()) {
                 eRowCount++;
                 eScanner.nextLine();
             }
             eScanner.close();
 
             // this method initializes the 2D array with the row count and a fixed column size
             eItemsArray = new String[eRowCount][6]; // CSV has 6 columns
 
             // this method reopens the file to read the contents
             eScanner = new Scanner(new File(eFileName));
 
             // skip the first line (header)
             if (eScanner.hasNextLine()) {
                 eScanner.nextLine();
             }
 
             int eCurrentRow = 0;
 
             // this method reads each line and splits it by commas
             while (eScanner.hasNextLine()) {
                 String eLine = eScanner.nextLine();
                 // this method splits the line into columns and stores them in the array
                 String[] eColumns = eLine.split(",");
                 for (int eColumnIndex = 0; eColumnIndex < eColumns.length; eColumnIndex++) {
                     eItemsArray[eCurrentRow][eColumnIndex] = eColumns[eColumnIndex];
                 }
                 eCurrentRow++;
             }
             eScanner.close();
         } catch (FileNotFoundException eException) {
             eException.printStackTrace();
         }
 
         return eItemsArray; // return the populated 2D array
     }
 
     public static void main(String[] args) {
         // this method initializes an InventoryLL object to manage inventory operations
         InventoryLL eInventory = new InventoryLL();
         Scanner eScanner = new Scanner(System.in);
 
         String[][] itemsArray = eScanItems("itemList.csv"); // call method to scan items from CSV
 
         printShopheader(); // call method to print the shop header
         while (true) {
             // this method prints the shop header and menu options
             System.out.println("\nPlease select one of the following options:");
             System.out.println("1) View shop");
             System.out.println("2) View inventory");
             System.out.println("3) Sell item");
             System.out.println("4) Buy item");
             System.out.println("5) View item stats");
             System.out.println("6) Exit");
 
             // this method reads the user's choice from the console
             int eUserChoice = eScanner.nextInt();
 
             // this method handles user actions based on their menu choice
             switch (eUserChoice) {
                 case 1:
                     // this method displays the available items in the shop
                     System.out.println("\nViewing shop items...");
                     displayShop(itemsArray); // call method to display the shop
                     break;
 
                 case 2:
                     // this method displays the user's current inventory
                     System.out.println("\nViewing your inventory...");
                     System.out.println("You have |" + eInventory.getInventorySizeCounter() + " Items| in your Inventory.");
                     eInventory.viewInventory(); // call method to view inventory
                     break;
 
                 case 3:
                     // this method handles selling an item from the user's inventory
                     if (!eInventory.isInventoryEmpty()) {
                         System.out.println("\nSelling an item...");
                         System.out.println("You have |" + eInventory.getInventorySizeCounter() + " Items| in your Inventory.");
                         eInventory.viewInventory(); // call method to view inventory
 
                         System.out.print("Enter the name of the item you want to sell: ");
                         eScanner.nextLine(); // clear the buffer
                         String itemNameToSell = eScanner.nextLine(); // read item name to sell
 
                         eInventory.sellItem(itemNameToSell); // call method to sell the item
                     } else {
                         System.out.println("\nYour inventory is empty. There are no items to sell.");
                     }
                     break;
 
                 case 4:
                     if (eInventory.isInventoryFull()) {
                         System.out.println("\nInventory is full!!");
                     } else {
                         // this method handles buying an item from the shop
                         System.out.println("\nBuying an item...");
                         System.out.print("Enter the name of the item you want to buy: ");
                         eScanner.nextLine(); // clear the buffer
                         String itemNameToBuy = eScanner.nextLine(); // read item name to buy
                         eInventory.buyItem(itemNameToBuy, itemsArray); // call method to buy the item
                     }
                     break;
 
                 case 5:
                     // this method displays the statistics of a specific item
                     if (!eInventory.isInventoryEmpty()) {
                         System.out.println("\nViewing item stats...");
                         System.out.print("Enter the name of the item you want to see stats: ");
                         eScanner.nextLine(); // clear the buffer
                         String itemToViewStats = eScanner.nextLine(); // read item name to view stats
                         eInventory.viewItemStats(itemToViewStats); // call method to view item stats
                     } else {
                         System.out.println("\nYour inventory is empty. There are no items to examine.");
                     }
                     break;
 
                 case 6:
                     // this method exits the application
                     System.out.println("\nExiting the shop. Thank you!");
                     eScanner.close(); // close the scanner
                     System.exit(0); // exit the program
                     break;
 
                 default:
                     // this method handles invalid menu choices
                     System.out.println("\nInvalid choice. Please select a valid option.");
                     break;
             }
         }
     }
 
     // method to print shop header
     public static void printShopheader() {
         System.out.println("");
         System.out.println("_______________________________________________");
         System.out.println("__        __   _                ");
         System.out.println("\\ \\      / /__| | ___ ___  _ __ ___   ___ ");
         System.out.println(" \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\");
         System.out.println("  \\ V  V /  __/ | (_| (_) | | | | | |  __/");
         System.out.println("   \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|");
         System.out.println("_______________________________________________");
         System.out.println("");
         System.out.println("           Welcome to Skibidi Shop             ");
     }
 
     /*
      * 
      * 
      * DO NOT CHANGE, DISPLAYS SHOP
      * 
      * 
      * 
      */
 
     public static void displayShop(String[][] shop) {
         // Define column widths for each column (adjust these values to fit your data)
         int nameWidth = 32;
         int rarityWidth = 18;
         int abilityWidth = 82;
         int hpWidth = 9;
         int costWidth = 9;
 
         System.out.println();
         // Print the top border
         System.out.println("+" + "-".repeat(nameWidth) + "+" + "-".repeat(rarityWidth) + "+" 
                              + "-".repeat(abilityWidth) + "+" + "-".repeat(hpWidth) + "+" + "-".repeat(costWidth) + "+");
 
         // Print the header row
         System.out.printf("| %-30s | %-16s | %-80s | %-7s | %-7s |%n", 
                           "Name", "Rarity", "Magical Abilities", "HP", "Cost");
 
         // Print the separator after the header
         System.out.println("+" + "-".repeat(nameWidth) + "+" + "-".repeat(rarityWidth) + "+" 
                              + "-".repeat(abilityWidth) + "+" + "-".repeat(hpWidth) + "+" + "-".repeat(costWidth) + "+");
 
         // Loop through the 2D array and print each row
         for (int i = 0; i < shop.length; i++) {
             if(shop[i][1] == null){
                 i++;
             } else {  // Ensure the shop row is not null
                 // Create a Node object for the current item
                 Node currentNode = new Node(shop[i][1], shop[i][2], shop[i][3], shop[i][4], shop[i][5]);
 
                 // Print item details using the Node object
                 System.out.printf("| %-30s | %-25s | %-80s | %-7s | %-7s |%n", 
                                   currentNode.getItemName(), // Name
                                   currentNode.getRarityColored(), // Use getRarityColored to fetch colored rarity
                                   currentNode.getAbilities(), // Magical Abilities
                                   currentNode.getHP(), // HP
                                   currentNode.getCost() // Cost
                 );
             }
         }
 
         // Print the bottom border
         System.out.println("+" + "-".repeat(nameWidth) + "+" + "-".repeat(rarityWidth) + "+" 
                              + "-".repeat(abilityWidth) + "+" + "-".repeat(hpWidth) + "+" + "-".repeat(costWidth) + "+");
     }
 }
 