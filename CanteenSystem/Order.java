public abstract class Order implements Chargeable {
    private String id;
    private String customerName;
    private double itemsTotal;

    public Order(String id, String customerName, double itemsTotal) throws InvalidOrderException {
        this.id = id;
        setCustomerName(customerName);
        setItemsTotal(itemsTotal);
    }

    public String getId() { return id; }
    public String getCustomerName() { return customerName; }
    public double getItemsTotal() { return itemsTotal; }

    public void setCustomerName(String customerName) throws InvalidOrderException {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new InvalidOrderException("Customer name cannot be blank.");
        }
        this.customerName = customerName.trim();
    }

    public void setItemsTotal(double itemsTotal) throws InvalidOrderException {
        if (itemsTotal <= 0) {
            throw new InvalidOrderException("Total of items must be greater than zero.");
        }
        this.itemsTotal = itemsTotal;
    }

    // Most orders get no discount, so the default is 0. StudentOrder overrides this.
    public double getDiscount() {
        return 0;
    }

    @Override
    public abstract double calculateCharge();

    @Override
    public String toString() {
        return String.format("%-11s %-13s %-15s Items: %,9.0f  Discount: %,7.0f  Charge: %,9.0f",
                id, getClass().getSimpleName(), customerName, itemsTotal, getDiscount(), calculateCharge());
    }
}
