
public class NuttyPlayer implements PokerSquaresPlayer {

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
	public Float[][] getProbabilitiesTable(int position) {
		Float[] handProbArray = new Float[20]; //nothing, pair, 2-pair, 3-kind, straight, flush, boat, 4-kind, straight-flush, royal-flush
		Float[][] positionProbabilities = new Float[5][5]; // Need 20 in above line, each position affects 2 hand combos (10x2)
		
		
		return positionProbabilities;
	}

	public static void main(String[] args) {
		PokerSquaresPointSystem system = PokerSquaresPointSystem.getAmeritishPointSystem();
		System.out.println(system);
		new PokerSquares(new NuttyPlayer(), system).play(); // play a single game
	}
	
}
