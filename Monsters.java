package edu.cuny.csi.csc330.project;


public class Monsters {
	private String type;
	private Player mUser = Player.getInstance();
	private int health;
	private int attack;
	private int defense;
	private int magic = 1;
	private int worth;
	private boolean deathStaus = false;
	private boolean metal = false;
	
	//Monsters(){}
	Monsters(String type)
	{
		//Not sure how to implement magic right now
		if (type == "Ork")
		{
			this.type = "Ork";
			
			health = 2;
			attack = 1;
			defense = 1;
			worth = 1500;			
		}
			
		else if(type == "Goblin")
		{	
			this.type = "Goblin";
			
			health = 1;
			attack = 1;
			defense = 1;
			worth = 2600;
			
		}
		
		else if(type == "Skeleton")
		{	
			this.type = "Skeleton";
			
			health = 1;
			attack = 1;
			defense = 1;
			worth = 1600;
			
		}
		
		else if(type == "Succubus")
		{	
			this.type = "Succubus";
			
			health = 3;
			attack = 2;
			defense = 1;
			worth = 2400;
			
		}
		
		else if(type == "Incubus")
		{	
			this.type = "Incubus";
			
			health = 3;
			attack = 1;
			defense = 2;
			worth = 2200;
			
		}
		
		//We need to fix this one later to mimic the player
		else if(type == "Mimic")
		{	
			this.type = "Mimic";
			
			health = mUser.getBaseHealth();
			attack =  mUser.getBaseAttack();
			defense = mUser.getBaseDefense();
			magic = mUser.getMagic();
			worth = 2000;
			
			
		}
		
		else if(type == "Dark Knight")
		{	
			this.type = "Dark Knight";
			
			health = 5;
			attack = 3;
			defense = 3;
			worth = 2400;
			
		}
		
		else if(type == "Rock Titan")
		{	
			this.type = "Stone Giant";
			
			health = 6;
			attack = 2;
			defense = 4;
			worth = 20000;
			metal = true;
		}
		
		else if(type == "Dragon")
		{	
			this.type = "Dragon";
			
			health = 8;
			attack = 4;
			defense = 2;
			worth = 20000;
			metal = true;
		}
		
		else if(type == "Hydra")
		{	
			this.type = "Hydra";
			
			health = 4;
			attack = 5;
			defense = 3;
			worth = 20000;
			metal = true;
		}
		else 
		{
			this.type = "Banana";
			
			health = 1;
			attack = 0;
			defense = 0;
			worth = 20;
			
		}
		
	}
	
	public String getType() {
		return type;
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public boolean isDeathStaus() {
		return deathStaus;
	}
	public void setDeathStaus(boolean deathStaus) {
		this.deathStaus = deathStaus;
	}
	
	public boolean isMetal() {
		return metal;
	}
	
	void displayMonsterStats()
	{
		System.out.println(type +"\t"+ health +" HP");
	}

	public int getWorth() {
		return worth;
	}
	
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}

}
