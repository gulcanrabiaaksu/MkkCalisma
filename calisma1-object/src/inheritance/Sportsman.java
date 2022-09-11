package inheritance;

public class Sportsman {
	
	
	/**
	 * Fields tanimlandi.
	 */
	public String name;
	public int age;
	public String team;
	
	public Sportsman (String name, int age, String team) {
		this.age=age;
		this.name=name;
		this.team=team;
			
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void introduce() {
		System.out.println("I'm a sportman.");
	}
	
	public void tellAge() {
		 System.out.println(" I am " + this.age + "years old");
	}
}
