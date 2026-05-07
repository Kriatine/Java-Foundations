import java.util.Arrays;

public class LabAssignment {

    static int[] inventory = {101, 505, 202};

    public static void main(String[] args) {
        System.out.println("--- START ---");

        System.out.print("Inventory: " + Arrays.toString(inventory));
        System.out.println(" | Total Weight: " + calculateTotalWeight());

        System.out.println("\n--- LOOTING RING (550) ---");

        lootItem(550);

        System.out.print("Inventory: " + Arrays.toString(inventory));
        System.out.println(" | Total Weight: " + calculateTotalWeight());

        System.out.println("\n--- DROPPING SHIELD (202) ---");
        dropItem(202);

        System.out.print("Inventory: " + Arrays.toString(inventory));
        System.out.println(" | Total Weight: " + calculateTotalWeight());

        System.out.println("\n--- DROPPING MISSING ITEM (999) ---");
        dropItem(999);

        System.out.print("Inventory: " + Arrays.toString(inventory));
        System.out.println(" | Total Weight: " + calculateTotalWeight());
    }

    public static void lootItem(int newItemID){
        int[] tempInventory = new int[inventory.length+1];
        for(int i = 0; i < inventory.length; i++)
            tempInventory[i] = inventory[i];
        tempInventory[inventory.length] = newItemID;
        inventory = tempInventory;
    }
    public static void dropItem(int itemToRemove){
        int index = -1;
        for(int i = 0; i < inventory.length; i++) {
            if (inventory[i] == itemToRemove) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            return;
        }
        else{
            int[] tempInventory = new int[inventory.length-1];
            for(int i = 0; i < inventory.length; i++){
                if(i < index)
                    tempInventory[i] = inventory[i];
                else{
                    if(i+1 == inventory.length)
                        break;
                    else
                    tempInventory[i] = inventory[i+1];

            }}
            inventory = tempInventory;
        }
    }
    public static double calculateTotalWeight(){
        double totalWeight = 0;
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i] >= 100 && inventory[i] <= 199)
                totalWeight += 5;
            else if(inventory[i] >= 200 && inventory[i] <= 299)
                totalWeight += 10;
            else
                totalWeight += 1;
        }
        return totalWeight;
    }
}
