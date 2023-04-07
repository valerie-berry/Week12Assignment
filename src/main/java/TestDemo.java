import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} else {
			return a + b;
		}
	}
	
	public int randomNumberSquared() {
		int r = getRandomInt();
		return r*r;
	}
	
	int getRandomInt() {
		Random r = new Random();
		return r.nextInt(10) + 1;
	}
}
