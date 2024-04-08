import java.util.Scanner;
import java.util.Random;
public class UserNumbers {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    private int[] numbers;
    //to create user number
    public void generateUserNumbers(int userOptions){
        numbers = new int[6];
        if (userOptions != 1){
            System.out.println("1.To let the computer choose your numbers\n2.Choose your number by yourself");
            userOptions = scanner.nextInt();
        }
        switch (userOptions){
            case 1:// create randomly
                for (int i = 0; i < 6; i++)
                    numbers[i] = rand.nextInt(49 - 1 + 1) +1;
                break;
            case 2://user input manually
                for (int i = 0; i < 6; i++){
                    System.out.print("Please enter the "+(i+1)+" number: ");
                    numbers[i] = scanner.nextInt();
                }
        }
    }
    //to return user number
    public int getNumbers(int i) {
        return numbers[i];
    }
}
