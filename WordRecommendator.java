import java.util.Scanner;
import java.io.*;

public class WordRecommendator {
    public static void main(String[] args) {
        System.out.println("Welcome to the Word Recommendator");

        Scanner scan = new Scanner(System.in);
        TrieWithRobinhood tr = new TrieWithRobinhood();
        System.out.println("Please enter the file name:");

        // Read from file using try-with-resources
        try (Scanner fileScanner = new Scanner(new File(scan.next()))) {
            while (fileScanner.hasNext()) {
                tr.insert(fileScanner.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Please check the filename and try again.");
            System.exit(10);
        }

        // Display menu
        System.out.println("1 -> Find Similar Words");
        System.out.println("2 -> Most Important Words");
        System.out.print("Enter your choice: ");

        // Validate choice input
        if (!scan.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number (1 or 2).");
            scan.close();
            return;
        }

        int choice = scan.nextInt();

        switch (choice) {
            case 1:
            scan.nextLine(); // Consume any leftover newline
            while (true) {
                System.out.println("Enter the number of suggestions and then your word (or type 'exit' to quit):");
        
                String inputLine = scan.nextLine().trim(); // Read the entire input
                if (inputLine.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                }
        
                String[] parts = inputLine.split("\\s+"); // Split input by spaces
        
                if (parts.length != 2) {
                    System.out.println("Invalid input. Enter a number followed by a word.");
                    continue;
                }
        
                try {
                    int numSuggestions = Integer.parseInt(parts[0]); // Convert first part to number
                    String word = parts[1]; // Second part is the word
                    tr.pushRecommendedWordToHeap(numSuggestions, word);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. The first value must be a number.");
                }
            }
            break;
        

            case 2:
                System.out.println("Enter the number of suggestions you want:");

                if (scan.hasNextInt()) {
                    int numSuggestions = scan.nextInt();
                    tr.pushToHeap(numSuggestions);
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
                break;

            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        scan.close();
    }
}
