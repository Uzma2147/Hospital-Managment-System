package PharamacyManagementSystem;

import java.util.*;

	public class InventoryManager {
	    List<Medicine> inventory;

	    public InventoryManager() {
	        inventory = new ArrayList<>();
	    }

	    public void addMedicine(Medicine medicine) {
	        inventory.add(medicine);
	    }

	    public void updateMedicineStock(String name, int stock) {
	        for (Medicine medicine : inventory) {
	            if (medicine.getName().equalsIgnoreCase(name)) {
	                medicine.setStock(stock);
	                return;
	            }
	        }
	        System.out.println("Medicine not found!");
	    }

	    public void deleteMedicine(String name) {
	        inventory.removeIf(medicine -> medicine.getName().equalsIgnoreCase(name));
	    }

	    public void displayInventory() {
	        for (Medicine medicine : inventory) {
	            medicine.displayMedicine();
	        }
	    }

	    public void checkAlerts() {
	        for (Medicine medicine : inventory) {
	            if (medicine.getStock() < 10) {
	                System.out.println("Low stock for " + medicine.getName());
	            }
	            if (medicine.isExpired()) {
	                System.out.println("Expired: " + medicine.getName());
	            }
	        }
	    }
	}