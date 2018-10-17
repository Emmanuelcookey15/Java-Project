import java.util.Random;
import java.util.Scanner;

public class OddssAndEvens {
    public static void main(String[] args) {
        System.out.println("Let's play a game called \"Odds and Evens\"");
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name?: ");
        String name = input.nextLine();
        System.out.print("Hi " + name + ", which do you choose? (O)dd or (E)vens?: ");
        String choice = input.next();

        while (choice.length() != 1) {
            System.out.print("Hi " + name + ", which do you choose? (O)dd or (E)vens?: ");
            choice = input.next();
        }

        while (!choice.equalsIgnoreCase("O") && !choice.equalsIgnoreCase("E")) {
            System.out.print("Hi " + name + ", which do you choose? (O)dd or (E)vens?: ");
            choice = input.next();
        }

        if (choice.equalsIgnoreCase("O")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        }
        else if (choice.equalsIgnoreCase("E")) {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        System.out.println("-------------------------------------------");
        System.out.print("How many \"fingers\" do you put out? ");
        int fingers = input.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " fingers");
        System.out.println("-------------------------------------------");
        int sum = fingers + computer;
        System.out.println("userNumber + computerNumber = " + sum);

        if (sum % 2 == 0) {
            System.out.println(sum + " is...Even");
            if (choice.equalsIgnoreCase("E")) {
                System.out.println("That means " + name + " wins");
            }
            else {
                System.out.println("That means computer wins");
            }
        }
        else {
            System.out.println(sum + " is...Odd");
            if (choice.equalsIgnoreCase("O")) {
                System.out.println("That means " + name + " wins");
            }
            else {
                System.out.println("That means computer wins");
            }
        }
        System.out.println("-------------------------------------------");

    }

    public static void playGame(int x) {


    }
}
