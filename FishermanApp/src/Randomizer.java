
public abstract class Randomizer {
	public static int range(int min, int max) {
		return (int)(Math.random() * ((max - min) + 1) + min);
	}
	
	public static int integer(int max) {
		return (int)(Math.random() * max);
	}
	
	public static Object arrays(Object[] array) {
		int randomIndex = (int)(Math.random() * (array.length) + 1);
		return array[randomIndex];
	}
	
	public static Class<?> arrays(Class<?>[] array) {
		int randomIndex = (int)(Math.random() * array.length);
		return array[randomIndex];
	}
}
