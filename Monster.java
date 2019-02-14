import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.JComponent;

public class Monster{
	
	public int xPos = 150;
	public int yPos = 300;
	public int width = 0;
	public int height = 0;
	public int life = 20;
	public boolean idle = true;
	public boolean alive = true;
	public boolean contact = false;

	public BufferedImage image;
	public URL resource = getClass().getResource("slime/idle0.png");

	public Monster(){
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public Monster(int xPass, int yPass){
		xPos = xPass;
		yPos = yPass;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
