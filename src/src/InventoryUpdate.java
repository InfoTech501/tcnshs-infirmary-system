import java.util.Scanner;

public class InventoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Medicine ID: ");
        int medicineId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Medicine Name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter new Brand: ");
        String newBrand = scanner.nextLine();

        System.out.print("Enter new Dosage: ");
        String newDosage = scanner.nextLine();

        System.out.print("Enter new Stock Quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Expiration Date (YYYY-MM-DD HH:MI:SS): ");
        String newExpiry = scanner.nextLine();

        System.out.println("Save changes? (YES/NO)");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            try {
                InventoryUpdateConnection.updateInventory(
                        medicineId, newName, newBrand, newDosage, newQuantity, newExpiry
                );
                System.out.println("Changes are saved.");
            } catch (Exception e) {
                System.out.println("Error updating inventory: " + e.getMessage());
            }
        } else {
            System.out.println("Update cancelled.");
        }

        scanner.close();
    }
}
