package inheritance;

public class Run {
	
	public static void main(String[] args) {
		Sportsman sporcu= new Sportsman("Alex", 35, "Fenerbahçe");
		sporcu.introduce();
		System.out.println("***********");
		SoccerPlayer futbolcu= new SoccerPlayer ("Alex", 35, "Fenerbahçe",20,15);
		futbolcu.introduce();
		System.out.println("***********");
		BasketballPlayer jordan= new BasketballPlayer("Jordan", 40, "Chicago",32.3,7);
		jordan.playerName();
		System.out.println("***********");
		jordan.introduce();
		System.out.println("***********");
		System.out.println(jordan.getName());
		System.out.println("***********");
		System.out.println(futbolcu.getName());
		System.out.println("***********");
		jordan.setName("Barkley");
		System.out.println(jordan.getName());
	}
}
