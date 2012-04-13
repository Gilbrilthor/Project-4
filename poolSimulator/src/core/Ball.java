/**
 * ---------------------------------------------------------------------------
 * File name: Ball.java<br/>
 * Project name: poolSimulator<br/>
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matthew Paul, paulmr@goldmail.etsu.edu<br/>
 * Course:  CSCI 1260-088<br/>
 * Creation Date: Mar 26, 2012<br/>
 * Date of Last Modification: Mar 26, 2012
 * ---------------------------------------------------------------------------
 */

package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Represents a pool ball<br>
 *
 * <hr>
 * Date created: Mar 26, 2012<br>
 * Date last modified: Mar 26, 2012<br>
 * <hr>
 * @author Matthew Paul
 */
public class Ball
{
	private static final double	DEFAULT_X	= 0;

	private static final double	DEFAULT_Y	= 0;

	private double locX,
		   		   locY,
		   		   velX,
		   		   velY;
	
	private Color ballColor;
	
	private BallNumber ballNumber;
	
	private boolean pocketed;
	
	final double BALL_MASS = 0.163,			// The weight of the ball, in Kilograms
				 BALL_RADIUS = 0.05715;		// The radius of the ball, in meters
	
	private BufferedImage ballImage = null;
	
	/**
	 * @return locX
	 */
	public double getLocX()
	{
		return locX;
	}

	/**
	 * @param locX the locX to set
	 */
	public void setLocX(double locX)
	{
		this.locX = locX;
	}

	/**
	 * @return locY
	 */
	public double getLocY()
	{
		return locY;
	}

	/**
	 * @param locY the locY to set
	 */
	public void setLocY(double locY)
	{
		this.locY = locY;
	}

	/**
	 * @return velX
	 */
	public double getVelX()
	{
		return velX;
	}

	/**
	 * @param velX the velX to set
	 */
	public void setVelX(double velX)
	{
		this.velX = velX;
	}

	/**
	 * @return velY
	 */
	public double getVelY()
	{
		return velY;
	}

	/**
	 * @param velY the velY to set
	 */
	public void setVelY(double velY)
	{
		this.velY = velY;
	}

	/**
	 * @return ballColor
	 */
	public Color getBallColor()
	{
		return ballColor;
	}

	/**
	 * @param ballColor the ballColor to set
	 */
	public void setBallColor(Color ballColor)
	{
		this.ballColor = ballColor;
	}

	/**
	 * @return ballNumber
	 */
	public BallNumber getBallNumber()
	{
		return ballNumber;
	}

	/**
	 * @param ballNumber the ballNumber to set
	 */
	public void setBallNumber(BallNumber ballNumber)
	{
		this.ballNumber = ballNumber;
	}

	/**
	 * @return isPocketed
	 */
	public boolean isPocketed()
	{
		return pocketed;
	}

	/**
	 * @param isPocketed the isPocketed to set
	 */
	public void setPocketed(boolean isPocketed)
	{
		this.pocketed = isPocketed;
	}

	/**
	 * @return bALL_MASS
	 */
	public double getBALL_MASS()
	{
		return BALL_MASS;
	}

	/**
	 * @return bALL_RADIUS
	 */
	public double getBALL_RADIUS()
	{
		return BALL_RADIUS;
	}

	
	/**
	 * Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 */
	public Ball()
	{
		initializeDefaultValues();
	}

	/**
	 * Initializes the ball with default values <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 */
	private void initializeDefaultValues()
	{
		setLocX(DEFAULT_X);
		setLocY(DEFAULT_Y);
		
		setVelX(0);
		setVelY(0);
		
		setBallColor(Color.gray);
		
		setBallNumber(BallNumber.EIGHT);
		
		setPocketed(false);
		
		loadImage();
	}
	
	
	private void loadImage()
	{
		try
		{
			ballImage = ImageIO.read(new File("resources/ballSmall.gif"));
			
		}
		catch (IOException e)
		{
			System.out.println("Error! Ball image file load failed! " + e.getMessage( ));
		}
	}

	/**
	 * Copy Constructor <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param copy
	 */
	public Ball(Ball copy)
	{
		setLocX(copy.getLocX( ));
		setLocY(copy.getLocY( ));
		
		setVelX(copy.getVelX( ));
		setVelY(copy.getVelY( ));
		
		setBallColor(copy.getBallColor( ));
		
		setBallNumber(copy.getBallNumber( ));
		
		setPocketed(copy.isPocketed( ));
	}
	
	/**
	 * Moves the ball according to how much time has passed <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param deltaTime
	 */
	public void moveBall(long deltaTime)
	{
		// calculate velocity
		double dX = getVelX( ) * deltaTime / 1000 * 292,	// multiplying by 292 to convert meters to pixels. 
			   dY = getVelY( ) * deltaTime / 1000 * 292;	// Based on size of 1.37 m for width of table.
		
		if (Math.abs(getVelX()) < 1e-4)
			dX = 0;
		
		if (Math.abs(getVelY()) < 1e-4)
			dY = 0;
		
		
		// apply friction
		applyFriction(deltaTime);
		
		// apply velocity to ball
		setLocX(getLocX( ) + dX);
		setLocY(getLocY( ) + dY);
	}

	/**
	 * Applies the correct amount of friction based on time elapsed <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param deltaTime
	 */
	private void applyFriction(long deltaTime)
	{
		double coefficient = 0.2,
			   gravity = 9.8;
		
//		calculate the force of the friction on the ball
		double retardingForceX,
			   retardingForceY;
		if (Math.abs(getVelX( )) > 1e-4)
		{
			retardingForceX = coefficient *
							gravity *
							deltaTime *
							( getVelX( ) / Math.abs(getVelX( )) / 1000);
		}
		else
			retardingForceX = 0.0;
		
		if (Math.abs(getVelY( )) > 1e-4)
		{
			retardingForceY = coefficient *
							gravity *
							deltaTime *
							( getVelY( ) / Math.abs(getVelY( ))) / 1000;
		}
		else
			retardingForceY = 0.0;
		
		
		
		setVelX(getVelX() - retardingForceX);
		setVelY(getVelY() - retardingForceY);
	}
	
	/**
	 * Collides with a second ball. <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param ball
	 */
	private void collide(Ball ball)
	{
		
	}
	
	/**
	 * Draws the ball <br>        
	 *
	 * <hr>
	 * Date created: Apr 12, 2012 <br>
	 * Date last modified: Apr 12, 2012 <br>
	 *
	 * <hr>
	 * @param g
	 */
	public void drawBall(Graphics g)
	{
		g.setColor(getBallColor( ));
		g.drawImage(ballImage, (int)(getLocX() - 8.5), (int)(getLocY() - 8.5), null);
		
		g.setColor(Color.BLACK);
		
		if (Math.abs(getVelX( )) < 1 && Math.abs(getVelY()) < 1)
			g.drawString(ballNumber.toString( ), (int)getLocX( ) + 10, (int)getLocY( ) + 10);
	}

}
