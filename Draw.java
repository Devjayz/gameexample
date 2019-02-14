import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("run0.png");

public int enemyCount;
	Monster[] monsters = new Monster[10];

	// circle's position
	public int x = 30;
	public int y = 30;

	// animation states
	public int state = 0;

	Monster monster1;
	Monster monster2;
	Monster monster3;
	Monster monster4;
	Monster monster5;
	Monster monster6;


	public Draw(){
		monster1 = new Monster(200, 200);
		monster2 = new Monster(300, 200);
		monster3 = new Monster(400, 200);
		monster4 = new Monster(200, 300);
		monster5 = new Monster(300, 300);
		monster6 = new Monster(400, 300);

		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){
		state++;

		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}


			}
		});
		thread1.start();
	}

	public void attack(){
		attackAnimation();
	}

	public void moveUp(){
		y = y - 5;
		reloadImage();
		repaint();
	}

	public void moveDown(){
		y = y + 5;
		reloadImage();
		repaint();
	}

	public void moveLeft(){
		x = x - 5;
		reloadImage();
		repaint();
	}

	public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);

		g.drawImage(monster1.image, monster1.xPos, monster1.yPos, this);
		g.drawImage(monster2.image, monster2.xPos, monster2.yPos, this);
		g.drawImage(monster3.image, monster3.xPos, monster3.yPos, this);
		g.drawImage(monster4.image, monster4.xPos, monster4.yPos, this);
		g.drawImage(monster5.image, monster5.xPos, monster5.yPos, this);
		g.drawImage(monster6.image, monster6.xPos, monster6.yPos, this);
		
		
	}
}