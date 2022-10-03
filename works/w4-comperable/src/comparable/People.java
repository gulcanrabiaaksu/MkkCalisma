package comparable;

public class People implements Comparable <People> { //Comparable classindaki people objelerini implemente/kontrol ediyoruz.

	private String name;
	private String surname;
	private int age;
	
	
	public People( String name, int age) {
		super();
		this.name = name;
		this.surname = " ";
		this.age = age;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public int compareTo(People o) {
		if(o instanceof People) { // People instance ise 
			People other = (People) o;
			
				if(this.age > other.getAge()) {
					return 1;
					
				}
				else if(this.age < other.getAge()){
					return -1;
				}
				else {
					
					return 0;
				}
		}return 0;
	}
}


