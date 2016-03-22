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
		PokerSquaresPointSystem system = PokerSquaresPointSystem.getAmeritishPointSystem();
		System.out.println(system);
		new PokerSquares(new FlushMaker(), system).play(); // play a single game, taken from greedyMC
	}
}