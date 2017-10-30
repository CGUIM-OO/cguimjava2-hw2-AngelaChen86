import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO:B0544151�����z
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {
/*public���};void���^��;main�����檺��k*/
	public static void main(String[] args) {
/*sc��J�k*/
		Scanner sc = new Scanner(System.in);
/*print�п�J�X�ƵP*/
		System.out.println("input N (deck of cards):");
/*scanner��Jtestn*/
		String testn= sc.nextLine(); 
/*scanner��JnDeck�ƵP*/        
		int nDeck=Integer.parseInt(testn);
/*�I�smethod Deck��X��J���P��*/
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
/*�I�smethod deck�A���J�h�ְƪ��P�Ƴ��L�X��*/		
		deck.printDeck();
/*�p�GisAllCardsCorrect�ŦX*/		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
/*�ŦX�Nprint Well done!*/		
			System.out.println("Well done!");
		}else{
/*���ŦX�Nprint Error, please check your sours code*/
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �Ҧ����P
	 * @param nDeck �`�@���X�ƵP
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
/*private�����};Arraylist<Card>*/
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
/*�]�}�Carrayrank[]�s��A-K�Q�T�i�P*/
		String arrayrank[] = {"Ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
/*�]�}�Carraysuit[]�s��|�ت��*/
		char arraysuit[] = {'1','2','3','4'};
/*�ھڿ�J��nDeck�Ƽƪ��Pprint�X�Ҧ����P*/
		for(int i = 1;i <= nDeck;i++)
		{
			for(int j = 0;j <= 12;j++)
			{
				for(int k = 0;k <= 3;k++)
				{
					System.out.println("(" + arrayrank[j] + "," + arraysuit[k] + ")");
					return;
					int suit;
					int rank;
					Card card=new Card( rank,suit);
					cards.add(card);
				}
			}
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
	//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
/*�]�}�Carrayrank[]�s��A-K�Q�T�i�P*/
		String arrayrank[] = {"Ace","2","3","4","5","6","7","8","9","10","J","Q","K"};
/*�]�}�Carraysuit[]�s��|�ت��*/
		char arraysuit[] = {'1','2','3','4'};
/*�ھڿ�J��nDeck�Ƽƪ��Pprint�X�Ҧ����P(�P��,���)*/
		System.out.println("(" + arrayrank[rank-1] + "," + arraysuit[suit-1] + ")");
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}