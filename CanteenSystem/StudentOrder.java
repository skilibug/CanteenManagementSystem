public class StudentOrder extends Order {
    private static final double DISCOUNT_RATE = 0.05;   // P = B + 5 = 0 + 5 = 5%

    public StudentOrder(String id, String customerName, double itemsTotal) throws InvalidOrderException {
        super(id, customerName, itemsTotal);
    }

    // 5% discount only when the student's order is above 20,000
    @Override
    public double getDiscount() {
        if (getItemsTotal() > 20000) {
            return getItemsTotal() * DISCOUNT_RATE;
        }
        return 0;
    }

    @Override
    public double calculateCharge() {
        return getItemsTotal() - getDiscount();
    }
}
