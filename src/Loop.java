import java.util.Scanner;

public class Loop {
    Scanner scanner = new Scanner(System.in);
    private int totalPrize;
    private int totalWon;
    private int totalJackpot;
    private UserNumbers[] userNumbers;
    private WiningNumbers[] winingNumbers;
    private JackpotCheck[] jackpotChecks;
    // this is a loop based on the user input
    public void isLoop(int numberLoop){
        userNumbers = new UserNumbers[numberLoop];
        winingNumbers = new WiningNumbers[numberLoop];
        jackpotChecks = new JackpotCheck[numberLoop];
        //loop
        for (int i = 0; i < numberLoop; i++){
            if (numberLoop > 1){
                userNumbers[i] = new UserNumbers();
                userNumbers[i].generateUserNumbers(1);
            } else {
                userNumbers[i] = new UserNumbers();
                userNumbers[i].generateUserNumbers(0);
            }
            winingNumbers[i] = new WiningNumbers();
            winingNumbers[i].generateWiningNumbers();
            jackpotChecks[i] = new JackpotCheck(winingNumbers[i], userNumbers[i]);
            switch (jackpotChecks[i].isWonOrJackpot()){
                case 1:
                    totalWon++;
                    break;
                case 2:
                    totalJackpot++;
                    break;
                default:
                    break;
            }
            totalPrize += jackpotChecks[i].getPrize();
        }
    }
    public int getTotalPrize(){ return totalPrize; }
    public int getTotalWon(){ return totalWon; }
    public int getTotalJackpot(){ return totalJackpot; }
    public void getInfoMatch(int i, int numberLoop){
        while (i != -1 && i < numberLoop){
            System.out.print("User ticket number: ");
            for (int j =0; j < 6; j++){
                System.out.print(userNumbers[i].getNumbers(j)+" ");
            }
            System.out.print("\nWining ticket number: ");
            for (int j = 0; j < 6; j++){
                System.out.print(winingNumbers[i].getNumber(j)+" ");
            }
            System.out.println("\nMatched number: "+jackpotChecks[i].getMatchedNumbers());
            System.out.println("Prize for this match: $"+jackpotChecks[i].getPrize());
            System.out.println("Profit/Loss for this match: $"+(jackpotChecks[i].getPrize()-4));
            System.out.print("Get information another match ? (Input match number from 1 to "+numberLoop+" OR 0 to exit): ");
            i = scanner.nextInt() - 1;
        }
    }
}
