package chatty;

import java.util.Scanner;

public class ChatDriver {
	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);

		System.out.println("Username: ");
		String un1 = in.nextLine(); 
		ChatScreen user1 = new ChatScreen(un1);
		user1.setUpGUI();
		
		System.out.println("Username: ");
		String un2 = in.nextLine(); 
		ChatScreen user2 = new ChatScreen(un2);
		user2.setUpGUI();
		
		user1.anotherUser(user2);
		user2.anotherUser(user1);
		
		in.close(); 
	}
}
