package PharamacyManagementSystem;

import java.util.*;

public class Customer {
    private String name;
    private String contact;
    private List<Prescription> prescriptions;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
        this.prescriptions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void displayCustomerDetails() {
        System.out.println("Customer: " + name + ", Contact: " + contact);
        System.out.println("Prescriptions:");
        for (Prescription prescription : prescriptions) {
            prescription.displayPrescription();
        }
    }
}