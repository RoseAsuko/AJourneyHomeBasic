package edu.cuny.csi.csc330.project;

public class Player {

	private static Player singlePlayer = null;
	private String playerName;
	private int baseHealth = 3;
	private int baseAttack = 1;
	private int baseDefense = 1;
	private int currentHealth = 3;
	private int currentAttack = 0;
	private int currentDefense = 1;
	private int magic = 1 ;
	private int currency = 0;
	private String [] medals = new String [3];
	private int medalCounter = 0;
	
	

	private Player()
	{
		setPlayerName("You");
	}
	
	private Player(String name)
	{
		setPlayerName(name);
	}
	
	public static Player getInstance()
	{
		if (singlePlayer == null)
			singlePlayer = new Player();
		return singlePlayer;
	}

	public static Player getInstance(String Name)
	{
		if (singlePlayer == null)
			singlePlayer = new Player(Name);
		return singlePlayer;
	}
	//Money
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}

	
	//The health that will be decreased when attacked
	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	
	//Overall maximum Health
	public int getBaseHealth() {
		return baseHealth;
	}

	public void setBaseHealth(int baseHealth) {
		this.baseHealth = baseHealth;
	}


	//Overall maximum Attack
	public int getBaseAttack() {
		return baseAttack;
	}

	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	
	//Overall maximum Defense
	public int getBaseDefense() {
		return baseDefense;
	}

	public void setBaseDefense(int baseDefense) {
		this.baseDefense = baseDefense;
	}

	
	//These can be above the base if there is a temporary stat buff
	//Or below if there's a disadvantage like a weaker attack
	public int getCurrentAttack() {
		return currentAttack;
	}

	public void setCurrentAttack(int currentAttack) {
		this.currentAttack = currentAttack;
	}

	
	public int getCurrentDefense() {
		return currentDefense;
	}

	public void setCurrentDefense(int currentDefense) {
		this.currentDefense = currentDefense;
	}

	
	//For the hero ending if we have time
	//Maybe we can make more big monsters and once 
	//the player has 3 they have the hero title
	public String [] getMedals() {
		return medals;
	}

	public void setMedals(String medals) {
		this.medals[medalCounter] = medals;
		medalCounter++;
	}
	
	public int getMedalCounter() {
		return medalCounter;
	}

	public void setMedalCounter(int medalCounter) {
		this.medalCounter = medalCounter;
	}
	
	public void medalWin() 
	{
		if (getMedalCounter()==3)
		{
			System.out.print("You have collected 3 medals and became a legend!");
			System.out.println("");
			System.out.print("Congratulations on getting the good ending 2 of 2!");
			
			System.exit(0);
		}

	}

	
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}

	//health and new health
	void displayStats()
{
		System.out.println(playerName +"\t"+ currentHealth +" Hp");
		
}
	void displayAllStats()
	{
		System.out.println("Base Health: "+ baseHealth);
		System.out.println("Current Health: "+ currentHealth);
		System.out.println("Attack: "+ currentAttack);
		System.out.println("Defense: "+ currentDefense);
		System.out.println("Currency: "+ currency);
	}
}



