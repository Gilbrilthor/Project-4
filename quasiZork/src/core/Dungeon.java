package core;


import java.util.Random;
import weapons.Stick;
import weapons.Sword;
import weapons.Weapon;
import monsters.Monster;

/**
 * Represents a collection of rooms that make up a dungeon.<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */

public class Dungeon
{
	private int playerLocation;	// The players location in the dungeon. 0 = start.
	private Room[] rooms;	// The collection of rooms for the player to travel through.
	private Player player;
	
	
	
	/**
	 * Constructor <br>        last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 */
	public Dungeon()
	{
		Random rand = new Random();
		rooms = new Room[rand.nextInt(6) + 5];
	}
	
	/**
	 * Populates the dungeon with both monsters and a weapon. <br>        
	 *
	 * <hr>
	 * Date created: Mar 14, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 */
	public void populateDungeon()
	{
//		create the random number generator to be used for this method
		Random rand = new Random();
		
//		for each room other than the starting room, randomly decide if there is a monster
		for (int i = 1; i < rooms.length; i++ )
		{
//			there is an approximately 50% chance for a monster to be there
			if (rand.nextBoolean( ))
			{	
				rooms[i].setMonster(new Monster());
			}
		}
		
//		Generate a random weapon to store in the dungeon
		Weapon weapon;
		if (rand.nextBoolean( ))
		{
			weapon = new Sword();
		}
		else
			weapon = new Stick();
		
//		put a weapon randomly in a cell other than the start cell
		rooms[rand.nextInt(rooms.length - 1) + 1].setWeapon(weapon);
		
	}
	
	/**
	 * Simulates a battle between the player and the monster in this room. <br>        
	 *
	 * <hr>
	 * Date created: Mar 15, 2012 <br>
	 * Date last modified: Mar 15, 2012 <br>
	 *
	 * <hr>
	 * @param roomIndex 
	 * @return whether or not the player is alive
	 */
	public boolean battle(int roomIndex)
	{
		Monster monster = rooms[roomIndex].getMonster( );
		
		while(monster.getHealth( ) > 0 && player.getHealth( ) > 0)
		{
			int damage = player.attack( );
			monster.takeDamage(damage);
			
			if (monster.getHealth( ) > 0)
			{
				damage = monster.attack();
				player.takeDamage(damage);
			}
			
		}
		
		if (player.getHealth( ) > 0)
			return true;
		else
			return false;
	}
	
	public String toString()
	{
		return null;
	}
}
