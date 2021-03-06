import java.util.ArrayList;

/*
 * Name: Subash Sapkota
 * Student Id: C0824340
 * */

enum SUIT {
	RED,
	GREEN,
	BLUE,
	PURPLE
}

public class MainApplication {
	// Converting UML diagram to Classes with properties and methods
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// initialize the deck player and dealer and then start the game
		FizbinGame game = new FizbinGame();
		game.initializeGame();
		game.play();
		A a = new A();
		System.out.println(a.i);
	}

}



class FizbinGame {
	// Handler of the Game
	CardDeck gameDeck;
	Dealer dealer;
	ArrayList<Player> players;
	Boolean winnerFlag = false;
	Player winner;
	
	public void initializeGame() {
		gameDeck = new CardDeck();
		players = new ArrayList<Player>();
		dealer = new Dealer(gameDeck, players);
	}
	
	// Create no of Players
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void play() {
		// dealer shuffles and then distribute cards to players
		dealer.shuffleCard();
		dealer.dealCard();
		
		while (winnerFlag == false) {		
			dealer.swapCards(players, new ArrayList<Card>());
			checkWinner();
			// If winner logic
			// set Boolean winnerFlag = True to end game 
			// and declare winner
			
			if (winnerFlag == true) {
				endGame(winner);
			}
		}
		
		
	}
	
	public void checkWinner() {
		
		// create logic to check for winner
		// checks for winner and set the winnerFlag
		
		winnerFlag = true;
	}
	
	public void endGame(Player player) {
		// end the game
		System.out.println("The winner is " + winner);
	}
	
	
}

class Card {
	// Card ADT datatype
	private SUIT suit;
	private int value;
	
	// Constructor
	public Card(int value, SUIT suit) {
		this.suit = suit;
		this.value = value;
	}
	
	// Getters
	public int getValue() {
		return this.value;
	}
	
	public SUIT getSuit() {
		return this.suit;
	}
	
	// Setters
	public void setValue(int value ) {
		this.value = value;
	}
	
	public void setSuite(SUIT suit) {
		this.suit = suit;
	}
	
	// overriding the existing toString method
	public String toString() {
		return " Card (Suit: " + this.suit + " Value: " + this.value + " )";
	}
	
	
}

class CardDeck {
	// Collection of Cards, and initializes the Deck
	ArrayList<Card> cardDeck;
	
	public CardDeck() {
		this.cardDeck = new ArrayList<Card>();
		// here generate the Cards
	}
	
	public String toString() {
		return "cardDeck" + cardDeck;
	}
}

class Player {
	// Stores player name and hand information
	private String name;
	private ArrayList<Card> hand;
	
	// initializing hand with a constructor
	public Player() {
		this.hand = new ArrayList<Card>();
	}
	
	// getters
	public ArrayList<Card> getHand(){
		return this.hand;
	}
	
	public String getName() {
		return this.name;
	}
	
	// setters
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// overriding toString method
	
	public String toString() {
		return "Player " + this.name + " -- hand: " + this.hand;
	}
	
}

class Dealer {
	// Dealer deals the card and shuffles and swap cards
	CardDeck deck;
	ArrayList<Player> players;
	
	public Dealer(CardDeck deck, ArrayList<Player> players) {
		this.deck = deck;
		this.players = players;
	}
	
	public void shuffleCard() {
		
	}
	
	public void dealCard() {
		// check the cardDeck size and deal card accordingly
	}
	
	// Implement logic on how to solve the cards
	public void swapCards(ArrayList<Player> players, ArrayList<Card> cards) {
		
	}
	
	
	// get the current size of a Deck
	public int getDeckSize() {
		
		return deck.cardDeck.size();
	}
}





class A {
	{
		i = 10;
	}
	int i;
}








