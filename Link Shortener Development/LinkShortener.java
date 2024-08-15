import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkShortener {
    private static final Map<String, String> urlMap = new HashMap<>();
    private static final String BASE_URL = "http://short.ly/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Link Shortener ---");
            System.out.println("1. Shorten a URL");
            System.out.println("2. Retrieve original URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = shortenUrl(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                }
                case 2 -> {
                    System.out.print("Enter the shortened URL: ");
                    String shortUrlInput = scanner.nextLine();
                    String originalUrl = retrieveUrl(shortUrlInput);
                    if (originalUrl != null) {
                        System.out.println("Original URL: " + originalUrl);
                    } else {
                        System.out.println("URL not found.");
                    }
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static String shortenUrl(String longUrl) {
        String uniqueId = "id" + urlMap.size();
        String shortUrl = BASE_URL + uniqueId;
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    private static String retrieveUrl(String shortUrl) {
        return urlMap.get(shortUrl);
    }
}
