public static void displayShop(String[][] shop) {
    // Define column widths for each column (adjust these values to fit your data)
    int nameWidth = 32;
    int rarityWidth = 17;
    int abilityWidth = 82;
    int hpWidth = 8;
    int costWidth = 7;
    
    System.out.println();
    // Print the top border
    System.out.println("+" + "-".repeat(nameWidth) + "+" + "-".repeat(rarityWidth) + "+" 
                         + "-".repeat(abilityWidth) + "+" + "-".repeat(hpWidth) + "+" + "-".repeat(costWidth) + "+");

    // Print the header row
    System.out.printf("| %-30s | %-15s | %-80s | %-5s | %-5s |%n", 
                      "Name", "Rarity", "Magical Abilities", "HP", "Cost");

    // Print the separator after the header
    System.out.println("+" + "-".repeat(nameWidth) + "+" + "-".repeat(rarityWidth) + "+" 
                         + "-".repeat(abilityWidth) + "+" + "-".repeat(hpWidth) + "+" + "-".repeat(costWidth) + "+");

    // Loop through the 2D array and print each row
    for (int i = 0; i < shop.length; i++) {
        if(shop[i][1] == null){
            i++;
        }else {  // Ensure the shop row is not null
            // Create a Node object for the current item
            Node currentNode = new Node(shop[i][1], shop[i][2], shop[i][3], shop[i][4], shop[i][5]);
            
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