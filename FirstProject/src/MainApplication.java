
public class MainApplication {
	// This class is not the part of algorithm designer
	// This class is just a container for static void main method
	// This function is the entry point
	static String[] cars = {"Ford", "Tesla", "BMW"};
	public static void main(String[] args) {
		
		System.out.println("Hello world!");

		
		for (int counter=0; counter <3; counter++) {
			System.out.println(cars[counter]);
		}
		
		
		int[][] myNumbers = {{1,2,},{3,4,5}};
		System.out.println(myNumbers[1][0]);
		
		for (int i=0; i < myNumbers.length; ++i) {
			for (int j=0; j< myNumbers[i].length; j++) {
				System.out.println(myNumbers[i][j]);
			}
		}
	}
}
