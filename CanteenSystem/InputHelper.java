import java.util.Scanner;

public class InputHelper {
    private Scanner scanner = new Scanner(System.in);

    // Reads one line. If the input has ended, the program stops politely.
    public String readText(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            System.out.println("\nInput ended. Goodbye.");
            System.exit(0);
        }
        return scanner.nextLine().trim();
    }

    // Keeps asking until the user types something that is not blank
    public String readName(String prompt) {
        String text = readText(prompt);
        while (text.isEmpty()) {
            System.out.println("Input cannot be blank. Try again.");
            text = readText(prompt);
        }
        return text;
    }

    // Keeps asking until the user types a number above zero
    public double readAmount(String prompt) {
        while (true) {
            try {
                double amount = Double.parseDouble(readText(prompt));
                if (amount > 0 && amount <= 1000000000) {
                    return amount;
                }
                System.out.println("Enter a number above 0 and up to 1,000,000,000.");
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number. Try again.");
            }
        }
    }

    // Keeps asking until the user types a whole number from min to max
    public int readChoice(String prompt, int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(readText(prompt));
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Enter a number from " + min + " to " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid whole number. Try again.");
            }
        }
    }

    // Keeps asking until the user types Y or N
    public boolean readYesNo(String prompt) {
        while (true) {
            String answer = readText(prompt).toLowerCase();
            if (answer.equals("y")) return true;
            if (answer.equals("n")) return false;
            System.out.println("Please type Y or N.");
        }
    }
}
