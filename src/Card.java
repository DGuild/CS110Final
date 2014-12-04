public class Card{
	private int rank;
   private String imgPath;
	private Suit suit;

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

	public void setRank(int r){;}
	public void setSuit(Suit s){;}

	public int getRank(){
		return this.rank;
	}

	public Suit getSuit(){
		return this.suit;
	}
   
   public String getImgPath(){
      return imgPath;
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