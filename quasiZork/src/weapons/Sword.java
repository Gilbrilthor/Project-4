package weapons;
/**
 * ---------------------------------------------------------------------------
 * File name: Sword.java<br/>
 * Project name: 1260-088-PROJECT4-MiddaughStephen<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Stephen Middaugh, middaughs@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260<br/>
 * Creation Date: Mar 13, 2012<br/>
 * Date of Last Modification: Mar 13, 2012
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here<br>
 *
 * <hr>
 * Date created: Mar 13, 2012<br>
 * Date last modified: Mar 13, 2012<br>
 * <hr>
 * @author Stephen Middaugh
 */
public class Sword extends Weapon
{
	private static final String	DEFAULT_NAME	= "sword";
	private static final double	DEFAULT_DAMAGE	= 3;

	/**
	 * No-Args Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 */
	public Sword ()
	{
		super (DEFAULT_NAME, DEFAULT_DAMAGE);
	}
	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 13, 2012 <br>
	 *
	 * <hr>
	 * @param name
	 * @param damage
	 */
	public Sword (String name, double damage)
	{
		super (name, damage);
	}

	
	/**
	 * gets the damage modifier of the sword. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @return
	 * @see Weapon#getDamage()
	 */
	@Override
	public int getDamage ( )
	{
		return 3;
	}
	
	/**
	 * returns the name of the sword the player will see. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the name of the sword the player will see. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * sets the damage modifier of the sword. <br>        
	 *
	 * <hr>
	 * Date created: Mar 13, 2012 <br>
	 * Date last modified: Mar 14, 2012 <br>
	 *
	 * <hr>
	 * @param damage
	 */
	public void setDamage(double damage)
	{
		this.damage = damage;
	}

	
	

}