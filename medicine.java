package PharamacyManagementSystem;
	    public class Medicine {
	    private String name;
	    private int stock;
	    private String expiryDate;

	    public Medicine(String name, int stock, String expiryDate) {
	        this.name = name;
	        this.stock = stock;
	        this.expiryDate = expiryDate;
	    }
	    public String getName() {
	        return name;}
	    public int getStock() {
	        return stock; }
	    public String getExpiryDate() {
	        return expiryDate; }
	    public void setStock(int stock) {
	        this.stock = stock; }
	    public boolean isExpired() {
	        // Simple check for expiration date 
	        return expiryDate.compareTo("2024-12-31") < 0; }// replace with current date comparison
	    public void displayMedicine() {
	        System.out.println("Medicine: " + name + ", Stock: " + stock + ", Expiry Date: " + expiryDate);
	    }
	}