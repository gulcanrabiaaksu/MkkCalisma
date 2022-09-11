package inheritance;

public class BasketballPlayer extends Sportsman{

	
	public double ppg;
	public double rpg;
	public BasketballPlayer(String name, int age, String team, double ppg, double rpg) {
		super(name, age, team);
		this.ppg = ppg;
		this.rpg = rpg;
	}
	
	public void playerName() {
		System.out.println("Player name" +this.name);
	
	}
}