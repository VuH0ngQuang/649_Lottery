public class JackpotCheck {
    private WiningNumbers winingNumbers;
    private UserNumbers userNumbers;
    public JackpotCheck(WiningNumbers winingNumbers, UserNumbers userNumbers) {
        this.winingNumbers = winingNumbers;
        this.userNumbers = userNumbers;
    }
    //check the user number and wining number are the same or not
    private int isMatched(){
        int matchedNumbers = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (winingNumbers.getNumbers(i) == userNumbers.getNumbers(j))
                    matchedNumbers++;
            }
        }
        return matchedNumbers;
    }
    //return the quantity of matched numbers
    public int isWonOrJackpot() {
        isMatched();
        return switch (isMatched()) {
            case 1, 2, 3, 4, 5 -> 1; // return 1 is Won
            case 6 -> 2; // return 2 is jackpot
            default -> 0; // return 0 is lost
        };
    }
    //return the prize base on matched numbers
    public int getPrize(){
        return switch (isMatched()){
            case 1, 2 -> 10;
            case 3 -> 100;
            case 4 -> 1000;
            case 5 -> 5000;
            case 6 -> 5000000;
            default -> 0;
        };
    }
    //return matched number
    public int getMatchedNumbers(){ return isMatched(); }
}
