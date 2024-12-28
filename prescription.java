package PharamacyManagementSystem;


	public class Prescription {
	    private String patientName;
	    private Medicine medicine;
	    private int quantity;

	    public Prescription(String patientName, Medicine medicine, int quantity) {
	        this.patientName = patientName;
	        this.medicine = medicine;
	        this.quantity = quantity;
	    }

	    public boolean isValid() {
	        return medicine.getStock() >= quantity; // Valid if stock is enough
	    }
public void displayPrescription() {
System.out.println("Prescription for " + patientName + ": " + medicine.getName() + ", Quantity: " + quantity);
  }
}