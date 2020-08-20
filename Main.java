import java.util.Scanner;

public class Main {
	
	public static void playGame(ChooseYourAdventure adventure) {
		Scanner input = new Scanner(System.in);
		
		Elements current = adventure.root;
		
		System.out.println(adventure.root.storyline[0]);
		
		while(!current.Ending) {
			String in = input.next();
			if(in.equals("L")) {
				current = current.left;
				System.out.println(current.storyline[current.visits]);
				current.visits++;
				continue;
			}
			if(in.equals("R")) {
				current = current.right;
				System.out.println(current.storyline[current.visits]);
				current.visits++;
				continue;
			}
			
		}
		input.close();
	}
	public static ChooseYourAdventure createGame() {
		String end [] = {"You lost money" , "You are spared", "You have a story to tell", "You are attacked by a beast"};
		ChooseYourAdventure adventure = new ChooseYourAdventure(10, end, "As you are walking in the jungle, you stumple upon a treasure chest. (R) Open it. "
				+ "(L) Mind your business and keep walking " );
		
		
		Elements thirteen  = new Elements(13, false, "You opened it. (R) Take the money. (L) Close it  ");
		Elements fifteen = new Elements(15,false,"You took the money. (R) Leave the area (L) Put it back");
		
		adventure.addElement(thirteen, adventure.root );
		adventure.addElement(fifteen, adventure.root);
		
		
		adventure.addLink(adventure.root, adventure.firstEnd, 5);
		adventure.addLink(thirteen, adventure.secondEnd, 12);
		adventure.addLink(fifteen, adventure.thirdEnd, 14);
		adventure.addLink(fifteen, adventure.fourthEnd, 16);
		
		return adventure;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to my Game! I Hope you enjoy\n");
		playGame(createGame());
		


	}

}
