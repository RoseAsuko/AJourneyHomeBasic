package edu.cuny.csi.csc330.project;

import java.util.Scanner;

public class JourneyHome {
	
		
	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		 Player user= Player.getInstance();
		 Monsters monster;
		 String userName, input;
		 Event event;
		 
		 Scanner userInput = new Scanner(System.in);
		
		
		 
		System.out.print("You wake up to find yourself in an unfamiliar place. Where are you? WHO are you? \nWhat is your name?");
		System.out.println(""); 
		userName = userInput.nextLine();
		 user.setPlayerName(userName);
		System.out.println("");
		 
		 System.out.print( user.getPlayerName()+". Your name is "+ user.getPlayerName()+". Remembering, you sigh a breath of relief, "
		 		+ "but you still don't\nknow where you are. Find your way home. [Press Enter to Continue]");
		 System.out.println("");
		
		 input = userInput.nextLine();
		
		 
		
		 do {
			 
			  event = new Event();
			  input = userInput.nextLine();
			 
			  if (event.isAmbushed())
			  {
				  monster = event.getMonster();
				  event.setAmbushed(false);
				  new Combat(monster);
			  }
			
			
			 if (!input.equals("")) {
			if (input.charAt(0) == 'S')
				{
					 System.out.print(user.getPlayerName());
					 System.out.println("");
					 Thread.sleep(500);
					 user.displayAllStats();
				}
			 
			 }
			 
		 }while (true);
		
	
	}

}



