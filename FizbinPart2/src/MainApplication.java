import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;

public class MainApplication {
	public static void main(String[] args) {
		System.out.println("Welcome to our game:");

		TheTable cardTable = new TheTable();
		cardTable.GenerateTheCardDeck();
		cardTable.DisplayTheDeck();
	}
}

class TheTable {

	int CardPositionInDeck = 0;
	int NameCardPosition = 0;
	CardDeck deck = new CardDeck();
	String[] suites = { "Clubs", "Diamonds", "Hearts", "Spades" };

	public void DisplayTheDeck() {
		try {
			FileWriter writer = new FileWriter("c:\\data\\cards-"+(new Date()).getSeconds(), true);

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

	private void populateTheDeck(int suiteNumber) {
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
	// ADT Class to define one card
	// what things does a card need to KNOW

	public Card(String _suite, String _cardvalue) {
		this.suite = _suite;
		this.cardvalue = _cardvalue;
	}

	private String suite;
	private String cardvalue;

	public String toString() {
		return this.suite + " " + this.cardvalue;
	}
}

class A {
	{
		i = 1111;
	}
	int i;
}