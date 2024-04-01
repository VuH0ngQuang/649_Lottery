import java.util.Random;
public class WiningNumbers {
    private int[] numbers;
    Random rand = new Random();
    //create winning number
    public void generateWiningNumbers(){
        numbers = new int[6];
        for (int i =0; i < 6; i++)
            numbers[i] = rand.nextInt(50);
    }
    //return winning number
    public int getNumbers(int i) {
        return numbers[i];
    }
}
