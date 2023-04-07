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

// 1.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
// FISH 2 AND MINI FISH 1 BOUNCE AFTER THE PICTURE CHANGE. FISH 2 = EMOJIPIC.
// ONCE THIS BOUNCE HAPPENS PUT GAME OVER SIGN AS BACKGROUND

//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    //Sets the width and height of the program window
    final int WIDTH = 1000;


    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too
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
    public Image minifish5Pic;
    public Image minifish6Pic;
    public Image minifish7Pic;
    public Image coralPic;
    public Image coral2Pic;
    public Image background;
    public Image minifish8pic;
    public Image wrapfishPic;
    public Image wrapfish2Pic;

    //Declare the objects used in the program
    //These are things that are made up of more than one variable type

    private final Astronaut astro;
    private final Astronaut Jack;
    private final Astronaut emoji;
    private Astronaut fish1;
    private Astronaut fish2;
    private final Astronaut fish3;
    private final Astronaut fish4;
    private final Astronaut minifish1;
    private final Astronaut minifish2;
    private final Astronaut minifish3;
    // declare controlled Astro
    private final Astronaut minifish5;
    private final Astronaut wrapfish;
    private final Astronaut minifish6;
    private final Astronaut minifish7;
    private final Astronaut coral;
    private final Astronaut coral2;
    private final Astronaut wrapfish2;
    private boolean gameover;

public ArrayFish[] minifish8;








    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.

    public BasicGameApp() {

        setUpGraphics();
       canvas.addKeyListener(this);
        minifish8 = new ArrayFish[20];

        for(int x=0; x<minifish8.length;x++) {
            minifish8 [x] = new ArrayFish(400,300);
            minifish8pic = Toolkit.getDefaultToolkit().getImage("arrayfish.jpeg");
            minifish8[x]= new ArrayFish((int) (Math.random()*300) + 500, (int) (Math.random()*300)+300);

        }
        //variable and objects
        //create (construct) the objects needed for the game and load up
        astroPic = Toolkit.getDefaultToolkit().getImage("fish 1.png");
        emojiPic = Toolkit.getDefaultToolkit().getImage("fish 2.png");//load the picture
        fish3Pic = Toolkit.getDefaultToolkit().getImage("fish 3.png");
        fish4Pic = Toolkit.getDefaultToolkit().getImage("fish 4.png");
        minifish1Pic = Toolkit.getDefaultToolkit().getImage("mini fish 1.png");
        minifish2Pic = Toolkit.getDefaultToolkit().getImage("mini fish 2.png");
        minifish3Pic = Toolkit.getDefaultToolkit().getImage("mini fish 3.png");
        minifish5Pic = Toolkit.getDefaultToolkit().getImage("minifish5.png");
        minifish6Pic = Toolkit.getDefaultToolkit().getImage("minifish6.png");
        minifish7Pic = Toolkit.getDefaultToolkit().getImage("minifish7.jpeg");
        coralPic = Toolkit.getDefaultToolkit().getImage("coral.jpeg");
        coral2Pic = Toolkit.getDefaultToolkit().getImage("coral2.jpeg");
        minifish8pic = Toolkit.getDefaultToolkit().getImage("arrayfish.jpeg");
        wrapfishPic = Toolkit.getDefaultToolkit().getImage("wrapfish.jpeg");
        wrapfish2Pic = Toolkit.getDefaultToolkit().getImage("download.png");
        // = Toolkit.getDefaultToolkit().getImage("arrayfish.jpeg");
        gameover=false;
        astro = new Astronaut(10, 100);
        Jack = new Astronaut(10, 200);
        fish3 = new Astronaut(30, 300);
        fish4 = new Astronaut(10, 500);
        minifish1 = new Astronaut(30, 200);
        minifish2 = new Astronaut(10, 100);
        minifish3 = new Astronaut(10, 100);
        // contruct aray to hold astro with x to make different slots
        // for(intx=o;x<minifish3astro[10];

        minifish5 = new Astronaut(600, 100);
        minifish6 = new Astronaut(500, 200);
        minifish7 = new Astronaut(700, 100);
        coral = new Astronaut(1000, 600);
        coral2 = new Astronaut(900, 400);
        wrapfish = new Astronaut(500,200);
        wrapfish2 = new Astronaut(300,250);

        Jack.dx = 1;
        Jack.dy = 8;
        emoji = new Astronaut(200, 100);
        //emoji = new Astronaut(50,200);
        background = Toolkit.getDefaultToolkit().getImage("realocean.jpeg"); //load the picture
        emoji.dx = 2;
        emoji.dy = 8;


    }// BasicGameApp()

    // Main method definition
    // This is the code that runs first and automatically


    public static void main(String[] args) {


        BasicGameApp ex = new BasicGameApp();
        new Thread(ex).start();//creates a new instance of the game
        //creates a threads & starts up the code in the run( ) method

    }
    public void crash() {
        System.out.println(Jack.xpos + "y:" + Jack.ypos);
        //if(Jack.rec.intersects(astro.rec) && Jack.isAlive == true && astro.isAlive == true)if (Jack.rec.intersects(minifish3.rec) && Jack.isAlive == true && minifish3.isAlive == true) {


        if (Jack.rec.intersects(minifish2.rec) && Jack.isAlive == true && minifish2.isAlive == true) {
            astroPic = fish4Pic;
            System.out.println("crash");
            astro.dx = -1 * astro.dx;
            astro.dy = -astro.dy;
            Jack.dx = -1 * astro.dx;
            Jack.dy = -Jack.dy;
            Jack.isAlive = false;
            gameover = true;

        }


        if (emoji.rec.intersects(astro.rec) && emoji.isAlive == true && astro.isAlive == true) {
            System.out.println("crash2");
            emoji.dx = -1 * emoji.dx;
            emoji.dy = -emoji.dy;
            astro.dx = -1 * astro.dx;
            astro.dy = -astro.dy;
            //     astro.isAlive = false;
        }
        System.out.println(astro.xpos + " astro y:" + astro.ypos);
        System.out.println(minifish1.xpos + " fish y:" + minifish1.ypos);


        if (emoji.rec.intersects(minifish1.rec)) {
            System.out.println("crash3");
            emoji.dx = -1 * emoji.dx;
            emoji.dy = -emoji.dy;
            minifish1.dx = -1 * minifish1.dx;
            minifish1.dy = -minifish1.dy;


        }

    }


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
        wrapfish.wrap();
        wrapfish2.wrap();
        minifish2.bounce();
        minifish3.bounce();
        minifish5.bounce();
        minifish6.bounce();
        minifish7.bounce();
       // wrap();


        for(int x=0; x<minifish8.length; x = x+1){
            minifish8[x].move();
        }



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
canvas.addMouseListener(this);
canvas.addMouseMotionListener(this);
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
        if(gameover==true)  {
            background = Toolkit.getDefaultToolkit().getImage("gameover.png");
            g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        }
        else {
            g.clearRect(0, 0, WIDTH, HEIGHT);

            //draw the image of the astronaut
            g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
            //	g.drawImage(astroPic, astro.xpos, astro.ypos, astro.width, astro.height, null);



                    if (minifish3.isAlive == true && minifish1.isAlive == true) {
                        g.drawImage(astroPic, Jack.xpos, Jack.ypos, Jack.width, Jack.height, null);
                    }





            if (astro.isAlive == true) {
                g.drawImage(minifish1Pic, minifish1.xpos, minifish1.ypos, minifish1.width, minifish1.height, null);
            }
            if (Jack.isAlive == true) {
                g.drawImage(minifish2Pic, minifish2.xpos, minifish2.ypos, minifish2.width, minifish2.height, null);
            }

            if (astro.isAlive == true) {
                g.drawImage(minifish3Pic, minifish3.xpos, minifish3.ypos, minifish3.width, minifish3.height, null);
            }
            g.drawImage(fish3Pic, fish3.xpos, fish3.ypos, fish3.width, fish3.height, null);


            //g.drawImage(background, 1,1, WIDTH, HEIGHT, null);
            if (astro.isAlive == true) {
                g.drawImage(emojiPic, emoji.xpos, emoji.ypos, emoji.width, emoji.height, null);
            }

            g.drawImage(minifish5Pic, minifish5.xpos, minifish5.ypos, minifish5.width, minifish5.height, null);
            g.drawImage(minifish6Pic, minifish6.xpos, minifish6.ypos, minifish6.width, minifish6.height, null);
            g.drawImage(minifish7Pic, minifish7.xpos, minifish7.ypos, minifish7.width, minifish7.height, null);
            g.drawImage(coralPic, coral.xpos, coral.ypos, coral.width, coral.height, null);
            g.drawImage(coral2Pic, coral2.xpos, coral2.ypos, coral2.width, coral2.height, null);
            g.drawImage(wrapfishPic, wrapfish.xpos, wrapfish.ypos, wrapfish.width, wrapfish.height, null);
            g.drawImage(wrapfish2Pic, wrapfish2.xpos, wrapfish2.ypos, wrapfish2.width, wrapfish2.height, null);;

            for(int x=0; x<minifish8.length;x++) {
            g.drawImage(minifish8pic,minifish8[x].xpos,minifish8[x].ypos,minifish8[x].width,minifish8[x].height,null);

            }
        }
        //g.draw(new Rectangle(astro.xpos, astro.ypos, astro.height, astro.width));
        g.dispose();
        bufferStrategy.show();

      //   background = Toolkit.getDefaultToolkit().getImage("gameover.png");

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
int code = e.getKeyCode();
System.out.println(code);
if(code == 32) { // space bar makes it move down
    minifish1.dy = 2;
}
    if(code == 68)
        minifish1.dx = 23;
    if(code == 65)
        minifish1.dx = 32;
    if(code == 83)
        minifish1.dx = 39;

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
        minifish1.xpos = e.getX();
      // minifish1.ypos = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
minifish1.width = 200;
minifish1.height = 100;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
minifish1.width = 60;
minifish1.height = 60;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX());
        minifish1.xpos = e.getX();
    }


//public void wrap(){

    //    for(int x=0; x<1001; x++){
     //       wrapfish.dx = x;
      //      x++;
      //      if(wrapfish.dx > HEIGHT){
      //          wrapfish.dx = 0;
         //   }
  //  }
}








//isalive use for game

