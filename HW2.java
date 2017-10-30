import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO:B0544151陳莉茿
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {
	/*public公開;void不回傳;main先執行的方法*/
	public static void main(String[] args) {
		/*sc輸入法*/
		Scanner sc = new Scanner(System.in);
		/*print請輸入幾副牌*/
		System.out.println("input N (deck of cards):");
		/*scanner輸入testn*/
		String testn= sc.nextLine(); 
		/*將testn轉換成int nDeck副牌*/        
		int nDeck=Integer.parseInt(testn);
		/*呼叫method Deck算出輸入的牌數*/
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		/*呼叫method printDeck，把輸入多少副的牌數都印出來*/		
		deck.printDeck();
		/*如果isAllCardsCorrect符合*/		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			/*符合就print Well done!*/		
			System.out.println("Well done!");
		}else{
			/*不符合就print Error, please check your sours code*/
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}
}
/**
 * Description: TODO: please add description here
 */
class Deck{
/*private不公開*/
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		int rank;
		int suit;
		/*根據輸入的nDeck副數的牌跑出所有的花色跟牌數*/
		for(int i = 1;i <= nDeck;i++)
		{
			for(suit = 0;suit <= 3;suit++)
			{
				for(rank = 0;rank <= 12;rank++)
				{
					Card card=new Card(suit,rank);
					cards.add(card);
				}
			}
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(Card a:cards)
		{
			a.printCard();
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	/*只能有一個public,設定private*/
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank;
	//1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	/*只能有一個public,設定private*/
	private String arrayrank[] = {"Ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private char arraysuit[] = {'1','2','3','4'};
	public Card(int s,int r){
		suit=s;
		rank=r;
	}
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
	//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
	/*印出所有的牌(牌數,花色)*/
	System.out.println("(" + arrayrank[rank] + "," + arraysuit[suit] + ")");
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}