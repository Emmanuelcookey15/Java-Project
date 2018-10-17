import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleShip {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        char[][] sea = oceanMap();
        for (int i = 0; i<5; i+=1) {
            playersShipCoordinte(sea);
        }
        System.out.println("Computer is deploying ships");
        for (int i = 0; i<5; i+=1) {
            computerShipsCoordinate(sea);
        }
        int battle = battleOutcome(sea);
        while (battle != 0) {
            showSea(sea);
            playerShipAttack(sea);
            computerShipAttack(sea);
            battle = battleOutcome(sea);
        }
    }



    public static char[][] oceanMap() {
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("Right now, the sea is empty.");
        char[][] sea = new char[10][10];
        for (int x = 0; x < sea.length; x+= 1) {
            System.out.print(x+"|");
            for (int y = 0; y < sea[x].length; y+= 1) {
                System.out.print(sea[x][y]);
            }
            System.out.println("|" + x);
        }
        return sea;
    }



    public static void playersShipCoordinte(char[][] val) {
        System.out.print("Enter X coordinate for your ship: ");
        int x = input.nextInt();
        while (x > 9 || x < 0) {
            System.out.println("Invalid co-ordinate");
            System.out.print("Re-Enter X coordinate for your ship: ");
            x = input.nextInt();
        }
        System.out.print("Enter Y coordinate for your ship: ");
        int y = input.nextInt();
        while (y > 9 || y < 0) {
            System.out.println("Invalid co-ordinate");
            System.out.print("Re-Enter Y coordinate for your ship: ");
            y = input.nextInt();
        }
        while (val[x][y] == '2' || val[x][y] == '1') {
            System.out.println("A ship has already been deployed there.");
            System.out.print("Enter another X coordinate for ship: ");
            x = input.nextInt();
            while (x > 9 || x < 0) {
                System.out.println("Invalid co-ordinate");
                System.out.print("Re-Enter X coordinate for your ship: ");
                x = input.nextInt();
            }
            System.out.print("Enter another Y coordinate for ship: ");
            y = input.nextInt();
            while (y > 9 || y < 0) {
                System.out.println("Invalid co-ordinate");
                System.out.print("Re-Enter Y coordinate for your ship: ");
                y = input.nextInt();
            }
        }
        val[x][y] = '1';
    }



    public static void computerShipsCoordinate(char[][] val) {
        int x = (int) (Math.random()*9);
        int y = (int) (Math.random()*9);
        while (val[x][y] == '1' || val[x][y] == '2') {
            System.out.println("A ship has already been deployed there.");
            x = (int) (Math.random()*9);
            y = (int) (Math.random()*9);
        }
        System.out.println("ship DEPLOYED");
        val[x][y] = '2';
    }



    public static void showSea(char[][] sea) {
        for (int x = 0; x < sea.length; x += 1) {
            System.out.print(x +"|");
            for (int y = 0; y < sea[x].length; y += 1) {
                if (sea[x][y] == '1') {
                    System.out.print('@');
                }
                else if (sea[x][y] == '2') {
                    System.out.print(" ");
                }
                else {
                    System.out.print(sea[x][y]);
                }
            }
            System.out.println("|" + x);
        }
    }

    public static void playerShipAttack(char[][] val) {
        System.out.print("guess a the coordinate of opponents ship: ");
        int x = input.nextInt();
        while (x > 9 || x < 0) {
            System.out.println("Invalid co-ordinate");
            System.out.print("Re-Enter X coordinate for your ship: ");
            x = input.nextInt();
        }
        System.out.print("Enter Y coordinate for your ship: ");
        int y = input.nextInt();
        while (y > 9 || y < 0) {
            System.out.println("Invalid co-ordinate");
            System.out.print("Re-Enter Y coordinate for your ship: ");
            y = input.nextInt();
        }
        if (val[x][y] == '2') {
            System.out.println("Boom! You sunk the ship!");
            val[x][y] = '!';
        }
        else if (val[x][y] == '1') {
            System.out.println("Oh no, you sunk your own ship :(");
            val[x][y] = 'x';
        }
        else {
            if (val[x][y] == '!' || val[x][y] == 'x'  || val[x][y] == '-') {
                System.out.println("Already sunk this ship");
                System.out.print("guess a the coordinate of opponents ship: ");
                x = input.nextInt();
                while (x > 9 || x < 0) {
                    System.out.println("Invalid co-ordinate");
                    System.out.print("Re-Enter X coordinate for your ship: ");
                    x = input.nextInt();
                }
                System.out.print("Enter Y coordinate for your ship: ");
                y = input.nextInt();
                while (y > 9 || y < 0) {
                    System.out.println("Invalid co-ordinate");
                    System.out.print("Re-Enter Y coordinate for your ship: ");
                    y = input.nextInt();
                }
            }
            else {
                System.out.println("Sorry, you missed");
                val[x][y] = '-';
            }
        }
    }

    public static void computerShipAttack(char[][] val) {
        System.out.println("Computer is guessing player's ship...");
        int x = (int) (Math.random()*9);
        int y = (int) (Math.random()*9);
        if (val[x][y] == '2') {
            System.out.println("The Computer sunk one of its own ships!");
            val[x][y] = '!';
        }
        else if (val[x][y] == '1') {
            System.out.println("The Computer sunk one of your ships!");
            val[x][y] = 'x';
        }
        else {
            if (val[x][y] == '!' || val[x][y] == 'x'  || val[x][y] == '-') {
                System.out.println("Already sunk this ship");
                x = (int) (Math.random() * 9);
                y = (int) (Math.random() * 9);
            }
            else {
                System.out.println("COMPUTER'S missed");
                val[x][y] = '-';
            }

        }
    }

    public static int battleOutcome(char[][] val) {
        int playerShips = 0;
        int computerShips = 0;
        for (int x = 0; x < val.length; x+= 1) {
            for (int y = 0; y < val[x].length; y += 1) {
                if (val[x][y] == '1') {
                    playerShips += 1;
                }
                else if (val[x][y] == '2') {
                    computerShips += 1;
                }
            }
        }
        if (playerShips == 0) {
            System.out.println("Your ships: "+ playerShips + " | Computer ships: " + computerShips);
            System.out.println("Computer wins the battle");
            return playerShips;
        }
        else if (computerShips == 0) {
            System.out.println("Your ships: "+ playerShips + " | Computer ships: " + computerShips);
            System.out.println("Hooray! You win the battle");
            return computerShips;
        }
        else {
            System.out.println("Your ships: "+ playerShips + " | Computer ships: " + computerShips);
            return playerShips + computerShips;
        }
    }
}
