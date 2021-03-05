package edu.cuny.csi.csc330.project;

import java.util.Random;
import java.util.Scanner;

import edu.cuny.csi.csc330.swing.EventsDemo;

public class Event {
	private Random rand = new Random();
	private boolean isAmbushed = false;
	private boolean hasHouse = false;
	private Player eUser = Player.getInstance();
	private Monsters monster;
	private String[] goodEvents = {"You found a chest with a good item! +1"/*something*/,"You found a potion! +1 Base Health"
			/*Change base health*/,	"You’ve helped a stranger and they gave you a stat buff!"/*What stat buff?*/, "A bar fight "
			+ "starts and people are placing bets, you accidentally place bets on the short kid \nand end up winning the whole pot."
			+ " Also advice for the future, dwarves don’t mess around."/*Currency number*/};
	private String [] neutralEvents = {"When you weren’t looking, wolves made off with your food!","You see a funny looking rock. "
			+ "You examine it real hard to find out... it’s a rock! What a surprise!", "You see a shadow in the corner of your eye."
			+ " You, against reason, follow the shadow, getting yourself \nlost. You spend some time wandering to find the path again.",
			"You find yourself in a small town and someone is playing the didgeridoo. You think what if they \ndidgeri-didn't?", "You"
			+ " stop to rest for a while and when you wake you you find a Pegasus drinking from the river \nnearby. You try to get a "
			+ "closer look but you startle it and it takes off into the sky. So majestic."};
	private String[] badEvents = {"Enemy will have a health increase!" /*What damage*/, "Taken an arrow to the knee! -1 Hp"
					/*Decrease health*/, "You find a tavern and have a feast! You got food poisoning. base hp - 1"
					/*Set take away 1*/, "You see a little ball of light.... then another... and another! They’re so pretty and warm "
					+ "looking. \nYou start to follow these small balls of light into the forest. You reach out to touch one and "
					+ "\nit’s warm... \n\nYou find yourself weak in the forest alone, the lights dissipate... hp=1"/*Make health equal 1*/ };
	private String[] allMonsters = {"Ork","Goblin","Skeleton","Succubus","Incubus","Mimic","Dark Knight"};
	private String [] bossEvents = {"As you settle down for a rest in Bippy village, you hear whispers of a terrible beast who \nis "
					+ "the cause of panic to the people of the village. Even the knights of this area are \nscared to take on this beast! "
					+ "For it is said that if you dare take on this creature, you will \nnever return. \nDo YOU want to risk life and limb to "
					+ "take on this task for the good of the people? [Y]/[N]", "Legend tells of a creature, that lives in the lake of Lerna. A "
					+ "creature whose said \nto be huge and have three snake like heads. That place, is close to where you stand now. "
					+ "\nWill YOU be the slayer of this creature? [Y]/[N]", "It causes the earth to shiver. A titan has awakened and it is "
					+"angry. Many innocents may \nbe harmed if the quaking of the earth continues. \nWill you take on the mantle and defeat "
					+ "this titan? [Y]/[N]"};
		
	
	 Event() 
	{	 
		int randNum = rand.nextInt(13);
		if(randNum >= 0 && randNum <= 1)
		goodRNG();
		
		else if(randNum >= 2&&randNum <= 3)
			neutralRNG();
			
		
		
		else if (randNum >= 4 &&randNum <= 5)
			badRNG();
		
		else if (randNum >= 6&&randNum <= 11) 
			whoAmbushed();
		
		else
			bossFight();
			
		
		if (eUser.getCurrency()>=50000)
		{
			 Scanner userInput = new Scanner(System.in);
			 String input;
			randNum = rand.nextInt(4);
			if (randNum == 3)
			{
				System.out.println("");
				System.out.print("You've saved up quite a bit of money! Maybe you can buy a house! Do you want to buy "
						+ "\na house? [Y] [N]");
				System.out.println("");
				input=userInput.nextLine();
				
				if(input.charAt(0) == 'Y'||input.charAt(0) == 'y')
				{
					if (eUser.getMedalCounter()>=3)
					{
						eUser.getMedals();
						eUser.medalWin();
						System.exit(0);
					}
					else {
						System.out.print("You've bought a house and found your own home!\nCongratulations on getting the good ending 1 of 2!");
						System.exit(0);}
				}
				
				else 
					System.out.print("Oh, that's unfortunate. Next time maybe!");
			}
		}
		System.out.println(" [Press Enter to Continue]");
		
	}
	
	private void bossFight()  {
		
		int number = eUser.getMedalCounter();
		 Scanner userInput = new Scanner(System.in);
		 String input;
		 if(number < 3) {
		 System.out.print(bossEvents[number]);
		 System.out.println("");
		input=userInput.nextLine();
		
		if(input.charAt(0) == 'Y'||input.charAt(0) == 'y')
		{
			System.out.print("You're a brave soul "+eUser.getPlayerName()+"! Well, I hope you're as skillful as you are brave.");
			if(number==0)
			{
				monster= new Monsters("Dragon");
			}
			
			else if(number==1)
			{
				monster= new Monsters("Hydra");
			}
			
			else if(number==2)
			{
				monster= new Monsters("Rock Titan");
			}
			isAmbushed = true;
		}
		else 
			System.out.print("That is probably the wisest choice. Doing something brave today means death in a few hours after all.");
		}
	}



	private void goodRNG() 
	{
		int number = rand.nextInt(goodEvents.length);
		int randExtra; 
	
		//Good item
		if (number == 0)
		{
			randExtra = rand.nextInt(2);
			
			if(randExtra == 0)
			{	
				eUser.setBaseAttack(eUser.getBaseAttack()+1);
				System.out.print(goodEvents[number]+" Attack");
			}
			
			else if(randExtra == 1)
			{	
				eUser.setBaseDefense(eUser.getBaseDefense()+1);
				System.out.print(goodEvents[number]+" Defense");
			}
			
				
		}
		
		//Base health up
		else if (number == 1)
		{
			eUser.setBaseHealth(eUser.getBaseHealth()+1);
			System.out.print(goodEvents[number]);
		}
			
		//Stat up
		else if (number == 2)
		{
			randExtra = rand.nextInt(3);
			if (randExtra == 0) 
			{
				eUser.setBaseHealth(eUser.getBaseHealth()+1);
				System.out.print(goodEvents[number]+" +1 Base Health");
			}
			
			else if (randExtra == 1) 
			{
				eUser.setBaseAttack(eUser.getBaseAttack()+1);
				System.out.print(goodEvents[number]+" +1 Base Attack");
			}
			
			else if (randExtra == 1) 
			{
				eUser.setBaseDefense(eUser.getBaseDefense()+1);
				System.out.print(goodEvents[number]+" +1 Base Defense");
			}
			
		
		}
		
		//currency
		else if (number == 3)
		{
			eUser.setCurrency(eUser.getCurrency()+5000);
			System.out.print(goodEvents[number]+" "+eUser.getCurrency()+" Currency");
		}
			
	}
	
	
	private void neutralRNG()
	{
		int number = rand.nextInt(neutralEvents.length);
		System.out.print(neutralEvents[number]);
		
	}

	private void badRNG() 
	{
		int number = rand.nextInt(badEvents.length);
		//Enemy Buff...
		if (number == 0)
		{
			monster.setHealth(monster.getHealth()+1);
		}
		
		//Arrow to knee
		else if (number == 1)
		{
			eUser.setCurrentHealth(eUser.getCurrentHealth()-1);
		}
		//Food Poisioning	
		else if (number == 2)
		{
			eUser.setCurrentHealth(eUser.getCurrentHealth()-1);
		}
		else if (number == 3)
		{
			eUser.setCurrentHealth(1);
		}
		System.out.print(badEvents[number]);
	}

	
	void whoAmbushed() 
	{
		int number = rand.nextInt(allMonsters.length);
		isAmbushed = true;
		monster = new Monsters(allMonsters[number]);
		System.out.print("Uh oh! You ran into something!");
		
		
	}
	
	
	
	public boolean isAmbushed() {
		return isAmbushed;
	}

	
	public void setAmbushed(boolean isAmbushed) {
		this.isAmbushed = isAmbushed;
	}

	public Monsters getMonster() {
		return monster;
	}
	
	public boolean hasHouse()
	{
		return hasHouse; 
	}
}



