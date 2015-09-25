package helpers;

public class Die {

	public static int rollDie() {
		return (int) Math.floor(Math.random() * 6 + 1);
	}
}
