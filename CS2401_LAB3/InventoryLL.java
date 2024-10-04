public class InventoryLL {
    private Node head; // this variable is a reference to the first node in the linked list

    // this method is a constructor to initialize the linked list
    public InventoryLL() {
        this.head = null; // start with an empty list (head is null)
    }

    // this method adds a new node to the list
    public void add(Node newNode) {
        if (head == null) {
            head = newNode; // if the list is empty, set the new node as the head
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext(); // traverse to the end of the list
            }
            current.setNext(newNode); // add the new node at the end
        }
    }

    // this method checks if an item is in the inventory
    public boolean inInventory(String itemName) {
        Node current = head;
        while (current != null) {
            if (current.getItemName().equalsIgnoreCase(itemName)) {
                return true; // item found in the inventory
            }
            current = current.getNext(); // move to the next node
        }
        return false; // item not found
    }

    // this method removes an item from the inventory and returns its name
    public String[] removeItem(String itemName) {
        Node current = head;
        Node previous = null;
    
        while (current != null) {
            if (current.getItemName().equalsIgnoreCase(itemName)) {
                if (previous == null) {
                    head = current.getNext(); // removing the head node
                } else {
                    previous.setNext(current.getNext()); // removing a node other than the head
                }
                return new String[] { itemName }; // return the removed item name
            }
            previous = current; // move to the next node
            current = current.getNext();
        }
        return new String[] { "\nItem with the name " + itemName + " not found" }; // item not found
    }
    
    // this method displays all items in the inventory
    public void viewInventory() {
        Node current = head;
        
        if (isInventoryEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            while (current != null) {
                current.getDataInventory(); // print all data of the current item
                current = current.getNext(); // move to the next node
            }
        }
    }

    // this method checks if the inventory is empty
    public boolean isInventoryEmpty() {
        return head == null; // true if empty
    }

    // this method sells an item from the inventory
    public void sellItem(String itemName) {
        if (inInventory(itemName)) {
            removeItem(itemName); // remove the item from inventory
            System.out.println("Sold " + itemName.toUpperCase()); // confirm sale
        } else {
            System.out.println("Item " + itemName.toUpperCase() + " not found in inventory."); // error message
        }
    }

    // this method buys an item and adds it to the inventory if it exists in the shop
    public void buyItem(String itemName, String[][] shopItems) {
        if (isInventoryFull()) {
            System.out.println("Inventory is full!!"); // if inventory size is maxed out
            return;
        }
        if (itemExistsInShop(itemName, shopItems)) {
            if (inInventory(itemName)) {
                System.out.println("\nItem " + itemName.toUpperCase() + " is already in your inventory."); // item already owned
            } else {
                for (int i = 0; i < shopItems.length; i++) {
                    if (shopItems[i][1].equalsIgnoreCase(itemName)) {
                        Node newItem = new Node(shopItems[i][1], shopItems[i][2], shopItems[i][3], shopItems[i][4], shopItems[i][5]);
                        add(newItem); // add the item to the inventory
                        System.out.println("\nBought " + itemName.toUpperCase()); // confirm purchase
                        return;
                    }
                }
            }
        } else {
            System.out.println("\nItem " + itemName + " does not exist in the shop."); // item not found in shop
        }
    }

    // this method checks if an item exists in the shop
    private boolean itemExistsInShop(String itemName, String[][] shopItems) {
        for (int i = 0; i < shopItems.length; i++) {
            if (shopItems[i][1].equalsIgnoreCase(itemName)) { // assuming item name is in column 1
                return true; // item found in shop
            }
        }
        return false; // item not found in shop
    }

    // this method views the stats of an item if it exists in the inventory
    public void viewItemStats(String itemName) {
        Node current = head;
    
        while (current != null) {
            if (current.getItemName().equalsIgnoreCase(itemName)) {
                current.getData(); // print all the data of the item using getData method
                return; // exit once the item is found and data is printed
            }
            current = current.getNext(); // move to the next node
        }
    
        System.out.println("\n" + itemName.toUpperCase() + " is not in your inventory."); // item not found
    }
    
    // this method checks if the inventory is full
    public boolean isInventoryFull() {
        Node current = head;
        int count = 0;

        while (current != null) {
            count++; // count the number of items
            current = current.getNext(); // move to the next node
            if (count >= 5) { // assuming the inventory size limit is 5
                return true; // inventory is full
            }
        }
        return false; // inventory is not full
    }

    public int getInventorySizeCounter() {
        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.getNext(); // move to the next node
        }
        return count; // return the total number of items
    }
}
