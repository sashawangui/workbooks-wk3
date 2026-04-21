import java.util.Scanner;

public class FamousQuotes {
    static String[] quotes = {
                "\"The only way to do great work is to love what you do.\" - Steve Jobs",
                "\"Life is what happens when you're busy making other plans.\" - John Lennon",
                "\"The future belongs to those who believe in the beauty of their dreams.\" - Eleanor Roosevelt",
                "\"Be the change you wish to see in the world.\" - Mahatma Gandhi",
                "\"The only limit to our realization of tomorrow is our doubts of today.\" - Franklin D. Roosevelt",
                "\"Success is not final, failure is not fatal: it is the courage to continue that counts.\" - Winston Churchill",
                "\"The purpose of our lives is to be happy.\" - Dalai Lama",
                "\"Get busy living or get busy dying.\" - Stephen King",
                "\"You only live once, but if you do it right, once is enough.\" - Mae West",
                "\"If you want to live a happy life, tie it to a goal, not to people or things.\" - Albert Einstein"
    };
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean anotherOne = true;

        //display quote using the method that returns a quote
        while(anotherOne){
            try{
                String desiredQuote = returnQuote(input);
                System.out.println("\n" + desiredQuote +"\n");

                //ask if they want another one
                System.out.println("Do you want another quote? Yes / No");

                String response = input.next().trim().toLowerCase();

                if (response.equals("yes")){
                    anotherOne = true;
                    System.out.println();
                }else {
                    anotherOne = false;
                    System.out.println("Ok.");
                }

            } catch (Exception e) {
                System.out.println("Error" + e.getMessage().toString() + ". Please try again...");
            }
        }
        input.close();
}

    public static String returnQuote(Scanner input) {
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Select a quote by number (1-10)");
            System.out.println("2. Get a random quote");
            System.out.print("Enter your choice (1 or 2): ");

            int userChoice = input.nextInt();

            try {
                if (userChoice == 1) {
                    System.out.print("Select a quote between 1 and 10: ");
                    int quoteNum = input.nextInt();
                    return quoteNum + ". " + quotes[quoteNum - 1];
                }
                else if (userChoice == 2) {
                    int randomQuoteNum = (int) (Math.random() * quotes.length);
                    return (randomQuoteNum + 1) + ". " + quotes[randomQuoteNum];
                }}
                catch (Exception e) {
                    System.out.println("Error: " + e.toString());
                    input.nextLine();
                }
            }
        }
    }
