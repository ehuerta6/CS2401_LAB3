public class Node {
    private String eItemName; // stores the item name
    private String eRarity; // stores the item rarity
    private String eAbilities; // stores the item abilities
    private String eHP; // stores the item HP
    private String eCost; // stores the item cost
    private Node eNext; // reference to the next node in the linked list

    // colors for rarities
    String blue = "\u001B[34m";   // for rare rarity
    String red = "\u001B[31m";    // for legendary rarity
    String green = "\u001B[32m";  // for uncommon rarity
    String purple = "\u001B[35m"; // for very rare rarity
    String cyan = "\u001B[36m";   // for common rarity
    String reset = "\u001B[0m";   // reset to default color

    // this method is a default constructor
    public Node() {
        // no initialization
    }

    // this method is a constructor to initialize a node with item details
    public Node(String eItemName, String eRarity, String eAbilities, String eHP, String eCost) {
        this.eItemName = eItemName; // assign item name
        this.eRarity = eRarity; // assign item rarity
        this.eAbilities = eAbilities; // assign item abilities
        this.eHP = eHP; // assign item HP
        this.eCost = eCost; // assign item cost
        this.eNext = null; // initialize next node as null
    }

    // this method returns the item name
    public String getItemName() {
        return eItemName; // return the item name
    }

    // this method returns the item rarity
    public String getRarity() {
        return eRarity; // return the item rarity
    }

    // this method returns the item abilities
    public String getAbilities() {
        return eAbilities; // return the item abilities
    }

    // this method returns the item HP
    public String getHP() {
        return eHP; // return the item HP
    }

    // this method returns the item cost
    public String getCost() {
        return eCost; // return the item cost
    }

    // this method returns the next node in the linked list
    public Node getNext() {
        return eNext; // return the next node
    }

    // this method sets the next node in the linked list
    public void setNext(Node eNext) {
        this.eNext = eNext; // set the next node
    }

    // this method prints all details of the item
    public void getData() {
        System.out.println("-----"); // separator line
        System.out.println("Item Name: " + eItemName); // print item name
        System.out.println("Rarity: " + getRarityColored()); // use the colored rarity method
        System.out.println("Abilities: " + eAbilities); // print abilities
        System.out.println("HP: " + eHP); // print HP
        System.out.println("Cost: " + eCost); // print cost
        System.out.println("-----"); // separator line
    }

    // this method prints the inventory item in a brief format
    public void getDataInventory() {
        // print item summary with colored rarity
        System.out.println(eItemName + " [Rarity: " + getRarityColored() + " (HP: " + eHP + ")]"); // print brief item info
    }

    // this method returns the colored rarity string
    public String getRarityColored() {
        String rarityColor; // variable to store the colored rarity
        if (eRarity.equals("Legendary")) {
            rarityColor = red + eRarity + reset; // set color for legendary
        } else if (eRarity.equals("Rare")) {
            rarityColor = blue + eRarity + reset; // set color for rare
        } else if (eRarity.equals("Uncommon")) {
            rarityColor = green + eRarity + reset; // set color for uncommon
        } else if (eRarity.equals("Very Rare")) {
            rarityColor = purple + eRarity + reset; // set color for very rare
        } else {
            rarityColor = cyan + eRarity + reset; // default color for common rarity
        }
        return rarityColor; // return colored rarity
    }
}
