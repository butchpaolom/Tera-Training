import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Fisherman fisherman = new Fisherman();
		boolean isStaying = true;
		while (isStaying) {
			System.out.println("Fisherman, what do you want to do?!");
			System.out.println("1. Catch Seafood");
			System.out.println("2. Eat Fish");
			System.out.println("3. Eat Crustacean");
			System.out.println("4. Check Basket");
			System.out.println("5. Go home");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
			case 1:
				fisherman.catchSeafood();
				break;
			case 2:
				fisherman.eatFish();
				break;
			case 3:
				fisherman.eatCrustacean();
				break;
			case 4:
				fisherman.checkBaskets();
				break;
			case 5:
				isStaying=false;
				break;
			default:
				break;
			}
		}

	}
};