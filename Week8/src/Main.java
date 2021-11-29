import java.util.*;




public class Main {
	public static void main(String[] args) {
		// Manager manager = new Manager();
		// manager.run();
		(new Manager()).run();
	}
	
}

class Manager {
	ArrayList<Player> players1 = new ArrayList<Player>();
	public void run() {
		
//		Player[] players = new Player[10];
//
//		for (int i=0; i<10; i++) {
//			players[i] = new Player();
//			System.out.println(players[i].getStrength());
//		}
		
		// Another Way of populating players
		for(int i =0; i< 10; i++) {
			this.players1.add(new Player());
		}
		for(Player p: players1) {
			System.out.println(p.getStrength());
		}
		this.doCompetition();
		
	}
	
	public void doCompetition() {
		int winner = 0;
		int c = 10;
		String j = Integer.toString(c);
		for (int i=0; i<9; i++) {
			if (players1.get(i).getStrength() > players1.get(i+1).getStrength()) {
				System.out.format("player %d is stronger with strength %d than player %d with strengh %d\n"
						, i, players1.get(i).getStrength(), i+1, players1.get(i+1).getStrength());
			}
			else {
				System.out.format("player %d is stronger with strength %d than player %d with strengh %d\n"
						, i+1, players1.get(i+1).getStrength(), i, players1.get(i).getStrength());
			}
			
			if (players1.get(winner).getStrength() > players1.get(i+1).getStrength()) {
				continue;
			}
			else {
				winner = i + 1;
				
			}
			
		}
		System.out.format("The strongest player is player: %d with strength %d \n", winner, players1.get(winner).getStrength());
		
		
	}
}


class Player {
	private int strength;
	public Player() {
		this.setStrength();
	}
	
	private void setStrength() {
		Random rand = new Random();
		this.strength = rand.nextInt(100);
	}
	public int getStrength() {
		return this.strength;
	}
}