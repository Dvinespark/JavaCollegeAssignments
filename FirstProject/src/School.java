
public class School {
	
	public static void main(String[] args) {
		// Entry point of a program
		School.hypervisor();

	}
	
	static void hypervisor() {
		// method choreography
		Student s = new Student("Subash");
		String output = s.sayHello();
		System.out.println(output);
		
	}

}


