import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;


public class MainApplication { // Entry point of program
	public static void main(String[] args) {
		System.out.println("Welcome to our game:");

		TheTable cardTable = new TheTable(); // Create Table object
		cardTable.GenerateTheCardDeck();
		// cardTable.shuffleTheDeck();
		// cardTable.DisplayTheDeck();
		cardTable.addPlayers();
		cardTable.showPlayers();
		cardTable.startGame();
	}
}

class TheTable {
    // Table Class Generates Card, Shuffles, Add Players, and Begin the game 
	int CardPositionInDeck = 0;
	int NameCardPosition = 0;
	private int numberOfPlayers = 4; // No of players control
	CardDeck deck = new CardDeck();
	String[] suites = { "Clubs", "Diamonds", "Hearts", "Spades" };
	ArrayList<Player> players = new ArrayList<Player>(4);

	public void DisplayTheDeck() {
		try {
			FileWriter writer = new FileWriter("C:\\Users\\longe\\Desktop\\2nd_Semester\\Java\\JavaProgrammingWorkspace\\FizbinPart3\\Files\\data\\cards-" +(new Date()).getSeconds() + ".txt", true);

			for (int i = 0; i < deck._cardDeck.size(); i++) {
				writer.write(deck._cardDeck.get(i).toString());
				writer.write("\r\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void GenerateTheCardDeck() {
		// when we implemented this method: we had not yet made our rules for the values of the CARDS
		// we need to create an implementation of this method that reflects the Rules in 
		// our Requirements: Assessing the VALUE of a HAND in Fizbin Excel Sheet								

			for (int suiteNumber = 0; suiteNumber < suites.length; suiteNumber++) {
				populateTheDeck(suiteNumber);
			}
	}
	
	// This function shuffles the card deck
	public void shuffleTheDeck() {
		// Randomly shuffles the card
		Random rnd = ThreadLocalRandom.current();
		
		for (int i=deck._cardDeck.size() - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Card card = deck._cardDeck.get(index);
			deck._cardDeck.set(index, deck._cardDeck.get(i));
			deck._cardDeck.set(i, card);
		}
	}

	// This function creates the deck
	private void populateTheDeck(int suiteNumber) {
		deck._cardDeck.add(new Card(suites[suiteNumber], "Ace"));

		for (int cardValue = 2; cardValue <= 10; cardValue++) {
			deck._cardDeck.add(new Card(suites[suiteNumber], String.valueOf(cardValue)));
		}
		
		deck._cardDeck.add(new Card(suites[suiteNumber], "Jack"));
		deck._cardDeck.add(new Card(suites[suiteNumber], "Queen"));
		deck._cardDeck.add(new Card(suites[suiteNumber], "King"));

	}
	
	// This creates 4 players
	public void addPlayers() {
		// Add players
		System.out.println("Adding Players");
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String input = new String();
		Player player;


		for (int i = 0; i < this.numberOfPlayers; i++) {
			player = new Player();
			System.out.println("Enter the name of player "+ (i+1) +" > ");
			try {
				input = reader.readLine();
				player.setName(input);
				players.add(player);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}			
		}
	}
	
	// function to show current players
	public void showPlayers() {
		// Prints current player in the game
		System.out.println("\nWelcome Players!");
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName());
		}
	}
	
	// pass 5 cards to the 4 players
	public void startGame() {
		// Creats Round object and the calls playRound Method
		Round round = new Round(players, (ArrayList<Card>)deck._cardDeck.clone());
		round.playRounds();
	}
}

class CardDeck {
	// Collection of Cards
	public ArrayList<Card> _cardDeck = new ArrayList<Card>();
}

class Card {
	// ADT Class to define one card
	// what things does a card need to KNOW
	// SUITE VALUES
	// Clubs = , Diamonds = , Hearts = , Spades = 

	public Card(String _suite, String _cardvalue) {
		this.suite = _suite;
		this.cardvalue = _cardvalue;
		this.setSuiteValue(); // setting the value for Suites
		this.setValue(); // setting the value for cardValue
	}

	private String suite;
	private String cardvalue;
	// #TODO: Add to the this Class a VALUE Data Attribute 
	// set the VALUE of this Card based on Suite and Card Value
	
	private int suitValue;
	private int value;
	
	// setting suiteValue. function is triggered at the time of object creation
	private void setSuiteValue() {
		switch(this.suite.toLowerCase()){
		case "clubs": {
			this.suitValue =  1;
			break;
			}
		case "diamonds": {
			this.suitValue = 2;
			break;
			}
		case "hearts": {
			this.suitValue = 3;
			break;
			}
		case "spades": {
			this.suitValue = 4;
			break;
			}
		default: {
			this.suitValue = 0;
			}
		}
	}
	
	// function to get SuiteValue
	public int getSuiteValue() {
		return this.suitValue;
	}
	
	// function to setValue this function is triggered when object is created
	private void setValue() {
		switch(this.cardvalue.toLowerCase()) {
		case "jack": {
			this.value = suitValue * 11;
			break;
			}
		case "queen": {
			this.value = suitValue * 12;
			break;
			}
		case "king": {
			this.value = suitValue * 13;
			break;
			}
		case "ace": {
			this.value = suitValue * 14;
			break;
			}
		default: {
			try {
				this.value = suitValue * Integer.parseInt(cardvalue);
				}
			// Catching NumberFormatException
			catch (NumberFormatException n) {
				n.printStackTrace();
				}
			// Catching other exceptions
			catch( Exception e) {
				System.out.println(e);
				}
			}
		}
		
	}
	
	// function to get the card value
	public int getValue() {
		return this.value;
	}
	
	
	public String toString() {
		return "( " + this.cardvalue + " of " + this.suite + ", Value: " + this.value +" )";
	}
}

class Player {
	// Stores player name and hand information
	private String name;
	public ArrayList<Card> hand;
	private int totalHandValue = 0;
	
	// initializing hand with a constructor
	public Player() {
		this.hand = new ArrayList<Card>();
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHandValue() {
		// Calculates the Total Hand Value
		int currentHandValue = 0;
		for(int i=0; i<hand.size(); i++) {
			currentHandValue += hand.get(i).getValue();
		}
		this.totalHandValue = currentHandValue;
		return this.totalHandValue;
	}
	
	// overriding toString method
	
	public String toString() {
		return "Player " + this.name + " -- hand: " + this.hand;
	}
	
}

class Round {
	// Holds the information about Number of Cards to be served and Number of Rounds
	public Round(ArrayList<Player> players, ArrayList<Card> deck) {
		this.players = players;
		this.original_deck = deck;
		
	}
	private ArrayList<Player> players;
	private ArrayList<Card> deck;
	private ArrayList<Card> original_deck;
	private int numberOfCards = 5; // Defines number of cards to be served
	private int numberOfRounds = 3; // Defines number of rounds
	private ArrayList<CardDeck> playerCardList = new ArrayList<CardDeck>(numberOfCards);
	
	public void playRounds() {
		// Serve card and start Round
		deck = (ArrayList<Card>) original_deck.clone();
		shuffleTheDeck();
		serveCards();
		startRound();

		
	}
	public void serveCards() {
		// Serve random cards
		int index = 0;
		for (int i=0; i<numberOfCards; i++) {
			for (Player player: players) {
				player.hand.add(deck.remove(index));
				index++;
			}
		}
	}
	
	public void showPlayerCards(Player player) {
		// Shows the current hand cards
		System.out.println(player.getName() + ", You have following cards");
		for(int i=0; i<player.hand.size(); i++) {
			System.out.println("Card " + (i+1) + ": " + player.hand.get(i).toString());
		}
		System.out.println("Total Hand Value: " + player.getHandValue());
		System.out.println("-------------------------------------");

	}
	
	public void shufflePlayers() {
		// Shuffles the player for random turn
		Random rnd = ThreadLocalRandom.current();
		for (int i=players.size() - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Player player = players.get(index);
			players.set(index, players.get(i));
			players.set(i, player);
		}
	}
	
	public void startRound() {
		// Start round
		for (int i=1; i<(numberOfRounds + 1); i++) {
			System.out.println("\n-------------------------------------------------");
			System.out.println("\t\tRound "+ i);
			System.out.println("-------------------------------------------------\n");
			
			shufflePlayers();
			for(Player player: players) {
				System.out.println("Player " + player.getName() + " turn:---");
				showPlayerCards(player);
				swapCards(player);
				System.out.println("-------------------------------------------------");
			}
			// shufflePlayer before beginning next round
			shufflePlayers();
		}
		declareWinner();

		
	}
	public void declareWinner() {
		// Compare hand value of each players and declare winner whoever has the largest hand value
		System.out.println("******************************* Final Result ***********************************");
		for(Player player: players) {
			showPlayerCards(player);
			System.out.println("-------------------------------------------------");
		}
		System.out.println("******************************* Winner ***********************************");
		
		Player winner = players.get(0);
		for (int i=1; i<players.size(); i++) {
			if (winner.getHandValue() < players.get(i).getHandValue()) {
				winner = players.get(i);
			}
		}
		System.out.println("Congratulations!!!");
		System.out.println("The Winner is  " + winner.getName() + " with Total Hand Value: " + winner.getHandValue());
		for(int i=0; i<winner.hand.size(); i++) {
			System.out.println("Card " + (i+1) + ": " + winner.hand.get(i).toString());
		}
		
	}
	public void swapCards(Player player) {
		// Swap cards with the deck
		System.out.println("Select upto 3 cards you want to swap eg. '1,2 or 2,3,4' or leave a blank");
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String input = new String();
		
		try {
			input = reader.readLine();
			if (input != null && !input.trim().isEmpty()) {
				String[] userValues = input.split(",");
				for (String value: userValues) {
					int index = Integer.valueOf(value.strip());
					Card card = player.hand.get(index-1);
					player.hand.set(index-1, deck.remove(0));
					deck.add(card);
				}		
				
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	// This function shuffles the card deck
	public void shuffleTheDeck() {
		// Randomly shuffles the deck
		Random rnd = ThreadLocalRandom.current();
		
		for (int i=deck.size() - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Card card = deck.get(index);
			deck.set(index, deck.get(i));
			deck.set(i, card);
		}
	}
	
}
