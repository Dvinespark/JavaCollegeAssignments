/*
 
 * Subash Sapkota
 * C0824340
 * Writing the Card Class for the FIZBIN card game
 * 2021F CSD 3464 2 [A207] Programming Java SE
 * September 27 2021 / 8AM
 
 */


import java.util.*;
import java.io.File; // import the file class
import java.io.FileNotFoundException;	// import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;

public class MainApplication {

	public static void main(String[] args) {
		// Entry point of program
		System.out.println("Welcome to our game: ");
		
		TheTable cardTable = new TheTable();
		cardTable.GenerateTheCardDeck();
		cardTable.DisplayTheDeck();
		
	}
}

class TheTable {
	
	int CardPositionInDeck = 0;
	int NameCardPosition = 0;
	CardDeck deck = new CardDeck();
	String[] suites = {"Clubs", "Diamonds", "Hearts", "Spades" };
	
	
	public void DisplayTheDeck() {
		try {
			FileWriter writer = new FileWriter("C:\\Users\\longe\\Desktop\\2nd Semester\\Java\\JavaProgrammingWorkspace\\Fizbin\\cards-" + (new Date()).getSeconds() + ".txt", true);
			
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
		
		for (int suiteNumber = 0; suiteNumber < suites.length; suiteNumber++) {
			populateTheDeck(suiteNumber);
		}
	}
	
	public void populateTheDeck(int suiteNumber) {
		deck._cardDeck.add(new Card(suites[suiteNumber], "Ace"));
		
		for (int cardValue = 2; cardValue <= 10; cardValue++) {
			deck._cardDeck.add(new Card(suites[suiteNumber], String.valueOf(cardValue)));
		}
		
		deck._cardDeck.add(new Card(suites[suiteNumber], "Jack"));
		deck._cardDeck.add(new Card(suites[suiteNumber], "Queen"));
		deck._cardDeck.add(new Card(suites[suiteNumber], "King"));
		
	}
		
}

class CardDeck {
	public ArrayList<Card> _cardDeck = new ArrayList();
}

class Card {
	
	String suite;
	String faceValue;
	// Constructor
	Card(String suite, String faceValue){
		this.suite = suite;
		this.faceValue = faceValue;
		
	}
	
	public String toString() {
		return this.suite + " " + this.faceValue;
	}
	
}


/* Output -> cards-58.txt
Clubs Ace
Clubs 2
Clubs 3
Clubs 4
Clubs 5
Clubs 6
Clubs 7
Clubs 8
Clubs 9
Clubs 10
Clubs Jack
Clubs Queen
Clubs King
Diamonds Ace
Diamonds 2
Diamonds 3
Diamonds 4
Diamonds 5
Diamonds 6
Diamonds 7
Diamonds 8
Diamonds 9
Diamonds 10
Diamonds Jack
Diamonds Queen
Diamonds King
Hearts Ace
Hearts 2
Hearts 3
Hearts 4
Hearts 5
Hearts 6
Hearts 7
Hearts 8
Hearts 9
Hearts 10
Hearts Jack
Hearts Queen
Hearts King
Spades Ace
Spades 2
Spades 3
Spades 4
Spades 5
Spades 6
Spades 7
Spades 8
Spades 9
Spades 10
Spades Jack
Spades Queen
Spades King
*/