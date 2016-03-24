public class FlushMaker implements PokerSquaresPlayer {

    private final int SIZE = PokerSquares.SIZE; //taken from greedyplayer
    private int[] numColCards = new int[SIZE]; //SIZE
    private Card[][] grid = new Card[SIZE][SIZE]; //creates new temp grid

    @Override
    public void init() { //Taken from GreedyMC
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++)
                grid[row][col] = null;
        for (int col = 0; col < SIZE; col++)
            numColCards[col] = 0;
    }

    @Override
    public int[] getPlay(Card card, long millisRemaining) {
        int[] thePlay = new int[2];
        //try to match suit
        int col = card.getSuit(); 
        if (numColCards[col] == SIZE) { //match column number to suit number
            if (numColCards[SIZE - 1] < SIZE){ col = SIZE - 1; }
            else { // or worst case: just dump the card in nearest opening
                col = 0;
                while (numColCards[col] == SIZE)
                    col++;
            }
        }
        thePlay[0] = numColCards[col]++;
        thePlay[1] = col;
        grid[thePlay[0]][thePlay[1]] = card;
        
        return thePlay;
    }

    public int[][] updateWeightedOdds(Card card, Card[][] currentGrid, long millisRemaining){
    	Card currentCard = card;
    	int[][] odds = new int[10][9];
    	currentGrid = grid;
    	//Link these together later somehow, each position played links 2 of these hands, 45 combos.
		int[] hand0Odds = new int[9];
		int[] hand1Odds = new int[9];
		int[] hand2Odds = new int[9];
		int[] hand3Odds = new int[9];
		int[] hand4Odds = new int[9];
		int[] hand5Odds = new int[9];
		int[] hand6Odds = new int[9];
		int[] hand7Odds = new int[9];
		int[] hand8Odds = new int[9];
		int[] hand9Odds = new int[9];
		//hand[pair,2pair,3kind,straight,flush,fullhouse,4kind,straightflush,royal]
    	//for (int i = 0; i < 5; i++){
    		//for (int j = 0; j < 5; j++){
    			//Better to loop through here?
    			//Make call to updateHandOdds with each hand (i.e. hand [0][0-4])
    	hand0Odds = updateHandOdds(grid[0][0], grid[0][1], grid[0][2], grid[0][3], grid[0][4]); //pair
    	hand1Odds = updateHandOdds(grid[1][0], grid[1][1], grid[1][2], grid[1][3], grid[1][4]);
    	hand2Odds = updateHandOdds(grid[2][0], grid[2][1], grid[2][2], grid[2][3], grid[2][4]);
    	hand3Odds = updateHandOdds(grid[3][0], grid[3][1], grid[3][2], grid[3][3], grid[3][4]);
    	hand4Odds = updateHandOdds(grid[4][0], grid[4][1], grid[4][2], grid[4][3], grid[4][4]);
    			
    	hand5Odds = updateHandOdds(grid[0][0], grid[1][0], grid[2][0], grid[3][0], grid[4][0]);
    	hand6Odds = updateHandOdds(grid[0][1], grid[1][1], grid[2][1], grid[3][1], grid[4][1]);
    	hand7Odds = updateHandOdds(grid[0][2], grid[1][2], grid[2][2], grid[3][2], grid[4][2]);
    	hand8Odds = updateHandOdds(grid[0][3], grid[1][3], grid[2][3], grid[3][3], grid[4][3]);
    	hand9Odds = updateHandOdds(grid[0][4], grid[1][4], grid[2][4], grid[3][4], grid[4][4]);
    		//}
    	//}
    	
    	
    	
    	
    	return odds;
    }
    //http://stattrek.com/probability-distributions/hypergeometric.aspx
    //Multiply probability by points gained from actually making the hand.
    public int[] updateHandOdds(Card card, Card card2, Card card3, Card card4, Card card5){
    	int[] odds = new int[9];
    	
    	
    	
    	return odds;
    }


	@Override
	public void setPointSystem(PokerSquaresPointSystem system, long millis) {
		// TODO Auto-generated method stub, not needed?
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub, not needed?
		return null;
	}
	
	public static void main(String[] args) {
		PokerSquaresPointSystem system = PokerSquaresPointSystem.getAmericanPointSystem();
		System.out.println(system);
		new PokerSquares(new FlushMaker(), system).play(); // play a single game, taken from greedyMC
	}
}