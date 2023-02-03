//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

	public void crash() {
		System.out.println(Jack.xpos + "y:" + Jack.ypos);
		//if(Jack.rec.intersects(astro.rec) && Jack.isAlive == true && astro.isAlive == true)
		if (Jack.rec.intersects(minifish3.rec) && Jack.isAlive == true && minifish3.isAlive == true){}

			if (Jack.rec.intersects(minifish2.rec) && Jack.isAlive == true && minifish2.isAlive == true) {
				astroPic = fish4Pic;
				System.out.println("crash");
				astro.dx = -1 * astro.dx;
				astro.dy = -astro.dy;
				Jack.dx = -1 * astro.dx;
				Jack.dy = -Jack.dy;
				Jack.isAlive = false;


			}


		if (emoji.rec.intersects(astro.rec)) {
			emoji.dx = -1 * emoji.dx;
			emoji.dy = -emoji.dy;
			astro.dx = -1 * astro.dx;
			astro.dy = -astro.dy;


		}

	}


	//Variable Definition Section
	//Declare the variables used in the program
	//You can set their initial values too

	//Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 700;

	//Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
	public JPanel panel;

	public BufferStrategy bufferStrategy;
	public Image astroPic; // fish 1
	public Image emojiPic; // fish 2
	public Image fish3Pic;
	public Image fish4Pic;
	public Image minifish1Pic;
	public Image minifish2Pic;
	public Image minifish3Pic;


	public Image background;

	//Declare the objects used in the program
	//These are things that are made up of more than one variable type
	private Astronaut astro;
	private Astronaut Jack;
	private Astronaut emoji;
	private Astronaut fish1;
	private Astronaut fish2;
	private Astronaut fish3;
	private Astronaut fish4;
	private Astronaut minifish1;
	private Astronaut minifish2;
	private Astronaut minifish3;

	// Main method definition
	// This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method  
	}


	// Constructor Method
	// This has the same name as the class
	// This section is the setup portion of the program
	// Initialize your variables and construct your program objects here.
	public BasicGameApp() {

		setUpGraphics();

		//variable and objects
		//create (construct) the objects needed for the game and load up
		astroPic = Toolkit.getDefaultToolkit().getImage("fish 1.png");
		emojiPic = Toolkit.getDefaultToolkit().getImage("fish 2.png");//load the picture
		fish3Pic = Toolkit.getDefaultToolkit().getImage("fish 3.png");
		fish4Pic = Toolkit.getDefaultToolkit().getImage("fish 4.png");
		minifish1Pic = Toolkit.getDefaultToolkit().getImage("mini fish 1.png");
		minifish2Pic = Toolkit.getDefaultToolkit().getImage("mini fish 2.png");
		minifish3Pic = Toolkit.getDefaultToolkit().getImage("mini fish 3.png");
		astro = new Astronaut(10, 100);
		Jack = new Astronaut(10, 200);
		fish3 = new Astronaut(10, 100);
		fish4 = new Astronaut(10, 500);
		minifish1 = new Astronaut(30, 200);
		minifish2 = new Astronaut(10, 100);
		minifish3 = new Astronaut(10, 100);

		Jack.dx = 1;
		Jack.dy = 8;
		emoji = new Astronaut(200, 100);
		//emoji = new Astronaut(50,200);
		background = Toolkit.getDefaultToolkit().getImage("realocean.jpeg"); //load the picture
		emoji.dx = 2;
		emoji.dy = 8;


	}// BasicGameApp()


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

	// main thread
	// this is the code that plays the game after you set things up
	public void run() {

		//for the moment we will loop things forever.
		while (true) {

			moveThings();
			//move all the game objects
			render();  // paint the graphics
			pause(15); // sleep for 10 ms

		}
	}


	public void moveThings() {
		//calls the move( ) code in the objects
		//astro.bounce();
		Jack.bounce();
		emoji.bounce();
		fish3.bounce();
		fish4.bounce();
		minifish1.bounce();
		minifish2.bounce();
		minifish3.bounce();
		crash();
	}

	//Pauses or sleeps the computer for the amount specified in milliseconds
	public void pause(int time) {
		//sleep
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

		}
	}

	//Graphics setup method
	private void setUpGraphics() {
		frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

		panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
		panel.setLayout(null);   //set the layout

		// creates a canvas which is a blank rectangular area of the screen onto which the application can draw
		// and trap input events (Mouse and Keyboard events)
		canvas = new Canvas();
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		canvas.setIgnoreRepaint(true);

		panel.add(canvas);  // adds the canvas to the panel.

		// frame operations
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
		frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
		frame.setResizable(false);   //makes it so the frame cannot be resized
		frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

		// sets up things so the screen displays images nicely.
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		canvas.requestFocus();
		System.out.println("DONE graphic setup");

	}


	//paints things on the screen using bufferStrategy
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);

		//draw the image of the astronaut
		g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
		//	g.drawImage(astroPic, astro.xpos, astro.ypos, astro.width, astro.height, null);
		{

			{
				if (minifish3.isAlive == true && minifish1.isAlive == true)
					{	g.drawImage(astroPic, Jack.xpos, Jack.ypos, Jack.width, Jack.height, null);}

			}
		}

		 if (astro.isAlive == true)
		{g.drawImage(minifish1Pic, minifish1.xpos, minifish1.ypos, minifish1.width, minifish1.height, null);}
			if (Jack.isAlive == true)
			{		g.drawImage(minifish2Pic, minifish2.xpos, minifish2.ypos, minifish2.width, minifish2.height, null);}

					g.drawImage(minifish3Pic, minifish3.xpos, minifish3.ypos, minifish3.width, minifish3.height, null);


				//g.drawImage(background, 1,1, WIDTH, HEIGHT, null);

				g.drawImage(emojiPic, emoji.xpos, emoji.ypos, emoji.width, emoji.height, null);


				//g.draw(new Rectangle(astro.xpos, astro.ypos, astro.height, astro.width));
				g.dispose();

				bufferStrategy.show();

			}
		}








	//isalive use for game

