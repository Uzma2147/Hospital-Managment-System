package PharamacyManagementSystem;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Managers and Lists
        InventoryManager inventoryManager = new InventoryManager();
        List<SalesandBilling> salesList = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        while (true) {
            System.out.println("\nPharmacy Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer Details");
            System.out.println("3. Add Medicine");
            System.out.println("4. Update Medicine Stock");
            System.out.println("5. Delete Medicine");
            System.out.println("6. Display Inventory");
            System.out.println("7. Create Prescription");
            System.out.println("8. Process Sale");
            System.out.println("9. Generate Sales Receipt");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // Add Customer
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Contact Information: ");
                    String contact = scanner.nextLine();
                    customers.add(new Customer(customerName, contact));
                    System.out.println("Customer added successfully!");
                    break;

                case 2: // View Customer Details
                    System.out.print("Enter Customer Name: ");
                    String searchName = scanner.nextLine();
                    Customer foundCustomer = null;
                    for (Customer c : customers) {
                        if (c.getName().equalsIgnoreCase(searchName)) {
                            foundCustomer = c;
                            break;
                        }
                    }
                    if (foundCustomer != null) {
                        foundCustomer.displayCustomerDetails();
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;

                case 3: // Add Medicine
                    System.out.print("Enter Medicine Name: ");
                    String medName = scanner.nextLine();
                    System.out.print("Enter Stock Quantity: ");
                    int stockQuantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiryDate = scanner.nextLine();
                    inventoryManager.addMedicine(new Medicine(medName, stockQuantity, expiryDate));
                    System.out.println("Medicine added successfully!");
                    break;

                case 4: // Update Medicine Stock
                    System.out.print("Enter Medicine Name: ");
                    String updateMedName = scanner.nextLine();
                    System.out.print("Enter New Stock Quantity: ");
                    int newStockQuantity = Integer.parseInt(scanner.nextLine());
                    inventoryManager.updateMedicineStock(updateMedName, newStockQuantity);
                    System.out.println("Stock updated successfully!");
                    break;

                case 5: // Delete Medicine
                    System.out.print("Enter Medicine Name: ");
                    String deleteMedName = scanner.nextLine();
                    inventoryManager.deleteMedicine(deleteMedName);
                    System.out.println("Medicine deleted successfully!");
                    break;

                case 6: // Display Inventory
                    inventoryManager.displayInventory();
                    break;

                case 7: // Create Prescription
                    System.out.print("Enter Customer Name: ");
                    String custName = scanner.nextLine();
                    Customer prescriptionCustomer = null;
                    for (Customer c : customers) {
                        if (c.getName().equalsIgnoreCase(custName)) {
                            prescriptionCustomer = c;
                            break;}}
                    if (prescriptionCustomer == null) {
                        System.out.println("Customer not found! Please add the customer first.");
                        break;}
                    System.out.print("Enter Medicine Name: ");
                    String presMedName = scanner.nextLine();
                    Medicine prescribedMedicine = null;
                    for (Medicine m : inventoryManager.inventory) {
                        if (m.getName().equalsIgnoreCase(presMedName)) {
                            prescribedMedicine = m;
                            break; }}
                    if (prescribedMedicine == null) {
                        System.out.println("Medicine not found in inventory!");
                        break; }
                    System.out.print("Enter Quantity: ");
                    int presQuantity = Integer.parseInt(scanner.nextLine());
                    Prescription prescription = new Prescription(custName, prescribedMedicine, presQuantity);
                    if (prescription.isValid()) {
                        prescriptionCustomer.addPrescription(prescription);
                        prescribedMedicine.setStock(prescribedMedicine.getStock() - presQuantity);
                        System.out.println("Prescription created successfully!");} 
                    else {
                        System.out.println("Not enough stock to fulfill this prescription.");}
                    break;

                case 8: // Process Sale
                    System.out.print("Enter Medicine Name: ");
                    String saleMedName = scanner.nextLine();
                    System.out.print("Enter Quantity Sold: ");
                    int quantitySold = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Sale Price: ");
                    double salePrice = Double.parseDouble(scanner.nextLine());
                    SalesandBilling sale = new SalesandBilling(new Medicine(saleMedName,0,"2024-12-31"),quantitySold,salePrice);
                    salesList.add(sale);
                    System.out.println("Sale recorded successfully!");
                    break;

                case 9: // Generate Sales Receipt
                    for (SalesandBilling s : salesList) {
                        s.generateReceipt();
                    }
                    break;

                case 10: // Exit
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    }}}}