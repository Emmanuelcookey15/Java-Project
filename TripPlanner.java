import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args) {
//        intro();
//        System.out.println();
        budget();
        System.out.println();
        time();
        System.out.println();
        distance();

    }

    public static void intro() {
        System.out.println("Welcome to Vacation Planner!");
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + " where are you travelling to? ");
        name = input.nextLine();
        System.out.println("Great! " + name + " sounds like a great trip");
    }

    public static void budget() {
        System.out.print("How many days are they going to spend in their destination? ");
        Scanner input = new Scanner(System.in);
        int days = input.nextInt();
        System.out.print("What is their total budget for the trip in USD? ");
        int cash = input.nextInt();
        System.out.print("What is the currency symbol for their destination? ");
        input.nextLine();
        String currency = input.nextLine();
        System.out.print("How many " + currency + " in 1 USD? ");
        double value = input.nextDouble();
        System.out.println("");
        System.out.print("If you are travelling for" + days + " days is the same as ");
        System.out.println(days*24 + " hours or " + days*1440);
        System.out.print("If you are going to spend $" + cash + "that means per day ");
        System.out.println("you acnspend up to $" + (double) (cash/days) + " USD");
        System.out.print("Your toal budget in "+currency+ " is"+ cash*value+" ");
        System.out.println(currency+", which per day is " + (double) (cash*value/days) + currency);
    }

    public static void time() {
        int midnight = 0;
        int noon = 12;
        System.out.print("What is the time difference, in hours, between your home and your destination?");
        Scanner input = new Scanner(System.in);
        int time = input.nextInt();
        System.out.print("That means that when it is midnight at home it wil be " + (midnight+time) + ":00 in ");
        System.out.println("your travel destination and when it is noon at home it will be " + (noon+time)+ ":00");

    }

    public static void distance() {
        System.out.print("What is the square area of your destination countryin km2?");
        Scanner input = new Scanner(System.in);
        double distance = input.nextDouble();

        System.out.println("In miles that is " + distance*0.62137 );
    }
}

