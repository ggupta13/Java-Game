import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Balloon extends GameObj
{
	private static BufferedImage img;
	public static final int SIZE = 40;
	public static final int INIT_X = 170;
	public static final int INIT_Y = 170;
	public static final int INIT_VEL_X = 0;
	public static final int INIT_VEL_Y = 0;
	public static String color;
	
	public Balloon(int courtWidth, int courtHeight, String color, int x, int y) 
	{
		super(INIT_VEL_X, INIT_VEL_Y, x, y, 
				30, 212/5, courtWidth, courtHeight);
		
		this.color = color;
		
		try 
		{
			if (img == null) 
			{
				if(color.equals("black"))
					img = ImageIO.read(new File("black_balloon.png"));
				else if(color.equals("red"))
					img = ImageIO.read(new File("red_balloon.png"));
				else if(color.equals("blue"))
					img = ImageIO.read(new File("blue_balloon.png"));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
	
	
	
	@Override
	public void draw(Graphics g)
	{
		
		 g.drawImage(img, pos_x, pos_y, width, height, null); 
	}
}
