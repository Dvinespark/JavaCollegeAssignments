
public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		M m = new M();
		m.generate(3);
      

	}

}

class M {
	public void generate(int k ) {
		int j;
		for (j = 0; j< 6; j++) {
			j+= k*2;
		}
		System.out.println(j);
	}
}