package PharamacyManagementSystem;

public class SalesandBilling {

	    private Medicine medicine;
	    private int quantitySold;
	    private double salePrice;

	    public SalesandBilling(Medicine medicine, int quantitySold, double salePrice) 
	    {
	        this.medicine = medicine;
	        this.quantitySold = quantitySold;
	        this.salePrice = salePrice;
	    }

	    public double calculateTotal() {
	        return quantitySold * salePrice;
	    }

	    public void generateReceipt() {
	        System.out.println("Sale Receipt: ");
	        System.out.println("Medicine: " + medicine.getName());
	        System.out.println("Quantity Sold: " + quantitySold);
	        System.out.println("Total Price: " + calculateTotal());
	    }
	}