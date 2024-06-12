import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Word Counter!");
        System.out.println("Please choose an option:");
        System.out.println("1. Enter text manually");
        System.out.println("2. Provide a file");
        int option = scanner.nextInt();
        scanner.nextLine();
        String text = "";
        switch (option) {
            case 1:
                System.out.println("Enter your text:");
                text = scanner.nextLine();
                break;
            case 2:
                System.out.println("Please provide the file path:");
                String filePath = scanner.nextLine();
                try {
                    text = readFile(filePath);
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                    return;
                }
                break;
            default:
                System.err.println("Invalid option. Please choose 1 or 2.");
                return;
        }

        int totalWords = countWords(text);
        System.out.println("Total words: " + totalWords);

        scanner.close();
    }
    public static int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }
    public static String readFile(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        reader.close();
        return stringBuilder.toString();
    }
}
