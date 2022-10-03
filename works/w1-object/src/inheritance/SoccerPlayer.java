package inheritance;

public class SoccerPlayer extends Sportsman  {
	
	public int goals;
	public int assists;
	
	public SoccerPlayer(String name, int age, String team,int goal, int assist) {
		super(name, age, team);
		this.goals=goal;
		this.assists=assist;
	}
	@Override
	public void introduce() {
		System.out.println("I am a soccer player");
	}
	
}
