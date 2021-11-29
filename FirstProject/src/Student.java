
public class Student {
	String studentName;
	public Student(String name) {
		this.studentName = name;
	}

	
	public String sayHello() {
		System.out.println(this.toString());
		return this.studentName;
	}
}
