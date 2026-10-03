public class Main {
    public static void main(String[] args) {
        System.out.println("School Canteen Charging System");
        System.out.println("Name: Ojara Kefas Okot");
        System.out.println("Reg No: VU-BIT-2511-1201-DAY");

        InputHelper input = new InputHelper();
        OrderManager manager = new OrderManager();

        while (true) {
            System.out.println("\n1. Add student order");
            System.out.println("2. Add staff order");
            System.out.println("3. List sorted report");
            System.out.println("4. Find an order");
            System.out.println("5. Remove an order");
            System.out.println("6. Show summary");
            System.out.println("7. Exit");
            int choice = input.readChoice("Choose an option (1-7): ", 1, 7);

            if (choice == 1 || choice == 2) {
                String name = input.readName("Customer name: ");
                double total = input.readAmount("Total of items (UGX): ");
                String id = manager.nextId();
                try {
                    Order order;
                    if (choice == 1) {
                        order = new StudentOrder(id, name, total);
                    } else {
                        order = new StaffOrder(id, name, total);
                    }
                    manager.addOrder(order);
                    System.out.println("Order added.");
                    System.out.println(order);
                } catch (InvalidOrderException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (choice == 3) {
                if (manager.count() == 0) {
                    System.out.println("No orders recorded yet.");
                } else {
                    System.out.println("--- Report (sorted by customer name) ---");
                    for (Order o : manager.getSortedReport()) {
                        System.out.println(o);
                    }
                    System.out.printf("Total charges: UGX %,.0f%n", manager.getTotalCharges());
                }

            } else if (choice == 4) {
                Order order = manager.findOrder(input.readName("Enter order ID: "));
                if (order == null) {
                    System.out.println("No order found with that ID.");
                } else {
                    System.out.println(order);
                }

            } else if (choice == 5) {
                Order order = manager.findOrder(input.readName("Enter order ID to remove: "));
                if (order == null) {
                    System.out.println("No order found with that ID.");
                } else {
                    System.out.println(order);
                    if (input.readYesNo("Remove this order? (Y/N): ")) {
                        manager.removeOrder(order);
                        System.out.println("Order removed.");
                    } else {
                        System.out.println("Removal cancelled.");
                    }
                }

            } else if (choice == 6) {
                System.out.println("--- Summary ---");
                System.out.println("Orders recorded: " + manager.count());
                System.out.printf("Total charges: UGX %,.0f%n", manager.getTotalCharges());
                System.out.printf("Total discount given: UGX %,.0f%n", manager.getTotalDiscount());

            } else {
                System.out.println("Goodbye.");
                break;
            }
        }
    }
}
