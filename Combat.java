package edu.cuny.csi.csc330.project;
import java.util.Random;
import java.util.Scanner;

public class Combat {

	// string will be equal to move option to be compared during combat phase
	// options will be A for attack M for magic and D for defend
	String playersMove;
	int enemyMove;
	private Player cUser = Player.getInstance();
	Monsters cMonster;

	Combat(Monsters monster)  {
		cMonster = monster;
	do 
	{
	combatPhase(playersMove,  enemyMove);
	

}while(deathCheck(cMonster.getHealth())==false);

	
	
	}

		
	
	boolean deathCheck(int deathHealth) {
		if (deathHealth <= 0)
			return true;// if true player or monster returns a bool saying he has died
		else
			return false;// if false player or monster returns a bool saying they are still alive
	}
	//Test this
	void deathOfPlayer(boolean death)  {
		if (death == true) {
			System.out.print("\nSo this is it, you have died. You put up a worthy fight, but sometimes "
					+ "that's just not \nenough on the bright side it's a game you can try again.");
			System.exit(0);
		}
	}

	void deathOfMonster(boolean death)  {
		if (death == true) {
			System.out.print("\n"+"You have defeated " + cMonster.getType());
			if (cMonster.isMetal() == true) {
				cUser.setMedals(cMonster.getType());
			}
			cUser.setCurrency(cMonster.getWorth() + cUser.getCurrency());
			System.out.print("You have earned " + cMonster.getWorth() + " Currency! You have " + cUser.getCurrency() + " Currency!");//currency
			cUser.setMagic(1);
			cMonster.setMagic(1);
			// set up what happens after a fight
		}
	}
 
	int maxHealthCheck(int HcHealth) {
		if (HcHealth > cUser.getBaseHealth())// if current health is greater than max
			return cUser.getBaseHealth();// return max
		else
			return HcHealth;// else return current
	}

	void castMagicPlayer()  {
		Random rand = new Random();
		int number = rand.nextInt(3);// pick a number for a spell
		if (number == 0) {
			int combatHealth = cMonster.getHealth();
			combatHealth = combatHealth - cUser.getMagic();// take the magic level of player during current fight and
															// hit for that much damage
			cMonster.setHealth(combatHealth);
			System.out.print("You shot a fireball that hit for " + cUser.getMagic() + " damage!\n");
			deathOfMonster(deathCheck(combatHealth));// find out if monster died to the hit to end the fight and
														// continue with the game
		} else if (number == 1) {
			int combatHealth = cUser.getCurrentHealth();
			combatHealth = combatHealth + cUser.getMagic();// heals player for mount equal to their magic stat
			combatHealth = maxHealthCheck(combatHealth);// if health is higher than max health set to max
			cUser.setCurrentHealth(combatHealth);
			System.out.print("You cast a defensive spell that combines a barrier and a cure!\n");
		} else if (number == 2) {
			cUser.setMagic(cUser.getMagic() + 1);// increase magic stat by 1
			System.out.print("You experience a surge of power that makes you feel more attune to your magic!\n");
			System.out.print("Magic power level " + cUser.getMagic()+"\n");
		}
	}

	void castMagicMonster()  {
		Random rand = new Random();
		int number = rand.nextInt(3);// pick a number for a spell
		if (number == 0) {
			int combatHealth = cUser.getCurrentHealth();
			combatHealth = combatHealth - cMonster.getMagic();// take the magic level of player during current fight and
																// hit for that much damage
			cUser.setCurrentHealth(combatHealth);
			System.out.print(cMonster.getType() + " struck you with lighting for " + cMonster.getMagic() + " damage!\n");
			deathOfPlayer(deathCheck(combatHealth));// find out if monster died to the hit to end the fight and
														// continue with the game
		} else if (number == 1) {
			int combatHealth = cMonster.getHealth();
			combatHealth = combatHealth + 1;// monster heals 1 always from magic due to no health ceiling on it
			cMonster.setHealth(combatHealth);
			System.out.print(cMonster.getType() + " gained 1 health by drinking a potion!\n");
		} else if (number == 2) {
			cMonster.setMagic(cUser.getMagic() + 1); // increase magic stat by 1
			System.out.print(cMonster.getType() + " powers up with a mystical power!\n");
			System.out.print("Magic power level " + cMonster.getMagic()+"\n");
		}
	}

	void hitPlayer()  {
		int combatHealth = cUser.getCurrentHealth(); // take current health
		combatHealth = combatHealth - cMonster.getAttack();// subtract monsters attack for damage output
		cUser.setCurrentHealth(combatHealth); // set equal to players health to save current health
		System.out.print(cMonster.getType() + " strikes you with a physical attack that deals " + cMonster.getAttack()
				+ " damage!");
		// find out if player died to the hit to end the game
		deathOfPlayer(deathCheck(combatHealth));// find out if player died to the hit to end the game
	}

	// same logic as above but for monster
	void hitMonster()  {
		int combatHealth = cMonster.getHealth();
		combatHealth = combatHealth - (cUser.getCurrentAttack()+1);// deal damage equal to the players attack stat
		cMonster.setHealth(combatHealth);
		System.out.print("You strike with your sword and deal " + (cUser.getCurrentAttack()+1) + " damage!\n");
		deathOfMonster(deathCheck(combatHealth));// find out if monster died to the hit to end the fight and continue
													// with the game
	}

	void drawAttack()  {

		System.out.print("You and " + cMonster.getType() + " both swing wildly, clacking weapons and as they "
				+ "ricochet off each other!\nYou both get hit by your own weapons taking 1 damage!\n");
	
		int combatHealth = cUser.getCurrentHealth(); // take current health
		combatHealth = combatHealth - 1;// remove 1 health for attack tie
		cUser.setCurrentHealth(combatHealth);
		int enemyCombatHealth = cMonster.getHealth(); // take current health
		enemyCombatHealth = enemyCombatHealth - 1;// remove 1 health for attack tie
		cMonster.setHealth(enemyCombatHealth);
		deathOfPlayer(deathCheck(combatHealth));
		deathOfMonster(deathCheck(enemyCombatHealth));// find out if monster died to the hit to end the fight and
														// continue
		// with the game
		
}
	void drawMagic()  {

		castMagicPlayer();// player uses their spell
		if(deathCheck(cMonster.getHealth())==false) {
		castMagicMonster();// monster uses their spell
		System.out.print("Good thing those spells did not intertwine,\n "
				+ "legend has it that when spell collide both casters will be shape shifted! ");}
	}

	void drawDefense()  {
		int combatHealth = cUser.getCurrentHealth(); // take current health
		combatHealth = combatHealth + 1;// add 1 health for defense tie
		combatHealth = maxHealthCheck(combatHealth);// if health is higher than max health set to max
		cUser.setCurrentHealth(combatHealth);
		int enemyCombatHealth = cMonster.getHealth(); // take current health
		enemyCombatHealth = enemyCombatHealth + 1;// add 1 health for defense tie
		cMonster.setHealth(enemyCombatHealth);
		System.out.print("What? Are you both too scared to attack? This fight can't end till some one attacks!");

	}

	void defenseOfPlayer()  {
		int defenseDiffrence = cUser.getCurrentDefense() - cMonster.getAttack();// find out difference between players
																					// defense and enemies attack
		int combatHealth = cUser.getCurrentHealth();
		if (defenseDiffrence <= 0)// if the difference is 0 or less then don't include in math
		{
			combatHealth = combatHealth + 1;
			combatHealth = maxHealthCheck(combatHealth);// if health is higher than max health set to max
			cUser.setCurrentHealth(combatHealth);

		} else// add the difference to the math as they earned more health recovery;
		{
			combatHealth = combatHealth + 1 + defenseDiffrence;
			combatHealth = maxHealthCheck(combatHealth);// if health is higher than max health set to max
			cUser.setCurrentHealth(combatHealth);
		}
		System.out.print("You have countered their attack and had enough time to heal your wound!");
	}

	void defenseOfMonster()  {
		System.out.print(cMonster.getType()+" has stopped your attack with ease, you should be scared how simple that was for them!");
	}

	void combatPhase(String playerMove, int enemyMove)  {
		
		System.out.print("It's time to fight your opponent"+"\n");
		cMonster.displayMonsterStats();
		
		System.out.print("Type A for attack, M for magic, D for defense, or S for your stats(THIS IS CAP SENSITIVE)");


		Random rand = new Random();
		enemyMove = 1 + rand.nextInt(3);// pick monsters move

		Scanner userInput = new Scanner(System.in);

		
		for (int i = 0; i < 1; i--)
		{
			playerMove = userInput.nextLine();
			if (playerMove.charAt(0) == 'A' || playerMove.charAt(0) == 'M' || playerMove.charAt(0) == 'D' || playerMove.charAt(0) == 'S') {
				i=2;
			}
	
		}
		
		
		if (playerMove.charAt(0) == 'A' && enemyMove == 1)// attack draw
		{
			drawAttack();
			cUser.displayStats();// display health
		}

		else if (playerMove.charAt(0) == 'M' && enemyMove == 2)// magic draw
		{
			drawMagic();
			cUser.displayStats();// display health
		}

		else if (playerMove.charAt(0) == 'D' && enemyMove == 3)// defense draw
		{
			drawDefense();
			cUser.displayStats();// display health
		}

		else if (playerMove.charAt(0) == 'A' && enemyMove == 2)// attack the monster
		{
			hitMonster();
			cUser.displayStats();// display health
		}

		else if (playerMove.charAt(0) == 'M' && enemyMove == 1)// attack the player
		{
			hitPlayer();
			cUser.displayStats();// display health
		} else if (playerMove.charAt(0) == 'D' && enemyMove == 1)// player defends
		{
			defenseOfPlayer();
			cUser.displayStats();// display health
		} else if (playerMove.charAt(0) == 'A' && enemyMove == 3)// monster defends
		{
			defenseOfMonster();
			cUser.displayStats();// display health

		} else if (playerMove.charAt(0) == 'M' && enemyMove == 3)// magic cast by player

		{
			castMagicPlayer();
			cUser.displayStats();// display health
		} else if (playerMove.charAt(0) == 'D' && enemyMove == 2)// magic cast by monster
		{
			castMagicMonster();
			cUser.displayStats();// display health
		} else if (playerMove.charAt(0) == 'S') {
			cUser.displayAllStats();
		}

	}


}








