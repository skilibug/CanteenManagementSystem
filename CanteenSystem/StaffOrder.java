public class StaffOrder extends Order {

    public StaffOrder(String id, String customerName, double itemsTotal) throws InvalidOrderException {
        super(id, customerName, itemsTotal);
    }

    // Items total plus a 10% service charge
    @Override
    public double calculateCharge() {
        return getItemsTotal() * 1.10;
    }
}
