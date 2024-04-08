import java.util.Scanner;

public class Main {
    static Loop loop = new Loop();
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){
        int again = 1;
        while (again == 1){
            System.out.print("How many tickets do you want to buy: ");
            int numberLoop = scanner.nextInt();
            loop.isLoop(numberLoop);
            System.out.println("The number of ticket won any number: "+loop.getTotalWon());
            System.out.println("The number of ticket won all 6 numbers: "+loop.getTotalJackpot());
            System.out.println("Total money won: $"+loop.getTotalPrize());
            System.out.println("Total ticket cost: $"+(numberLoop*4));
            System.out.println("Profit/Loss: $"+(loop.getTotalPrize()-(numberLoop*4)));
            System.out.print("Do you want get information about any specific ticket ? (Input ticket number from 1 to "+numberLoop+" OR 0 to exit): ");
            int specificMatch = scanner.nextInt() - 1;// reduce 1 to match index
            loop.getInfoMatch(specificMatch, numberLoop);
            System.out.print("Do you want to play again ? (1.Yes\t2.No): ");
            again = scanner.nextInt();
        }
    }
}


