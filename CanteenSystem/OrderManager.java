import java.util.ArrayList;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();
    private int counter = 0;

    // Makes IDs like OKO201-001
    public String nextId() {
        counter++;
        return String.format("OKO201-%03d", counter);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    // Returns the order, or null if the ID is not found
    public Order findOrder(String id) {
        for (Order o : orders) {
            if (o.getId().equalsIgnoreCase(id.trim())) {
                return o;
            }
        }
        return null;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public double getTotalCharges() {
        double total = 0;
        for (Order o : orders) {
            total += o.calculateCharge();
        }
        return total;
    }

    public double getTotalDiscount() {
        double total = 0;
        for (Order o : orders) {
            total += o.getDiscount();
        }
        return total;
    }

    // Digit A = 2, so sort by customer name (A to Z)
    public ArrayList<Order> getSortedReport() {
        ArrayList<Order> sorted = new ArrayList<>(orders);
        sorted.sort((a, b) -> a.getCustomerName().compareToIgnoreCase(b.getCustomerName()));
        return sorted;
    }

    public int count() {
        return orders.size();
    }
}
