public class Card{

	public enum Suit{
		CLUB,
		DIAMOND,
		HEART,
		SPADES 

	}
	private int rank;
	private Suit suit;

	public Card(int rank, Suit suit){
		if(isRankValid(rank))
			this.rank = rank;
		else
			this.rank = 1;
		this.suit = suit;
	}

	public void setRank(int r){;}
	public void setSuit(Suit s){;}

	public int getRank(){
		return this.rank;
	}

	public Suit getSuit(){
		return this.suit;
	}

	public int compareTo(Card c){
		if (this.getRank() > c.getRank())
			return 1;
		else if (this.getRank() < c.getRank())
			return -1;
		else
			return 0;
	}

	private boolean isRankValid(int r){
		if(r < 0 || r > 13)
			return false;
		return true;
	}

}