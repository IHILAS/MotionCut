import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        
        try ( 
                Scanner scanner = new Scanner(System.in)) {
            
            String[] questions = {
                "What is the capital of France?",
                "Who wrote 'To Kill a Mockingbird'?",
                "What is the largest planet in our solar system?",
                "What is the chemical symbol for water?",
                "Which language is used for Android app development?",
                "Which year did the Titanic sink?",
                "Who painted the Mona Lisa?",
                "What is the smallest prime number?",
                "What is the powerhouse of the cell?",
                "Which country is known as the Land of the Rising Sun?"
            };  
            String[][] options = {
                {"A. London", "B. Berlin", "C. Paris", "D. Madrid"},
                {"A. Harper Lee", "B. Mark Twain", "C. J.K. Rowling", "D. Ernest Hemingway"},
                {"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
                {"A. H2O", "B. O2", "C. CO2", "D. NaCl"},
                {"A. Swift", "B. Kotlin", "C. JavaScript", "D. Python"},
                {"A. 1912", "B. 1905", "C. 1898", "D. 1915"},
                {"A. Vincent van Gogh", "B. Pablo Picasso", "C. Leonardo da Vinci", "D. Michelangelo"},
                {"A. 0", "B. 1", "C. 2", "D. 3"},
                {"A. Nucleus", "B. Mitochondria", "C. Ribosome", "D. Chloroplast"},
                {"A. China", "B. Japan", "C. South Korea", "D. India"}
            };  
            char[] answers = {'C', 'A', 'C', 'A', 'B', 'A', 'C', 'C', 'B', 'B'};
            
            int score = 0;
            
            for (int i = 0; i < questions.length; i++) {
                
                System.out.println((i + 1) + ". " + questions[i]);
                
                for (String option : options[i]) {
                    System.out.println(option);
                }
                
                
                System.out.print("Your answer: ");
                char userAnswer = scanner.next().toUpperCase().charAt(0);
                
               
                if (userAnswer == answers[i]) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was " + answers[i] + ".\n");
                }
            }   
            System.out.println("You scored " + score + " out of " + questions.length);
            
        }
    }
}
