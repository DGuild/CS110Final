/**
* Represents a standard playing card
*/
public class Card{
	private int rank;
   private String imgPath;
	private Suit suit;

   /**
   * Constructs a Card object given a rank and a suit. Also creates
   * an associated image path to find the image associated with the
   * card
   * @param rank The card's rank
   * @param suit The card's suit
   */
	public Card(int rank, Suit suit){
		if(isRankValid(rank))
			this.rank = rank;
		else
			this.rank = 1;
		this.suit = suit;
      
      String r = "";
      String s = "";
      if( rank >= 2 && rank <= 10){
         r = Integer.toString(rank);
      }
      else if(rank == 1){
         r = "ace";
      }
      else if(rank == 11){
         r = "jack";
      }
      else if(rank == 12){
         r = "queen";
      }
      else if(rank == 13){
         r = "king";
      }
      
      if(suit == Suit.CLUB){
         s = "c";
      }
      else if(suit == Suit.DIAMOND){
         s = "d";
      }
      else if(suit == Suit.HEART){
         s = "h";
      }
      else if(suit == Suit.SPADES){
         s = "s";
      }
      
      this.imgPath = ("../img\\" + r + s + ".jpg");
      
	}
   
   /**
   * Sets the card's rank
   * @param r The rank
   */
	public void setRank(int r){this.rank = r;}
   
   /**
   * Sets the card's suit
   * @param s The suit
   */
	public void setSuit(Suit s){this.suit = s;}

   /**
   * Returns the card's rank
   * @return the card's rank
   */
	public int getRank(){
		return this.rank;
	}

   /**
   * Returns the card's suit as a Suit enum
   * @return the card's suit
   */
	public Suit getSuit(){
		return this.suit;
	}
   
   /**
   * Returns filepath to the Card's associated image
   * @return the filepath as String
   */
   public String getImgPath(){
      return imgPath;
   }

   /**
   * Compares Card rank to given Card's rank.
   * Returns positive if this Card is larger, negative
   * if other Card is larger, and 0 if the Card rank's
   * are equal
   * @param c The Card to compare to
   * @return An integer indicating which Card is larger
   */
	public int compareTo(Card c){
		if (this.getRank() > c.getRank())
			return 1;
		else if (this.getRank() < c.getRank())
			return -1;
		else
			return 0;
	}

   /**
   * A private method used to validate a rank
   * @param r the rank to check for validity
   * @return true if the rank is valid
   */
	private boolean isRankValid(int r){
		if(r < 0 || r > 13)
			return false;
		return true;
	}

}