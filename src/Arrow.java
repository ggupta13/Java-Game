import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Arrow extends GameObj
{
	private static BufferedImage img;
	public static final int SIZE = 40;
	public static final int INIT_X = 170;
	public static final int INIT_Y = 170;
	public static final int INIT_VEL_X = 0;
	public static final int INIT_VEL_Y = 0;
	public static int mouseX, mouseY;
	public static String color;
	
	public Arrow(int courtWidth, int courtHeight, int x, int y) 
	{
		super(INIT_VEL_X, INIT_VEL_Y, x, y, 
				30, 20, courtWidth, courtHeight);
		
		this.color = color;
		
		try 
		{
			if (img == null) 
			{
				img = ImageIO.read(new File("right_arrow.png"));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
	public static BufferedImage rotate(BufferedImage image, double angle) {
	    double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
	    int w = image.getWidth(), h = image.getHeight();
	    int neww = (int)Math.floor(w*cos+h*sin), newh = (int)Math.floor(h*cos+w*sin);
	    GraphicsConfiguration gc = getDefaultConfiguration();
	    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
	    Graphics2D g = result.createGraphics();
	    g.translate((neww-w)/2, (newh-h)/2);
	    g.rotate(angle, w/2, h/2);
	    g.drawRenderedImage(image, null);
	    g.dispose();
	    return result;
	}
	
	public static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
	
	@Override
	public void draw(Graphics g)
	{
		double val = (double)(-1.0*mouseY) / mouseX;
		double angle = Math.atan(val);
		BufferedImage n = rotate(img,Math.PI/2 + angle*2);
		 g.drawImage(n, pos_x, pos_y, width, height, null); 
	}
}
