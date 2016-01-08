
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
