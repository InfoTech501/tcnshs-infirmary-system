package com.medicine.inventory.application;

import com.medicine.inventory.application.app.facade.item.MedicineFacade;
import com.medicine.inventory.application.app.facade.item.impl.MedicineFacadeImpl;
import com.medicine.inventory.application.model.item.Item;

import java.util.List;
import java.util.Scanner;

public class MedicineInventoryApplication {

    public static void main(String[] args) {

        MedicineFacade medicineFacade = new MedicineFacadeImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Medicine Inventory system...");
        System.out.println("Please enter your selection:");
        System.out.println("1. Medicine inventory Application");
        System.out.println("2. Item Maintenance");
        System.out.println("3. Return");
        System.out.println("Press other keys to exit.");
        System.out.print("Enter you choice: ");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                int choice;
            {
                System.out.println("Medicine Inventory Item Name Maintenance");
                System.out.println("Please select an option:");
                System.out.println("1. Display all item Names");
                System.out.println("2. Search for an item Name");
                System.out.println("3. Add an item");
                System.out.println("4. Update an item");
                System.out.println("5. Delete an item");
                System.out.print("Enter you choice: ");
                choice = sc.nextInt();

            }
            switch (choice) {
                case 1: {
                    List<Item> items =  medicineFacade .getAllItems();

                    if (items.isEmpty()) {
                        System.out.println("The list of Item Name is empty.");
                    } else {
                        System.out.println("List of Item Name:");
                        for (Item item : items) {
                            System.out.println(item.getMedicine_Id());
                        }
                    }
                    break;
                }
                case 2: {

                    sc.nextLine();

                    System.out.println("Enter the Medicine Name of the item to search: ");
                    int medicine_Id = sc.nextInt();
                    Item item = medicineFacade.getItemByMedicine_Id(medicine_Id);

                    if (item != null) {
                        System.out.println("Item found: " + item.getMedicine_Id() + " " + item.getMedicine_Name());
                    } else {
                        System.out.println("No item found.");
                    }
                    break;
                }
                case 3: {
                    sc.nextLine();

                    System.out.println("Adding an item");
                    System.out.println("Enter item Medicine_Id: ");
                    String medicine_Id = sc.nextLine();
                    System.out.println("Enter item Medicine_Name: ");
                    String medicine_Name = sc.nextLine();
                    System.out.println("Enter item Brand: ");
                    String brand = sc.nextLine();
                    System.out.println("Enter item dosage: ");
                    String dosage = sc.nextLine();
                    System.out.println("Enter item Med_Description: ");
                    String med_Description = sc.nextLine();
                    System.out.println("Enter item Quantity_Available: ");
                    int quantity_Available = sc.nextInt();
                    System.out.println("Enter item Quantity_Used: ");
                    int quantity_Used = sc.nextInt();
                    System.out.println("Enter number of Med_Total_Usage: ");
                    int med_Total_Usage = sc.nextInt();
                    System.out.println("Enter item Expiration Date ");
                    int expiration_Date = sc.nextInt();


                    Item item = new Item();
                    item.setMedicine_Id(medicine_Id);
                    item.setMedicine_Name(medicine_Name);
                    item.setBrand(brand);
                    item.setDosage(dosage);
                    item.setMed_Description(med_Description);
                    item.setQuantity_Available(quantity_Available);
                    item.setQuantity_Used(quantity_Used);
                    item.setMed_Total_Usage(med_Total_Usage);
                    item.setExpiration_Date(expiration_Date);

                    boolean result;
                    if (medicineFacade.addItem(item)) result = true;
                    else result = false;
                    if(result) {
                        System.out.println("Item successfully added.");
                    } else {
                        System.out.println("Item cannot be added.");
                    }

                    break;


                }

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
            System.out.println("Quitting the application...");
        }

    }
}