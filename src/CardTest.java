public class CardTest{
	
	public static void main(String[] args){

		Card c1 = new Card(1, HEART);
		Card c2 = new Card(10, SPADES);

		System.out.println(c1.getRank());
		System.out.println(c1.getSuit());
		if (c1.compareTo(c2) < 0)
			System.out.println("The second card is bigger");
	}
}