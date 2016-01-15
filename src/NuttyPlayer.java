import java.util.Random;


public class NuttyPlayer implements PokerSquaresPlayer {
	
	private final int SIZE = 5; // number of rows/columns in square grid
	private final int NUM_POS = SIZE * SIZE; // number of positions in square grid
	private final int NUM_CARDS = Card.NUM_CARDS; // number of cards in deck
	private Random random = new Random(); // pseudorandom number generator for Monte Carlo simulation 
	private int[] plays = new int[NUM_POS]; // positions of plays so far (index 0 through numPlays - 1) recorded as integers using row-major indices.
	// row-major indices: play (r, c) is recorded as a single integer r * SIZE + c (See http://en.wikipedia.org/wiki/Row-major_order)
	// From plays index [numPlays] onward, we maintain a list of yet unplayed positions.
	private int numPlays = 0; // number of Cards played into the grid so far
	private PokerSquaresPointSystem system; // point system
	private Card[][] grid = new Card[SIZE][SIZE]; // grid with Card objects or null (for empty positions)
	private Card[] simDeck = Card.getAllCards(); // a list of all Cards. As we learn the index of cards in the play deck,
	                                             // we swap each dealt card to its correct index.  Thus, from index numPlays 
												 // onward, we maintain a list of undealt cards for MC simulation.
	private int[][] legalPlayLists = new int[NUM_POS][NUM_POS]; // stores legal play lists indexed by numPlays (depth)
	// (This avoids constant allocation/deallocation of such lists during the greedy selections of MC simulations.)

	@Override
	public void setPointSystem(PokerSquaresPointSystem system, long millis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getPlay(Card card, long millisRemaining) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** The hypergeometric distribution is used to calculate probabilities when sampling without replacement. 
	 * For example, suppose you first randomly sample one card from a deck of 52. Then, without putting the
	 * card back in the deck you sample a second and then (again without replacing cards) a third. Given 
	 * this sampling procedure, what is the probability that exactly two of the sampled cards will be aces
	 * (4 of the 52 cards in the deck are aces). You can calculate this probability using the following 
	 * formula based on the hypergeometric distribution:
	 * p = [(kCx)[(N-k)C(n-x)]]/(NCn) where k = successes in pop, x = successes in sample, N is size of population,
	 * n is number sampled, kCx is number of k things chosen at x time.
	 * example: In this example, k = 4 because there are four aces in the deck, x = 2 because the problem asks about
	 * the probability of getting two aces, N = 52 because there are 52 cards in a deck, and n = 3 because 3 cards
	 * were sampled.
	 **/
	public Float[][][] buildProbabilitiesTable() {
		//nothing, pair, 2-pair, 3-kind, straight, flush, boat, 4-kind, straight-flush, royal-flush
		//20 probabilities for each position. Affects 2 hand combos (10x2)
		return null;
	}
	
	public Float[] probCalculator(int k, int x, String cardType, int N, int s) {
		Float[] positionProbs = new Float[20];
		k = 0;
		x = 0; //What we are pairing.
		N = 0; //Number of cards in deck.
		s = 0; //Number of cards sampled.
		
		return positionProbs;
	}

	public static void main(String[] args) {
		PokerSquaresPointSystem system = PokerSquaresPointSystem.getAmeritishPointSystem();
		System.out.println(system);
		new PokerSquares(new NuttyPlayer(), system).play(); // play a single game
	}
	
}
